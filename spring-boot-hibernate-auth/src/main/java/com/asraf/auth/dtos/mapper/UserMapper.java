package com.asraf.auth.dtos.mapper;

import com.asraf.auth.dtos.request.entities.UserRequestDto;
import com.asraf.auth.dtos.response.entities.UserResponseDto;
import com.asraf.auth.entities.User;

public interface UserMapper extends RequestResponseDtoMapper<User, UserResponseDto, UserRequestDto> {

}
