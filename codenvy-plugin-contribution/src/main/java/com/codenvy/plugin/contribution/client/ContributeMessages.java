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
package com.codenvy.plugin.contribution.client;

import com.google.gwt.i18n.client.Messages;

/**
 * Internationalizable messages for the contributor plugin.
 */
public interface ContributeMessages extends Messages {
    @Key("contributor.button.name")
    String contributorButtonName();

    @Key("contributor.button.description")
    String contributorButtonDescription();

    @DefaultMessage("You need to provide the contribution branch name")
    String warnBranchEmpty();

    @DefaultMessage("Incorrect or missing information")
    String warnMissingConfigTitle();

    @DefaultMessage("Could not list local branches. Contribution interrupted")
    String errorListBranches();

    @DefaultMessage("A branch with this name already exists: {0}")
    String errorBranchExists(String name);

    @DefaultMessage("Branch rename failed. Contribution interrupted")
    String errorRenameFailed();

    @DefaultMessage("Adding fork remote failed. Contribution interrupted")
    String errorAddRemoteFailed();

    @DefaultMessage("Contribution branch renamed to {0}")
    String infoRenamedBranch(String branchName);

    /*
     * Commit dialog
     */
    @Key("commit.dialog.title")
    String commitDialogTitle();

    @Key("commit.dialog.message")
    String commitDialogMessage();

    @Key("commit.dialog.description.title")
    String commitDialogDescriptionTitle();

    @Key("commit.dialog.button.ok.text")
    String commitDialogButtonOkText();

    @Key("commit.dialog.button.continue.text")
    String commitDialogButtonContinueText();

    /*
     * Pre-contribute wizard
     */
    @DefaultMessage("Configure Contribution")
    String preContributeWizardTitle();

    @DefaultMessage("Branch Name:")
    String preContributeWizardBranchNameInputLabelText();

    @DefaultMessage("Choose a branch name for your contribution...")
    String preContributeWizardBranchNameInputPlaceHolder();

    @DefaultMessage("Contribution Title:")
    String preContributeWizardContributionTitleLabelText();

    @DefaultMessage("Choose a title for your contribution...")
    String preContributeWizardContributionTitlePlaceHolder();

    @DefaultMessage("Contribution Comment:")
    String preContributeWizardContributionCommentLabelText();

    @DefaultMessage("Type a comment for your contribution...")
    String preContributeWizardContributionCommentPlaceHolder();

    @DefaultMessage("Contribute")
    String preContributeWizardContributeButton();

    @DefaultMessage("Cancel")
    String preContributeWizardCancelButton();

    /**
     * prefix notification message with "Contribute Pull Request"
     */
    @DefaultMessage("Contribute Pull Request: {0}")
    String prefixNotification(String notificationMessage);

    @DefaultMessage("Cannot access to VCS Host services. Check if OAuth popup is not blocked")
    String cannotAccessVCSHostServices();

    @DefaultMessage("Using existing user''s fork")
    String useExistingUserFork();

    @DefaultMessage("Creating a fork the repository`{0}/{1}`")
    String creatingFork(String username, String repository);

    @DefaultMessage("Requested creation of a fork of the repository `{0}/{1}`")
    String requestedForkCreation(String repositoryOwner, String repositoryName);

    @DefaultMessage("Failed creating the fork of the repository`{0}/{1}`. {2}")
    String failedCreatingUserFork(String repositoryOwner, String repositoryName, String message);

    @DefaultMessage("Successfully pushed contribution branch to fork")
    String successPushingBranchToFork();

    @DefaultMessage("Pushing contribution branch to fork")
    String pushingWorkingBranchToFork();

    @DefaultMessage("Failed pushing contribution branch to fork: {0}")
    String failedPushingBranchToFork(String cause);

    @DefaultMessage("You can review this pull request by following this link: {0}")
    String pullRequestlinkComment(String factoryUrl);

    @DefaultMessage("Could not post review factory link in pull request comments: {0}")
    String warnPostFactoryLinkFailed(String factoryUrl);

    @DefaultMessage("Could not create review factory link")
    String warnCreateFactoryFailed();

    @DefaultMessage("Remote with name {0} already exists")
        // period because that's a log, not a notification
    String forekRemoteAlreadyPresent(String forkRemoteName);

    @DefaultMessage("Failed to set the forked repository remote. Contribution interrupted")
    String errorRemoveRemoteFailed();

    @DefaultMessage("Could not check the remotes")
    String warnCheckRemote();

    @DefaultMessage("Creation of the pull request failed. Contribution is interrupted")
    String errorPullRequestFailed();

    @DefaultMessage("Creating the pull request for your contribution")
    String issuingPullRequest();

    @DefaultMessage("The Pull Request for your contribution has been created. {0}")
    String successIssuingPullRequest(String url);

    @DefaultMessage("Creating a new working branch {0}")
    String notificationCreatingNewWorkingBranch(String workingBranchName);

    @DefaultMessage("Branch {0} successfully created and checked out")
    String notificationBranchSuccessfullyCreatedAndCheckedOut(String workingBranchName);

}
