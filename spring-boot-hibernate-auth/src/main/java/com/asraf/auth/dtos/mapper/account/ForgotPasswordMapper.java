package com.asraf.auth.dtos.mapper.account;

import com.asraf.auth.dtos.mapper.DtoMapper;
import com.asraf.auth.entities.User;
import com.asraf.auth.entities.UserVerification;

public interface ForgotPasswordMapper extends DtoMapper {
	UserVerification getEntity(User user);
}
