package com.asraf.auth.dtos.request.token;

import javax.validation.constraints.NotNull;

import com.asraf.auth.dtos.request.BaseRequestDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccessTokenRequestDto extends BaseRequestDto {
	@NotNull
	private String accessToken;
}
