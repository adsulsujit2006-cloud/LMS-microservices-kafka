package com.loan_management_system_user.services;

import java.util.List;

import com.loan_management_system_user.dto.request.CreateBranchRequest;
import com.loan_management_system_user.dto.request.UpdateBranchRequest;
import com.loan_management_system_user.dto.responce.ApiResponse;
import com.loan_management_system_user.dto.responce.BranchResponse;

public interface BranchService {
public BranchResponse createBranch(CreateBranchRequest request);
	
	public BranchResponse updateBranch(Long id, UpdateBranchRequest request);
	
	public BranchResponse getBranchById(Long id);
	
	public List<BranchResponse> getAllBranches();
	
	public ApiResponse deleteBranch(Long id);
	
	public ApiResponse activateBranch(Long id);
	
	public ApiResponse deActivateBranch(Long id);

}
