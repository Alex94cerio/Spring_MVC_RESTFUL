package com.crud.springboot.backend.projectbackend.repository;

import com.crud.springboot.backend.projectbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
