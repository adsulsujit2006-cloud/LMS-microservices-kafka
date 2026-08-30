package com.loan_management_system_user.services.impl;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loan_management_system_user.dto.request.LoginRequest;
import com.loan_management_system_user.dto.request.UpdateUserRequest;
import com.loan_management_system_user.dto.request.UserRegistrationRequest;
import com.loan_management_system_user.dto.responce.ApiResponse;
import com.loan_management_system_user.dto.responce.LoginResponse;
import com.loan_management_system_user.dto.responce.UserResponse;
import com.loan_management_system_user.enums.RoleType;
import com.loan_management_system_user.exception.BadRequestException;
import com.loan_management_system_user.exception.DuplicateResourceException;
import com.loan_management_system_user.exception.ResourceNotFoundException;
import com.loan_management_system_user.mapper.BranchMapper;
import com.loan_management_system_user.mapper.UserMapper;
import com.loan_management_system_user.modal.Branch;
import com.loan_management_system_user.modal.Role;
import com.loan_management_system_user.modal.User;
import com.loan_management_system_user.repository.BranchRepository;
import com.loan_management_system_user.repository.RoleRepository;
import com.loan_management_system_user.repository.UserRepository;
import com.loan_management_system_user.services.UserServices;
import com.loan_management_system_user.util.CustomerCodeGenerator;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServicesImpl implements UserServices {

	/*
	 * instance of UserRepo
	 */
	@Autowired
	private UserRepository userRepository;
	/*
	 * instance of BranchRepo
	 */
	@Autowired
	private BranchRepository branchRepository;
	/*
	 * instance of UserMapper
	 */
	@Autowired
	private BranchMapper branchMapper;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	   @Autowired
//	    private NotificationClient notificationClient;
	/*
	 * This implemented method is Registor user
	 */
	   @Override
	   @Transactional
	   public UserResponse createUser(UserRegistrationRequest request) {

	       /*
	        * check request null or not
	        */
	       if (request == null) {
	           throw new BadRequestException(
	                   "Please enter appropriate information.");
	       }

	       /*
	        * Store original password before encoding
	        * This password will be used only for sending email
	        */
	       String originalPassword = request.getPassword();

	       /*
	        * Add log
	        */
	       log.info("Creating new user account with firstName {}",
	               request.getFirstName());

	       log.info("Creating new user account with middleName {}",
	               request.getMiddleName());

	       log.info("Creating new user account with lastName {}",
	               request.getLastName());

	       log.info("Creating new user account with dateOfBirth {}",
	               request.getDateOfBirth());

	       log.info("Creating new user account with gender {}",
	               request.getGender());

	       /*
	        * check user email exist or not in DB
	        */
	       if (userRepository.existsByEmail(request.getEmail())) {
	           throw new DuplicateResourceException(
	                   "Email already exists");
	       }

	       /*
	        * check user mobile number exist or not
	        */
	       if (userRepository.existsByMobileNumber(
	               request.getMobileNumber())) {

	           throw new DuplicateResourceException(
	                   "Mobile number already exists");
	       }

	       /*
	        * check aadhaar number exist or not
	        */
	       if (userRepository.existsByAadhaarNumber(
	               request.getAadhaarNumber())) {

	           throw new DuplicateResourceException(
	                   "Aadhaar number already exists");
	       }

	       /*
	        * check panNumber exist or not
	        */
	       if (userRepository.existsByPanNumber(
	               request.getPanNumber())) {

	           throw new DuplicateResourceException(
	                   "PAN number already exists");
	       }

	       /*
	        * Not permission for REPRESENTATIVE_EXECUTIVE role
	        */
	       if (request.getRole() == RoleType.REPRESENTATIVE_EXECUTIVE) {

	           throw new BadRequestException(
	                   "Not permission to add role");
	       }

	       /*
	        * Not permission for OPERATIONS_MANAGER role
	        */
	       if (request.getRole() == RoleType.OPERATIONS_MANAGER) {

	           throw new BadRequestException(
	                   "Not permission to add role");
	       }

	       /*
	        * Not permission for CREDIT_MANAGER role
	        */
	       if (request.getRole() == RoleType.CREDIT_MANAGER) {

	           throw new BadRequestException(
	                   "Not permission to add role");
	       }

	       /*
	        * Not permission for AUDITOR role
	        */
	       if (request.getRole() == RoleType.AUDITOR) {

	           throw new BadRequestException(
	                   "Not permission to add role");
	       }

	       /*
	        * Not permission for COLLECTION_AGENT role
	        */
	       if (request.getRole() == RoleType.COLLECTION_AGENT) {

	           throw new BadRequestException(
	                   "Not permission to add role");
	       }

	       /*
	        * To assign branch on user
	        */
	       Branch branch = branchRepository.findById(request.getBranchId())
	               .orElseThrow(() ->
	                       new ResourceNotFoundException(
	                               "Branch not found"));

	       /*
	        * map data userMapper class
	        */
	       User user = userMapper.toEntity(request);

	       /*
	        * encode user password
	        */
	       user.setPassword(
	               passwordEncoder.encode(originalPassword));

	       /*
	        * set customer code
	        */
	       user.setCustomerCode(
	               CustomerCodeGenerator.generateCustomerCodeWithDate());

	       /*
	        * set by default active
	        */
	       user.setActive(true);

	       /*
	        * branch set for user
	        */
	       user.setBranch(branch);

	       /*
	        * set createdBy
	        */
	       user.setCreatedBy(request.getCreatedBy());

	       /*
	        * To assign role on user
	        */
	       Role role = roleRepository.findByRoleName(request.getRole())
	               .orElseThrow(() ->
	                       new ResourceNotFoundException(
	                               "Role not found: " + request.getRole()));

	       user.getRoles().add(role);

	       /*
	        * user data save in DB
	        */
	       User savedUser = userRepository.save(user);

	       /*
	        * ================================
	        * SEND EMAIL USING OPENFEIGN
	        * ================================
	        */

//	       EmailRequest emailRequest = new EmailRequest();
//
//	       emailRequest.setTo(savedUser.getEmail());
//
//	       emailRequest.setSubject(
//	               "LMS Account Registration Successful");
//
//	       String emailBody =
//	               "<html>"
//	               + "<body style='font-family: Arial, sans-serif; "
//	               + "background-color:#f4f6f8; padding:30px;'>"
//
//	               + "<div style='max-width:600px; margin:auto; "
//	               + "background:white; padding:30px; "
//	               + "border-radius:10px;'>"
//
//	               + "<h2 style='color:#1976d2;'>"
//	               + "Welcome to Loan Management System"
//	               + "</h2>"
//
//	               + "<p>Dear <b>"
//	               + savedUser.getFirstName()
//	               + "</b>,</p>"
//
//	               + "<p>"
//	               + "Your account has been successfully registered."
//	               + "</p>"
//
//	               + "<h3>Login Details</h3>"
//
//	               + "<table style='width:100%; "
//	               + "border-collapse:collapse;'>"
//
//	               + "<tr>"
//	               + "<td style='padding:10px; "
//	               + "border:1px solid #ddd;'>"
//	               + "<b>Username</b>"
//	               + "</td>"
//
//	               + "<td style='padding:10px; "
//	               + "border:1px solid #ddd;'>"
//	               + savedUser.getCreatedBy()
//	               + "</td>"
//	               + "</tr>"
//
//	               + "<tr>"
//	               + "<td style='padding:10px; "
//	               + "border:1px solid #ddd;'>"
//	               + "<b>Password</b>"
//	               + "</td>"
//
//	               + "<td style='padding:10px; "
//	               + "border:1px solid #ddd;'>"
//	               + originalPassword
//	               + "</td>"
//	               + "</tr>"
//
//	               + "<tr>"
//	               + "<td style='padding:10px; "
//	               + "border:1px solid #ddd;'>"
//	               + "<b>Customer Code</b>"
//	               + "</td>"
//
//	               + "<td style='padding:10px; "
//	               + "border:1px solid #ddd;'>"
//	               + savedUser.getCustomerCode()
//	               + "</td>"
//	               + "</tr>"
//
//	               + "</table>"
//
//	               + "<p style='margin-top:20px;'>"
//	               + "Please keep your login credentials secure."
//	               + "</p>"
//
//	               + "<p>"
//	               + "Regards,<br>"
//	               + "<b>LMS Team</b>"
//	               + "</p>"
//
//	               + "</div>"
//
//	               + "</body>"
//	               + "</html>";
//
//	       emailRequest.setBody(emailBody);
//
//	       /*
//	        * Call Notification Microservice
//	        * using OpenFeign
//	        */
//	       notificationClient.sendMail(emailRequest);

	       return userMapper.toResponse(savedUser);
	   }
	/*
	 * This implemented method is get user Details by using id 
	 */

	@Override
	public UserResponse updateUser(Long id, @Valid UpdateUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getUserByMobail(String mobaile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse getUserByAdharNo(String aadhaarNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse activateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deActivateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}

