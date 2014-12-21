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
package com.codenvy.plugin.contribution.client.steps;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.codenvy.plugin.contribution.client.contribdialog.FinishContributionOperation;
import com.codenvy.plugin.contribution.client.contribdialog.PreContributeWizardPresenter;
import com.codenvy.plugin.contribution.client.contribdialog.PreContributeWizardPresenterFactory;
import com.codenvy.plugin.contribution.client.value.Configuration;
import com.codenvy.plugin.contribution.client.value.Context;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

/**
 * Launches the user configuration interface for the contribution.
 */
public class ConfigureStep implements Step {

    /**
     * The factory for the contribute dialog component.
     */
    private final PreContributeWizardPresenterFactory configureWizardFactory;

    /**
     * The next step.
     */
    private final Step nextStep;

    @Inject
    public ConfigureStep(final PreContributeWizardPresenterFactory configureWizardFactory,
                         final RenameBranchStep renameBranchStep) {
        this.configureWizardFactory = configureWizardFactory;
        this.nextStep = renameBranchStep;
    }

    @Override
    public void execute(final Context context, final Configuration configuration) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                final FinishContributionOperation finish = new FinishContributionOperation() {
                    @Override
                    public void finishContribution(@Nonnull final Context context, @Nonnull final Configuration config) {
                        nextStep.execute(context, config);
                    }
                };
                final PreContributeWizardPresenter dialog = ConfigureStep.this.configureWizardFactory.create(finish,
                                                                                                             context,
                                                                                                             configuration);
                dialog.show();
            }
        });
    }
}
