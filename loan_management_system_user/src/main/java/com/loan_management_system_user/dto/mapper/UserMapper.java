package com.loan_management_system_user.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.loan_management_system_user.dto.request.UpdateUserRequest;
import com.loan_management_system_user.dto.request.UserRegistrationRequest;
import com.loan_management_system_user.dto.responce.UserResponse;
import com.loan_management_system_user.dto.responce.UserSummaryResponse;
import com.loan_management_system_user.modal.User;

@Mapper(
    componentModel = "spring",
    uses = {
        RoleMapper.class,
        BranchMapper.class,
        AddressMapper.class
    }
)
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "address", ignore = true)
    User toEntity(UserRegistrationRequest request);

    User toEntity(UpdateUserRequest request);

    @Mapping(
        target = "fullName",
        expression = "java(user.getFirstName() + \" \" + user.getLastName())"
    )
    UserResponse toResponse(User user);

    @Mapping(
        target = "fullName",
        expression = "java(user.getFirstName() + \" \" + user.getLastName())"
    )
    UserSummaryResponse toSummary(User user);

    List<UserResponse> toResponseList(List<User> users);
}
