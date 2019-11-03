package com.asraf.auth.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.asraf.auth.entities.UserClaim;

@Transactional
public interface UserClaimRepository extends UserClaimRepositoryCrud, JpaSpecificationExecutor<UserClaim> {

}
