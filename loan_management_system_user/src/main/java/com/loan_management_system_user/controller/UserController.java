package com.loan_management_system_user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_management_system_user.dto.request.UserRegistrationRequest;
import com.loan_management_system_user.dto.responce.UserResponse;
import com.loan_management_system_user.services.UserServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServices userServices;

    /*
     * REST API : Register user with required details
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRegistrationRequest request) {

        log.info("REST Request : create user");

        UserResponse response = userServices.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /*
     * REST API : Get the details of a user using its user ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable Long id) {

        log.info("REST Request : Get user by id {}", id);

        return ResponseEntity.ok(userServices.getUserById(id));
    }
}