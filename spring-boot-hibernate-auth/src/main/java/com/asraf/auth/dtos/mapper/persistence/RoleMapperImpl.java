package com.asraf.auth.dtos.mapper.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asraf.auth.dtos.mapper.RoleMapper;
import com.asraf.auth.dtos.request.entities.RoleRequestDto;
import com.asraf.auth.dtos.response.entities.RoleResponseDto;
import com.asraf.auth.entities.Role;

@Component
@Scope(value = "prototype")
public class RoleMapperImpl extends RequestResponseDtoMapperImpl<Role, RoleResponseDto, RoleRequestDto>
		implements RoleMapper {

	@Autowired
	public RoleMapperImpl(ModelMapper modelMapper) {
		super(modelMapper, RoleResponseDto.class, Role.class);

	}

}
