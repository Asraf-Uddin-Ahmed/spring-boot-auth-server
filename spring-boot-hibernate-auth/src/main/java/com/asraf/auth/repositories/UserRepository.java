package com.asraf.auth.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.asraf.auth.entities.User;

@Transactional
public interface UserRepository extends UserRepositoryCrud, JpaSpecificationExecutor<User> {

}
