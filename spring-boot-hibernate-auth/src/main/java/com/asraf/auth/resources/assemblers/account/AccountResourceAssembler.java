package com.asraf.auth.resources.assemblers.account;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asraf.auth.controllers.AccountController;
import com.asraf.auth.dtos.mapper.AccountUserMapper;
import com.asraf.auth.entities.User;
import com.asraf.auth.resources.account.AccountResource;
import com.asraf.auth.resources.assemblers.BaseResourceAssembler;

@Component
public class AccountResourceAssembler extends BaseResourceAssembler<User, AccountResource> {

	private final AccountUserMapper accountUserMapper;

	@Autowired
	public AccountResourceAssembler(AccountUserMapper accountUserMapper) {
		super(AccountController.class, AccountResource.class);
		this.accountUserMapper = accountUserMapper;
	}

	@Override
	public AccountResource toResource(User entity) {
		try {
			return new AccountResource(entity, accountUserMapper);
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}

}