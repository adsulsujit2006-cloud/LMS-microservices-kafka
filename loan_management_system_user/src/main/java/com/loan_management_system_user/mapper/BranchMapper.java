package com.loan_management_system_user.mapper;

import org.mapstruct.Mapper;

import com.loan_management_system_user.dto.request.CreateBranchRequest;
import com.loan_management_system_user.dto.request.UpdateBranchRequest;
import com.loan_management_system_user.dto.responce.BranchResponse;
import com.loan_management_system_user.modal.Branch;

@Mapper(componentModel = "spring")
public interface BranchMapper {
	Branch toEntity(CreateBranchRequest request);
	Branch toEntity(UpdateBranchRequest request);
	BranchResponse toResponse(Branch branch);
}