
package com.loan_management_system_user.mapper;

import org.mapstruct.Mapper;

import com.loan_management_system_user.dto.request.CreateRoleRequest;
import com.loan_management_system_user.dto.responce.RoleResponse;
import com.loan_management_system_user.modal.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toResponse(Role role);

    Role toEntity(CreateRoleRequest request);
}
