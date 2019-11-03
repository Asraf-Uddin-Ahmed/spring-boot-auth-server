package com.asraf.auth.dtos.mapper.account.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asraf.auth.dtos.mapper.account.UserDetailsUpdateMapper;
import com.asraf.auth.dtos.mapper.persistence.RequestResponseDtoMapperImpl;
import com.asraf.auth.dtos.request.account.UserDetailsUpdateRequestDto;
import com.asraf.auth.dtos.response.entities.UserResponseDto;
import com.asraf.auth.entities.User;

@Component
@Scope(value = "prototype")
public class UserDetailsUpdateMapperImpl
		extends RequestResponseDtoMapperImpl<User, UserResponseDto, UserDetailsUpdateRequestDto>
		implements UserDetailsUpdateMapper {

	@Autowired
	public UserDetailsUpdateMapperImpl(ModelMapper modelMapper) {
		super(modelMapper, UserResponseDto.class, User.class);

	}

}
