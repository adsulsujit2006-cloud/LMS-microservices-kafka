
package com.loan_management_system_user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_management_system_user.dto.request.CreateRoleRequest;
import com.loan_management_system_user.dto.responce.RoleResponse;
import com.loan_management_system_user.services.RoleServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
@Slf4j
public class RoleController {

    /*
     * Create instance of RoleServices class
     */
    private final RoleServices roleServices;

    /*
     * REST API : Register Role with required details
     */
    @PostMapping
    public ResponseEntity<RoleResponse> createRole(
            @Valid @RequestBody CreateRoleRequest request) {

        /*
         * Add log
         */
        log.info("REST Request: Create Role");

        /*
         * To call services layer method
         */
        RoleResponse roleResponse = roleServices.createRole(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleResponse);
    }

}
