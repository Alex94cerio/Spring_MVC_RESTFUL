package com.crud.springboot.backend.projectbackend.repository;

import com.crud.springboot.backend.projectbackend.model.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Long> {
}
