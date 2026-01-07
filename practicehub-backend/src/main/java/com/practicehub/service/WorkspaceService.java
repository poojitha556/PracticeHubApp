package com.practicehub.service;

import com.practicehub.entity.Workspace;
import com.practicehub.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WorkspaceService {

    private final WorkspaceRepository repo;

    public WorkspaceService(WorkspaceRepository repo) {
        this.repo = repo;
    }

    // already working – DO NOT TOUCH
    public void save(String username, String workspaceJson) {
        Workspace ws = repo.findByUsername(username)
                .orElse(new Workspace(username));

        ws.setWorkspace(workspaceJson);
        repo.save(ws);
    }

    // already required
    public Workspace findByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    // ✅ ADD THIS METHOD (for share)
    public String generateShareLink(String username) {
        Workspace ws = repo.findByUsername(username)
                .orElseThrow();

        if (ws.getShareId() == null) {
            ws.setShareId(UUID.randomUUID().toString());
            repo.save(ws);
        }
        return ws.getShareId();
    }
}
