
package com.loan_management_system_user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_management_system_user.dto.request.CreateBranchRequest;
import com.loan_management_system_user.dto.responce.BranchResponse;
import com.loan_management_system_user.services.BranchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
@Slf4j
public class BranchController {

    private final BranchService branchService;

    /*
     * REST API : Register bank branch with required details
     */
    @PostMapping("/register")
    public ResponseEntity<BranchResponse> createBranch(
            @RequestBody CreateBranchRequest request) {

        log.info("REST Request: Create Branch");

        BranchResponse response = branchService.createBranch(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}

