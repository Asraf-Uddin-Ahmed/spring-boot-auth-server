package com.asraf.auth.dtos.mapper.account.persistence;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asraf.auth.dtos.mapper.account.ForgotPasswordMapper;
import com.asraf.auth.dtos.mapper.persistence.DtoMapperImpl;
import com.asraf.auth.entities.User;
import com.asraf.auth.entities.UserVerification;

@Component
@Scope(value = "prototype")
public class ForgotPasswordMapperImpl extends DtoMapperImpl implements ForgotPasswordMapper {

	protected ForgotPasswordMapperImpl(ModelMapper modelMapper) {
		super(modelMapper);
	}

	@Override
	public UserVerification getEntity(User user) {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		UserVerification userVerification = new UserVerification();
		userVerification.setUser(user);
		userVerification.setVerificationCode(verificationCode);
		userVerification.setCreationTime(new Date());
		return userVerification;
	}

}
