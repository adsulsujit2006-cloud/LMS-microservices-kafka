package com.loan_management_system_user.exception;

public class UnauthorizedException extends RuntimeException{
	UnauthorizedException(String message){
		super(message);
	}

}
