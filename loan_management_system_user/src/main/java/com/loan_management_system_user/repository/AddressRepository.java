package com.loan_management_system_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan_management_system_user.modal.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}

