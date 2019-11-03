package com.asraf.auth.dtos.mapper.persistence;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asraf.auth.dtos.mapper.AccountUserMapper;
import com.asraf.auth.dtos.response.entities.UserResponseDto;
import com.asraf.auth.entities.User;

@Component
@Scope(value = "prototype")
public class AccountUserMapperImpl extends UserMapperImpl implements AccountUserMapper {

	@Autowired
	public AccountUserMapperImpl(ModelMapper modelMapper) {
		super(modelMapper);

		PropertyMap<User, UserResponseDto> entityToResponsePropertyMap = new PropertyMap<User, UserResponseDto>() {
			protected void configure() {
				skip().setUserClaims(null);
				skip().setUserVerifications(null);
			}
		};

		super.setEntityToResponsePropertyMap(entityToResponsePropertyMap);

	}

}
