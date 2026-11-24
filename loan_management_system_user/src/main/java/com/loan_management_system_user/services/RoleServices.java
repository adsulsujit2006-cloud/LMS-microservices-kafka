package com.loan_management_system_user.services;

import java.util.List;

import com.loan_management_system_user.dto.request.CreateRoleRequest;
import com.loan_management_system_user.dto.request.UpdateRoleRequest;
import com.loan_management_system_user.dto.responce.ApiResponse;
import com.loan_management_system_user.dto.responce.RoleResponse;

public interface RoleServices {
	
	public RoleResponse createRole(CreateRoleRequest request);

	public RoleResponse updateRole(Long id, UpdateRoleRequest request);

	public RoleResponse getRoleById(Long id);

	public List<RoleResponse> getAllRole();

	public ApiResponse deleteRole(Long id);

	public ApiResponse ActiveRole(Long id);

	public ApiResponse deActivateRole(Long id);


}
