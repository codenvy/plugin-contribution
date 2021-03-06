/*******************************************************************************
 * Copyright (c) 2014-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.plugin.contribution.client.dialogs.commit;

import org.eclipse.che.ide.api.mvp.View;

import javax.annotation.Nonnull;

/**
 * View for committing uncommitted project changes.
 *
 * @author Kevin Pollet
 */
public interface CommitView extends View<CommitView.ActionDelegate> {
    /**
     * Opens the commit view with the given commit description.
     */
    void show(String commitDescription);

    /**
     * Close the commit view.
     */
    void close();

    /**
     * Returns the current commit description.
     *
     * @return the current commit description.
     */
    @Nonnull
    String getCommitDescription();

    /**
     * Enables or disables the button OK.
     *
     * @param enabled
     *         {@code true} to enable the OK button, {@code false} otherwise.
     */
    void setOkButtonEnabled(final boolean enabled);

    /**
     * Returns if the untracked files must be added.
     *
     * @return {@code true} if untracked files must be added, {@code false} otherwise.
     */
    boolean isIncludeUntracked();

    /**
     * The action delegate.
     */
    interface ActionDelegate {
        /**
         * Called when project changes must be committed.
         */
        void onOk();

        /**
         * Called when project changes must not be committed.
         */
        void onContinue();

        /**
         * Called when the operation must be aborted.
         */
        void onCancel();

        /**
         * Called when the commit description is changed.
         */
        void onCommitDescriptionChanged();
    }
}
