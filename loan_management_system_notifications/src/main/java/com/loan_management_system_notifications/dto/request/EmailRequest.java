package com.loan_management_system_notifications.dto.request;

import lombok.Data;

@Data
public class EmailRequest {

    private String to;

    private String subject;

    private String body;
}
