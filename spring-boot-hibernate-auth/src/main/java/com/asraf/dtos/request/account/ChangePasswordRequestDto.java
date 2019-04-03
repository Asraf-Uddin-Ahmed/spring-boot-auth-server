package com.asraf.dtos.request.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.asraf.dtos.request.BaseRequestDto;
import com.asraf.validators.ValidateClassExpression;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ValidateClassExpression(value = "(#this.password.equals(#this.confirmPassword))", message = "password mismatch")
public class ChangePasswordRequestDto extends BaseRequestDto {

	@NotBlank
	@Size(min = 3, max = 100)
	private String password;

	private String confirmPassword;

}
