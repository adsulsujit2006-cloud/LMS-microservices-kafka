package com.loan_management_system_user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan_management_system_user.enums.PermissionType;
import com.loan_management_system_user.modal.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
	
	 boolean existsByPermissionName(PermissionType permissionName);

	    Optional<Permission> findByPermissionName(PermissionType permissionName);

}
