package com.crud.springboot.backend.projectbackend.repository;

import com.crud.springboot.backend.projectbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
