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
package com.codenvy.plugin.contribution.client.value;

import com.codenvy.api.project.shared.dto.ProjectDescriptor;

/**
 * Contribution context, with information on current project, branch etc.
 */
public class Context {
    /** The project. */
    private ProjectDescriptor project;

    /**
     * The name of the working branch.
     */
    private String workBranchName;

    public ProjectDescriptor getProject() {
        return this.project;
    }

    public void setProject(ProjectDescriptor desc) {
        this.project = desc;
    }

    public Context withProject(ProjectDescriptor desc) {
        this.project = desc;
        return this;
    }

    public String getWorkBranchName() {
        return this.workBranchName;
    }

    public void setWorkBranchName(String name) {
        this.workBranchName = name;
    }

    public Context withWorkBranchName(String name) {
        this.workBranchName = name;
        return this;
    }
}
