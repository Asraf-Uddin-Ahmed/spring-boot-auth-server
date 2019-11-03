package com.asraf.auth.repositories;

import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.User;

@Transactional
public interface UserRepositoryQdsl extends ExtendedQueryDslJpaRepository<User, Long>  {

}
