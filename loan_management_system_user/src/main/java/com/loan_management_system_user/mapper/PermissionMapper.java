package com.loan_management_system_user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.loan_management_system_user.dto.request.CreatePermissionRequest;
import com.loan_management_system_user.dto.request.UpdatePermissionRequest;
import com.loan_management_system_user.dto.responce.PermissionResponse;
import com.loan_management_system_user.modal.Permission;


@Mapper(componentModel = "spring")
public interface PermissionMapper {
	Permission toEntity(CreatePermissionRequest request);

    Permission toEntity(UpdatePermissionRequest request);

    PermissionResponse toResponse(Permission permission);

    List<PermissionResponse> toResponseList(List<Permission> permissions);

}