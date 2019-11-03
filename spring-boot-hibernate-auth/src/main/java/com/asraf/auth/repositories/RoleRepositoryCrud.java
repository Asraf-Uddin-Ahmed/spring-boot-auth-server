package com.asraf.auth.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.Role;

@Transactional
public interface RoleRepositoryCrud extends PagingAndSortingRepository<Role, Long> {

}
