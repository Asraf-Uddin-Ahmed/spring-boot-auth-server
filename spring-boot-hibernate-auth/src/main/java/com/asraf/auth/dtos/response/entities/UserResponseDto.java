package com.asraf.auth.dtos.response.entities;

import java.util.List;

import com.asraf.auth.constants.UserRoleResponse;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserResponseDto extends BaseEntityResponseDto {
	
	private String username;
	
	private String email;
	
	@JsonView(UserRoleResponse.Admin.class)
	private List<UserVerificationResponseDto> userVerifications;
	
	@JsonView(UserRoleResponse.Admin.class)
	private List<UserClaimResponseDto> userClaims;
	
}
