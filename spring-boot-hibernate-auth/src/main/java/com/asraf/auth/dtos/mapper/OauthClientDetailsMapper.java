package com.asraf.auth.dtos.mapper;

import com.asraf.auth.dtos.request.entities.OauthClientDetailsRequestDto;
import com.asraf.auth.dtos.response.entities.OauthClientDetailsResponseDto;
import com.asraf.auth.entities.OauthClientDetails;

public interface OauthClientDetailsMapper extends
		RequestResponseDtoMapper<OauthClientDetails, OauthClientDetailsResponseDto, OauthClientDetailsRequestDto> {

}
