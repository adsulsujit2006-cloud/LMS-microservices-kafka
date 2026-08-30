package com.loan_management_system_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan_management_system_user.modal.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    boolean existsByBranchCode(String branchCode);

    boolean existsByBranchName(String branchName);

    boolean existsByIfscCode(String ifscCode);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}