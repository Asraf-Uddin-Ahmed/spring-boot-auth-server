package com.asraf.auth.dtos.request.entities;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.asraf.auth.constants.ErrorCode;
import com.asraf.auth.dtos.request.BaseRequestDto;
import com.asraf.auth.validators.ValidateClassExpression;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ValidateClassExpression(value = "(#this.password.equals(#this.confirmPassword))", message = ErrorCode.Password.MISMATCH, actionMessage = "This field need to be equals with {dependentFields}", appliedFields = {
		"confirmPassword" }, dependentFields = { "password" })
@ValidateClassExpression(value = "(#this.userStatus != null)", message = ErrorCode.UserStatus.REQUIRED, actionMessage = "Field must not be null", appliedFields = {
		"userStatus" })
public class UserRequestDto extends BaseRequestDto {

	@NotBlank
	@Size(min = 3, max = 100)
	private String username;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Size(min = 3, max = 100)
	private String password;

	private String confirmPassword;

	private String userStatus;

	private Date lastLogin;

	private Integer wrongPasswordAttempt;

	private Date lastWrongPasswordAttempt;

	private List<Long> userVerificationIds;

	private List<Long> roleIds;

}
