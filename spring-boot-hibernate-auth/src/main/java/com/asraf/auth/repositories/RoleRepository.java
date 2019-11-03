package com.asraf.auth.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.asraf.auth.entities.Role;

@Transactional
public interface RoleRepository extends RoleRepositoryCrud, JpaSpecificationExecutor<Role> {

}
