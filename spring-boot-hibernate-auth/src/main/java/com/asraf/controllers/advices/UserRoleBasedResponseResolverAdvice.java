package com.asraf.controllers.advices;

import java.util.Collection;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import com.asraf.constants.UserRole;
import com.asraf.constants.UserRoleResponse;

@ControllerAdvice
public class UserRoleBasedResponseResolverAdvice extends AbstractMappingJacksonResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return super.supports(returnType, converterType);
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
                                           MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {

        Class<?> viewClass = UserRoleResponse.Anonymous.class;

        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().getAuthorities() != null) {
            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            if (authorities.stream().anyMatch(o -> o.getAuthority().equals(UserRole.ADMIN.getAuthority()))) {
                viewClass = UserRoleResponse.Admin.class;
            }
            
        }
        bodyContainer.setSerializationView(viewClass);
    }
}