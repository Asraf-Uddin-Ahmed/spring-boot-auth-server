package com.asraf.auth.dtos.mapper;

import com.asraf.auth.dtos.request.entities.UserClaimRequestDto;
import com.asraf.auth.dtos.response.entities.UserClaimResponseDto;
import com.asraf.auth.entities.UserClaim;

public interface UserClaimMapper
		extends RequestResponseDtoMapper<UserClaim, UserClaimResponseDto, UserClaimRequestDto> {

}
