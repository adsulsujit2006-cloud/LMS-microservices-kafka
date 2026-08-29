package com.loan_management_system_user.dto.responce;

import java.time.LocalDateTime;

import com.loan_management_system_user.enums.ModuleType;
import com.loan_management_system_user.enums.PermissionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponse {

    private Long id;

    private PermissionType permissionName;

    private ModuleType moduleName;

    private String description;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}	