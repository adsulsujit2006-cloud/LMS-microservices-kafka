package com.loan_management_system_user.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan_management_system_user.enums.RoleType;
import com.loan_management_system_user.modal.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByRoleName(RoleType roleName);

    boolean existsByDescription(String description);

    Optional<Role> findByRoleName(RoleType roleType);

}