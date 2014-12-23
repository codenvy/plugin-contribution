/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.plugin.contribution.client.dialogs.contribute;

import javax.inject.Inject;

import com.codenvy.ide.ui.window.Window;
import com.codenvy.plugin.contribution.client.ContributeMessages;
import com.codenvy.plugin.contribution.client.dialogs.paste.PasteEvent;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Implementation of {@link PreContributeWizardView}.
 */
public class PreContributeWizardViewImpl extends Window implements PreContributeWizardView {

    /** The uUI binder for this component. */
    private static final PreContributeWizardViewUiBinder UI_BINDER = GWT.create(PreContributeWizardViewUiBinder.class);

    /** The input component for the branch name. */
    @UiField
    TextBox branchName;

    /** The input component for the contribution title. */
    @UiField
    TextBox contribTitle;

    /**
     * The input zone for the pull request comment.
     */
    @UiField
    TextArea pullRequestComment;

    /**
     * The contribute button.
     */
    @UiField
    Button contributeButton;

    /**
     * The cancel button.
     */
    @UiField
    Button cancelButton;

    /**
     * The i18n messages.
     */
    @UiField(provided = true)
    ContributeMessages messages;

    /**
     * The bound delegate.
     */
    private ActionDelegate delegate;

    @Inject
    public PreContributeWizardViewImpl(final ContributeMessages messages) {
        this.messages = messages;
        setWidget(UI_BINDER.createAndBindUi(this));

        setTitle(messages.preContributeWizardTitle());

        this.branchName.getElement().setPropertyString("placeholder", messages.branchNameInputPlaceHolder());
        this.pullRequestComment.getElement().setPropertyString("placeholder", messages.pullRequestCommentPlaceHolder());
    }

    @Override
    public void reset() {
        branchName.setValue(this.delegate.suggestBranchName());
        this.pullRequestComment.setValue("");
        this.delegate.updateControls();
    }

    @Override
    protected void onClose() {
    }

    @Override
    public void setDelegate(final ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getBranchName() {
        return this.branchName.getValue();
    }

    @Override
    public String getPullRequestComment() {
        return this.pullRequestComment.getValue();
    }

    @Override
    public String getContribTitle() {
        return this.contribTitle.getValue();
    }

    @Override
    public void setContributeEnabled(final boolean enabled) {
        this.contributeButton.setEnabled(enabled);
    }

    @UiHandler("contributeButton")
    public void contributeClicked(final ClickEvent event) {
        this.delegate.onContributeClicked();
    }

    @UiHandler("cancelButton")
    public void cancelClicked(final ClickEvent event) {
        this.delegate.onCancelClicked();
    }

    @UiHandler("branchName")
    public void branchNameChanged(final ValueChangeEvent<String> event) {
        this.delegate.updateControls();
    }

    @UiHandler("branchName")
    public void branchNameKeyUp(final KeyUpEvent event) {
        this.delegate.updateControls();
    }

    @UiHandler("branchName")
    public void branchNamePaste(final PasteEvent event) {
        this.delegate.updateControls();
    }

    @UiHandler("pullRequestComment")
    public void pullRequestCommentChanged(final ValueChangeEvent<String> event) {
        this.delegate.updateControls();
    }

    @UiHandler("contribTitle")
    public void contribTitleChanged(final ValueChangeEvent<String> event) {
        this.delegate.updateControls();
    }

    @UiHandler("contribTitle")
    public void contribTitleKeyUp(final KeyUpEvent event) {
        this.delegate.updateControls();
    }

    @UiHandler("contribTitle")
    public void contribTitlePaste(final PasteEvent event) {
        this.delegate.updateControls();
    }

    @Override
    public void show() {
        super.show(this.branchName.getElement().<InputElement>cast());
    }
}
