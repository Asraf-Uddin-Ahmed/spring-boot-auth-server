package com.asraf.auth.resources.assemblers.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asraf.auth.controllers.RoleController;
import com.asraf.auth.dtos.mapper.RoleMapper;
import com.asraf.auth.entities.Role;
import com.asraf.auth.resources.assemblers.BaseResourceAssembler;
import com.asraf.auth.resources.entities.RoleResource;

@Component
public class RoleResourceAssembler extends BaseResourceAssembler<Role, RoleResource> {

	private final RoleMapper roleMapper;

	@Autowired
	public RoleResourceAssembler(RoleMapper roleMapper) {
		super(RoleController.class, RoleResource.class);
		this.roleMapper = roleMapper;
	}

	@Override
	public RoleResource toResource(Role entity) {
		return new RoleResource(entity, roleMapper);
	}

}