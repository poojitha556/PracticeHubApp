package com.practicehub.controller;

import com.practicehub.entity.Workspace;
import com.practicehub.service.WorkspaceService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/workspace")
@CrossOrigin
public class WorkspaceController {

    private final WorkspaceService service;

    public WorkspaceController(WorkspaceService service) {
        this.service = service;
    }

    // SAVE
    @PostMapping("/{username}")
    public ResponseEntity<?> saveWorkspace(
            @PathVariable String username,
            @RequestBody Map<String, String> body
    ) {
        String workspaceJson = body.get("workspace");
        service.save(username, workspaceJson);
        return ResponseEntity.ok().build();
    }

    // LOAD
    @GetMapping("/{username}")
    public ResponseEntity<?> loadWorkspace(@PathVariable String username) {
        Workspace ws = service.findByUsername(username);
        return ResponseEntity.ok(ws);
    }
    
 // Generate share link
    @GetMapping("/share/{username}")
    public String generateShare(@PathVariable String username) {
    	return service.generateShareLink(username);

    }

    // Public workspace view (read-only)
    @GetMapping("/public/{username}/{shareId}")
    public Workspace viewShared(
            @PathVariable String username,
            @PathVariable String shareId) {

    	Workspace ws = service.findByUsername(username);
        if (ws == null || !shareId.equals(ws.getShareId())) {
            throw new RuntimeException("Invalid share link");
        }
        return ws;
    }

}
