package com.asraf.auth.dtos.request.entities;

import javax.validation.constraints.NotNull;

import com.asraf.auth.dtos.request.BaseRequestDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserVerificationRequestDto extends BaseRequestDto {

	@NotNull
	private String verificationCode;

	@NotNull
	private Long userId;

}
