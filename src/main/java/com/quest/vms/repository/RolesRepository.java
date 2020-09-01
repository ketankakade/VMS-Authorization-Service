package com.quest.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.quest.vms.entity.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer>, PagingAndSortingRepository<Role, Integer> {

	Role findByRoleName(String name);

}