
package com.loan_management_system_user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan_management_system_user.dto.request.CreateRoleRequest;
import com.loan_management_system_user.dto.request.UpdateRoleRequest;
import com.loan_management_system_user.dto.responce.ApiResponse;
import com.loan_management_system_user.dto.responce.RoleResponse;
import com.loan_management_system_user.exception.DuplicateResourceException;
import com.loan_management_system_user.mapper.RoleMapper;
import com.loan_management_system_user.modal.Role;
import com.loan_management_system_user.repository.RoleRepository;
import com.loan_management_system_user.services.RoleServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RoleServicesImpl implements RoleServices {

    /*
     * instance of RoleRepo class
     */
    @Autowired
    private RoleRepository roleRepository;

    /*
     * instance of RoleMapper class
     */
    @Autowired
    private RoleMapper roleMapper;

    /*
     * This implemented method is create Role
     */
    @Override
    public RoleResponse createRole(CreateRoleRequest request) {

        /*
         * Add log
         */
        log.info("Creating new Role with Role name {} ", request.getRoleName());

        /*
         * Check Role duplicate or not
         */
        if (roleRepository.existsByRoleName(request.getRoleName())) {
            throw new DuplicateResourceException(
                    "Role already exists : " + request.getRoleName());
        }

        /*
         * Map request to Entity
         */
        Role role = roleMapper.toEntity(request);

        /*
         * set Role by default Active
         */
        role.setActive(true);

        /*
         * save in DB
         */
        Role savedRole = roleRepository.save(role);

        log.info("Add Role successfully");

        return roleMapper.toResponse(savedRole);
    }

    @Override
    public RoleResponse updateRole(Long id, UpdateRoleRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RoleResponse getRoleById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RoleResponse> getAllRole() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiResponse deleteRole(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiResponse ActiveRole(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ApiResponse deActivateRole(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
