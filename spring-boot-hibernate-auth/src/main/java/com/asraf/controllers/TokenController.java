package com.asraf.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.asraf.constants.RoleAuthority;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asraf.constants.PreAuthorizeConditions;
import com.asraf.dtos.request.token.AccessTokenRequestDto;
import com.asraf.dtos.request.token.RefreshTokenRequestDto;

@RestController
public class TokenController {

	@Resource(name = "tokenServices")
	ConsumerTokenServices tokenServices;

	@Resource(name = "tokenStore")
	TokenStore tokenStore;

	@Secured({RoleAuthority.ADMIN})
	@RequestMapping(method = RequestMethod.GET, value = "clients/{clientId}/tokens")
	public Collection<OAuth2AccessToken> getTokensByClient(@PathVariable String clientId) {
		List<String> tokenValues = new ArrayList<String>();
		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId(clientId);
		if (tokens != null) {
			for (OAuth2AccessToken token : tokens) {
				tokenValues.add(token.getValue());
			}
		}
		return tokens;
	}

	@Secured({RoleAuthority.ADMIN})
	@RequestMapping(method = RequestMethod.GET, value = "clients/{clientId}/username/{username}/tokens")
	public Collection<OAuth2AccessToken> getTokensByClientAndUser(@PathVariable String clientId,
			@PathVariable String username) {
		List<String> tokenValues = new ArrayList<String>();
		Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientIdAndUserName(clientId, username);
		if (tokens != null) {
			for (OAuth2AccessToken token : tokens) {
				tokenValues.add(token.getValue());
			}
		}
		return tokens;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/oauth/access-token/revoke")
	public void revokeToken(HttpServletRequest request, @Valid @RequestBody AccessTokenRequestDto requestDto) {
		tokenServices.revokeToken(requestDto.getAccessToken());
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/oauth/refresh-token/revoke")
	public void revokeRefreshToken(@Valid @RequestBody  RefreshTokenRequestDto requestDto) {
		if (tokenStore instanceof JdbcTokenStore) {
			((JdbcTokenStore) tokenStore).removeRefreshToken(requestDto.getRefreshToken());
		}
	}

}
