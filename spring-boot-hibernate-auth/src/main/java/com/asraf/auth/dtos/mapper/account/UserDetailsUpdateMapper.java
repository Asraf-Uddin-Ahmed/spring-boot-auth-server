package com.asraf.auth.dtos.mapper.account;

import com.asraf.auth.dtos.mapper.RequestResponseDtoMapper;
import com.asraf.auth.dtos.request.account.UserDetailsUpdateRequestDto;
import com.asraf.auth.dtos.response.entities.UserResponseDto;
import com.asraf.auth.entities.User;

public interface UserDetailsUpdateMapper
		extends RequestResponseDtoMapper<User, UserResponseDto, UserDetailsUpdateRequestDto> {

}
