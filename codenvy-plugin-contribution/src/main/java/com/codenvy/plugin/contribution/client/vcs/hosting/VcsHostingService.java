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
package com.codenvy.plugin.contribution.client.vcs.hosting;

import com.codenvy.plugin.contribution.client.vcs.hosting.dto.HostUser;
import com.codenvy.plugin.contribution.client.vcs.hosting.dto.IssueComment;
import com.codenvy.plugin.contribution.client.vcs.hosting.dto.PullRequest;
import com.codenvy.plugin.contribution.client.vcs.hosting.dto.Repository;
import com.google.gwt.user.client.rpc.AsyncCallback;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Represents a repository host
 */
public interface VcsHostingService {
    /**
     * Checks if the given remote URL is hosted by this hosting service.
     *
     * @param remoteUrl
     *         the remote url to check.
     * @return {@code true} if the given remote url is hosted by this service, {@code false} otherwise.
     */
    boolean isVcsHostRemoteUrl(@Nonnull String remoteUrl);

    /**
     * Get a pull request by qualified name.
     *
     * @param owner
     *         the owner.
     * @param repository
     *         the repository name.
     * @param headBranch
     *         qualified name of pull request
     * @param callback
     *         callback called when operation is done.
     */
    void getPullRequest(@Nonnull String owner, @Nonnull String repository, @Nonnull String headBranch,
                        @Nonnull AsyncCallback<PullRequest> callback);

    /**
     * Add a comment to a pull request.
     *
     * @param username
     *         the username of the owner.
     * @param repository
     *         the repository name.
     * @param pullRequestId
     *         the id f the pull request.
     * @param commentText
     *         the text of the comment.
     * @param callback
     *         callback called when operation is done.
     */
    void commentPullRequest(@Nonnull String username,
                            @Nonnull String repository,
                            @Nonnull String pullRequestId,
                            @Nonnull String commentText,
                            @Nonnull AsyncCallback<IssueComment> callback);

    /**
     * Creates a pull request.
     *
     * @param owner
     *         the repository owner.
     * @param repository
     *         the repository name.
     * @param title
     *         the pull request title.
     * @param headBranch
     *         the head branch.
     * @param baseBranch
     *         the base branch.
     * @param body
     *         the pull request body.
     * @param callback
     *         callback called when operation is done.
     */
    void createPullRequest(@Nonnull String owner,
                           @Nonnull String repository,
                           @Nonnull String title,
                           @Nonnull String headBranch,
                           @Nonnull String baseBranch,
                           @Nonnull String body,
                           @Nonnull AsyncCallback<PullRequest> callback);

    /**
     * Forks the given repository for the current user.
     *
     * @param owner
     *         the repository owner.
     * @param repository
     *         the repository name.
     * @param callback
     *         callback called when operation is done.
     */
    void fork(@Nonnull String owner, @Nonnull String repository, @Nonnull AsyncCallback<Repository> callback);

    /**
     * Returns the information of the given repository.
     *
     * @param owner
     *         the repository owner.
     * @param repository
     *         the repository name.
     */
    void getRepository(@Nonnull String owner, @Nonnull String repository, @Nonnull AsyncCallback<Repository> callback);

    /**
     * Returns the user repositories on the repository host.
     *
     * @param callback
     *         callback called when operation is done.
     */
    void getRepositories(@Nonnull AsyncCallback<List<Repository>> callback);

    /**
     * Returns the repository name from the given url.
     *
     * @param url
     *         the url.
     * @return the repository name, never {@code null}.
     */
    @Nonnull
    String getRepositoryNameFromUrl(@Nonnull String url);

    /**
     * Returns the repository owner from the given url.
     *
     * @param url
     *         the url.
     * @return the repository owner, never {@code null}.
     */
    @Nonnull
    String getRepositoryOwnerFromUrl(@Nonnull String url);

    /**
     * Returns the repository fork of the given user.
     *
     * @param user
     *         the  user.
     * @param owner
     *         the repository owner.
     * @param repository
     *         the repository name.
     * @param callback
     *         callback called when operation is done.
     */
    void getUserFork(@Nonnull String user, @Nonnull String owner, @Nonnull String repository, @Nonnull AsyncCallback<Repository> callback);

    /**
     * Returns the user information on the repository host.
     *
     * @param callback
     *         callback called when operation is done.
     */
    void getUserInfo(@Nonnull AsyncCallback<HostUser> callback);

    /**
     * Makes the remote SSH url for the given username and repository.
     *
     * @param username
     *         the user name.
     * @param repository
     *         the repository name.
     * @return the remote url, never {@code null}.
     */
    @Nonnull
    String makeSSHRemoteUrl(@Nonnull String username, @Nonnull String repository);

    /**
     * Makes the remote HTTP url for the given username and repository.
     *
     * @param username
     *         the user name.
     * @param repository
     *         the repository name.
     * @return the remote url, never {@code null}.
     */
    @Nonnull
    String makeHttpRemoteUrl(@Nonnull String username, @Nonnull String repository);

    /**
     * Makes the pull request url for the given username, repository and pull request number.
     *
     * @param username
     *         the user name.
     * @param repository
     *         the repository name.
     * @param pullRequestNumber
     *         the pull request number.
     * @return the remote url, never {@code null}.
     */
    @Nonnull
    String makePullRequestUrl(@Nonnull String username, @Nonnull String repository, @Nonnull String pullRequestNumber);
}
