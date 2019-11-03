package com.asraf.auth.dtos.mapper;

import com.asraf.auth.dtos.request.entities.RoleRequestDto;
import com.asraf.auth.dtos.response.entities.RoleResponseDto;
import com.asraf.auth.entities.Role;

public interface RoleMapper extends RequestResponseDtoMapper<Role, RoleResponseDto, RoleRequestDto> {

}
