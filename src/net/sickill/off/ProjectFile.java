/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sickill.off;

import javax.swing.Icon;

/**
 *
 * @author kill
 */
public abstract class ProjectFile {
    private ProjectProvider projectProvider;

    public abstract int getGroupPriority();
    public abstract Icon getIcon();
    public abstract String getName();
    public abstract String getFullPath();
    public abstract long getSize();

    public ProjectFile(ProjectProvider pp) {
        this.projectProvider = pp;
    }

    public String getDirectory() {
        String fullPath = getFullPath();
        int start = projectProvider.getProjectRootPath().length() + 1;
        int end = fullPath.length() - getName().length() - 1;
        return fullPath.substring(start, end);
    }

    public String getPathInProject() {
        return getDirectory() + "/" + getName();
    }
}
