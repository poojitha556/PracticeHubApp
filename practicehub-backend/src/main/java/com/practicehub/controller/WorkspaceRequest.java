package com.practicehub.controller;

public class WorkspaceRequest {
    private String workspace;

    public WorkspaceRequest() {}

    public WorkspaceRequest(String workspace) {
        this.workspace = workspace;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }
}
