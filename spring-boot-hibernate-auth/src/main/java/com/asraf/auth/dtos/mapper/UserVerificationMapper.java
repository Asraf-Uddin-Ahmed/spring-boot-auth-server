package com.asraf.auth.dtos.mapper;

import com.asraf.auth.dtos.request.entities.UserVerificationRequestDto;
import com.asraf.auth.dtos.response.entities.UserVerificationResponseDto;
import com.asraf.auth.entities.UserVerification;

public interface UserVerificationMapper
		extends RequestResponseDtoMapper<UserVerification, UserVerificationResponseDto, UserVerificationRequestDto> {

}
