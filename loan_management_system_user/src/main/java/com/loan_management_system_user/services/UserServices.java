package com.loan_management_system_user.services;

import java.util.List;

import javax.validation.Valid;

import com.loan_management_system_user.dto.request.LoginRequest;
import com.loan_management_system_user.dto.request.UpdateUserRequest;
import com.loan_management_system_user.dto.request.UserRegistrationRequest;
import com.loan_management_system_user.dto.responce.ApiResponse;
import com.loan_management_system_user.dto.responce.LoginResponse;
import com.loan_management_system_user.dto.responce.UserResponse;

public interface UserServices {
	public UserResponse createUser(UserRegistrationRequest request);
	public UserResponse updateUser(Long id,@Valid UpdateUserRequest request);
	public UserResponse getUserById(Long id);
	public UserResponse getUserByEmail(String email);
	public UserResponse getUserByMobail(String mobaile);
	public UserResponse getUserByAdharNo(String aadhaarNumber);
	public List<UserResponse> getAllUsers();
	public ApiResponse deleteUser(Long id);
	public ApiResponse activateUser(Long id);
	public ApiResponse deActivateUser(Long id);
	public LoginResponse login(LoginRequest request);

}
