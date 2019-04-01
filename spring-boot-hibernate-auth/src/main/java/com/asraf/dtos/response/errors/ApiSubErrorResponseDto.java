package com.asraf.dtos.response.errors;

import com.asraf.constants.UserRoleResponse;
import com.asraf.dtos.response.BaseResponseDto;
import com.fasterxml.jackson.annotation.JsonView;

@JsonView(UserRoleResponse.Anonymous.class)
public abstract class ApiSubErrorResponseDto extends BaseResponseDto {

}
