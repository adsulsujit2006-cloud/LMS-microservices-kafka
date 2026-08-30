package com.loan_management_system_user.mapper;



import org.mapstruct.Mapper;

import com.loan_management_system_user.dto.responce.AddressResponse;
import com.loan_management_system_user.modal.Address;



@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponse toResponse(Address address);
}