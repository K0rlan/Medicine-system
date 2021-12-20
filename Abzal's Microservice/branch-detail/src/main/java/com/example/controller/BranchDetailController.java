package com.example.controller;

import com.example.services.DetailBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class BranchDetailController {
    @Autowired
    private DetailBranchService detailBranchService;

    @GetMapping("")
    public ResponseEntity<?> getAllCompletedOrder() {
        return ResponseEntity.ok(detailBranchService.getAllDetailBranch());
    }
}
