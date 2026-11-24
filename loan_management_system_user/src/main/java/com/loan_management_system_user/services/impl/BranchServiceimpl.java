package com.loan_management_system_user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan_management_system_user.dto.request.CreateBranchRequest;
import com.loan_management_system_user.dto.request.UpdateBranchRequest;
import com.loan_management_system_user.dto.responce.ApiResponse;
import com.loan_management_system_user.dto.responce.BranchResponse;
import com.loan_management_system_user.exception.BadRequestException;
import com.loan_management_system_user.exception.DuplicateResourceException;
import com.loan_management_system_user.mapper.BranchMapper;
import com.loan_management_system_user.modal.Branch;
import com.loan_management_system_user.repository.BranchRepository;
import com.loan_management_system_user.services.BranchService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BranchServiceimpl implements BranchService{
	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private BranchMapper branchMapper;

	@Override
	public BranchResponse createBranch(CreateBranchRequest request) {

		/*
		 * Check request is null or not
		 */
		if (request == null) {
			throw new BadRequestException("Branch request cannot be null");
		}

		log.info("Creating new Branch with branch code {}", request.getBranchCode());

		/*
		 * Check branch code already exists or not
		 */
		if (branchRepository.existsByBranchCode(request.getBranchCode())) {
			throw new DuplicateResourceException("Branch code already exists");
		}

		log.info("Creating new Branch with branch name {}", request.getBranchName());

		/*
		 * Check branch name already exists or not
		 */
		if (branchRepository.existsByBranchName(request.getBranchName())) {
			throw new DuplicateResourceException("Branch name already exists");
		}

		log.info("Creating new Branch with branch ifscCode {}", request.getIfscCode());

		/*
		 * Check IFSC code already exists or not
		 */
		if (branchRepository.existsByIfscCode(request.getIfscCode())) {
			throw new DuplicateResourceException("IFSC code already exists");
		}

		log.info("Creating new Branch with branch email {}", request.getEmail());

		/*
		 * Check email already exists or not
		 */
		if (branchRepository.existsByEmail(request.getEmail())) {
			throw new DuplicateResourceException("Branch email already exists");
		}

		log.info("Creating new Branch with branch phoneNumber {}", request.getPhoneNumber());

		/*
		 * Check phone number already exists or not
		 */
		if (branchRepository.existsByPhoneNumber(request.getPhoneNumber())) {
			throw new DuplicateResourceException("Branch mobile number already exists");
		}

		/*
		 * Map request to Entity
		 */
		Branch branch = branchMapper.toEntity(request);

		/*
		 * Set branch by default active true
		 */
		branch.setActive(true);

		/*
		 * Save data in database
		 */
		Branch newBranch = branchRepository.save(branch);

		/*
		 * Add log for create branch successful
		 */
		log.info("Branch created successfully with branch code {}", newBranch.getBranchCode());

		return branchMapper.toResponse(newBranch);
	}


	@Override
	public BranchResponse updateBranch(Long id, UpdateBranchRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BranchResponse getBranchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BranchResponse> getAllBranches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteBranch(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse activateBranch(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deActivateBranch(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
