package com.asraf.auth.resources.assemblers;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.asraf.auth.controllers.BaseController;
import com.asraf.auth.entities.BaseEntity;
import com.asraf.auth.resources.BaseResource;

public abstract class BaseResourceAssembler<TEntity extends BaseEntity, TResource extends BaseResource>
		extends ResourceAssemblerSupport<TEntity, TResource> {

	public BaseResourceAssembler(Class<? extends BaseController> controllerClass, Class<TResource> resourceClass) {
		super(controllerClass, resourceClass);
	}

}
