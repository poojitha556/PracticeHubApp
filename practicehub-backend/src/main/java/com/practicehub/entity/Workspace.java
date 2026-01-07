package com.practicehub.entity;

import jakarta.persistence.*;

@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String workspace;

    // ✅ ADD THIS
    private String shareId;

    public Workspace() {}

    public Workspace(String username) {
        this.username = username;
    }

    // getters & setters
    public Long getId() { return id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getWorkspace() { return workspace; }
    public void setWorkspace(String workspace) { this.workspace = workspace; }

    // ✅ ADD THESE
    public String getShareId() { return shareId; }
    public void setShareId(String shareId) { this.shareId = shareId; }
}
