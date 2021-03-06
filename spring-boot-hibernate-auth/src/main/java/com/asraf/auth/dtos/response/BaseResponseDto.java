package com.asraf.auth.dtos.response;

import com.asraf.auth.constants.UserRoleResponse;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
@JsonView(UserRoleResponse.Anonymous.class)
public abstract class BaseResponseDto {

}
