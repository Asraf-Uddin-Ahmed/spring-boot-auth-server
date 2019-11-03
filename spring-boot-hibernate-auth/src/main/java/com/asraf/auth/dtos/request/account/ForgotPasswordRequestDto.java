package com.asraf.auth.dtos.request.account;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForgotPasswordRequestDto extends SendEmailRequestDto {

	@NotBlank
	private String callbackUrl;

}
