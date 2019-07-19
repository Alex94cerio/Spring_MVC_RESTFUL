package com.crud.springboot.backend.projectbackend.controller;

import com.crud.springboot.backend.projectbackend.model.Role;
import com.crud.springboot.backend.projectbackend.repository.RoleRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/roles" )
public class RoleController {
    private final RoleRepository roleRepository;


    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping( "" )
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Long roleId)
            throws ResourceNotFoundException {
        Role role = roleRepository.findById(roleId)
                .orElseThrow( () -> new ResourceNotFoundException("User not found with id :: " +  roleId));
        return ResponseEntity.ok().body(role);
    }
}
