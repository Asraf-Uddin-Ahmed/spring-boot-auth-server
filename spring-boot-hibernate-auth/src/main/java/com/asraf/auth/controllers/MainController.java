package com.asraf.auth.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asraf.auth.aop.SecuredByRole;
import com.asraf.auth.constants.RoleAuthority;
import com.asraf.auth.dtos.request.account.ForgotPasswordRequestDto;
import com.asraf.auth.dtos.request.entities.UserRequestDto;
import com.asraf.auth.dtos.request.main.TokenRequestDto;
import com.asraf.auth.dtos.response.requestdto.RequestBodyResponseDto;
import com.asraf.auth.dtos.response.requestdto.RequestDataCollectionResponseDto;
import com.asraf.auth.resources.main.MainAnonymousResource;
import com.asraf.auth.resources.main.MainAuthenticatedResource;
import com.asraf.auth.utils.HttpServletUtils;

@RestController
@RequestMapping("")
public class MainController {

	@GetMapping("")
	public MainAnonymousResource getAnonymousLinks()
			throws UnsupportedEncodingException, MessagingException, URISyntaxException {
		return new MainAnonymousResource();
	}

	@GetMapping("/authenticated-links")
	public MainAuthenticatedResource getAuthenticatedLinks() {
		return new MainAuthenticatedResource();
	}

	@GetMapping("/main/{id}")
	public String getById(@PathVariable("id") String id) {
		return "getById -> " + id;
	}

	@PostMapping("/main")
	public String create() {
		return "create";
	}

	@PutMapping("/main")
	public String update() {
		return "update";
	}

	@SecuredByRole({RoleAuthority.ADMIN})
	@DeleteMapping("/main/{id}")
	public String delete(@PathVariable("id") String id) {
		return "delete -> " + id;
	}

	@GetMapping("/requests")
	public RequestDataCollectionResponseDto getRequests()
			throws URISyntaxException, UnsupportedEncodingException, MessagingException {
		RequestDataCollectionResponseDto requestDataCollection = new RequestDataCollectionResponseDto();
		this.addRequestDataOfPostOauthToken(requestDataCollection).addRequestDataOfPostUser(requestDataCollection)
				.addRequestDataOfPostForgetPassword(requestDataCollection);
		return requestDataCollection;
	}

	private MainController addRequestDataOfPostOauthToken(RequestDataCollectionResponseDto requestDataCollection)
			throws URISyntaxException {
		RequestBodyResponseDto<TokenRequestDto> requestBody = new RequestBodyResponseDto<TokenRequestDto>(
				TokenRequestDto.class);
		String baseUrl = HttpServletUtils.getBaseUrl();
		URI uri = new URI(baseUrl + "/oauth/token");
		requestDataCollection.addRequest(uri, org.springframework.http.HttpMethod.POST, requestBody);
		return this;
	}

	private MainController addRequestDataOfPostUser(RequestDataCollectionResponseDto requestDataCollection) {
		RequestBodyResponseDto<UserRequestDto> requestBody = new RequestBodyResponseDto<UserRequestDto>(
				UserRequestDto.class);
		URI createUserUri = linkTo(methodOn(AccountController.class).createUser(null)).toUri();
		requestDataCollection.addRequest(createUserUri, org.springframework.http.HttpMethod.POST, requestBody);
		return this;
	}

	private MainController addRequestDataOfPostForgetPassword(RequestDataCollectionResponseDto requestDataCollection)
			throws UnsupportedEncodingException, MessagingException {
		RequestBodyResponseDto<ForgotPasswordRequestDto> requestBody = new RequestBodyResponseDto<ForgotPasswordRequestDto>(
				ForgotPasswordRequestDto.class);
		URI forgetPasswordUri = linkTo(methodOn(AccountController.class).forgotPassword(null)).toUri();
		requestDataCollection.addRequest(forgetPasswordUri, org.springframework.http.HttpMethod.POST, requestBody);
		return this;
	}

}
