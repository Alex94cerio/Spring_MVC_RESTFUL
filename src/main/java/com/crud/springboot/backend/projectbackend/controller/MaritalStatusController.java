package com.crud.springboot.backend.projectbackend.controller;

import com.crud.springboot.backend.projectbackend.exception.ResourceNotFoundException;
import com.crud.springboot.backend.projectbackend.model.MaritalStatus;
import com.crud.springboot.backend.projectbackend.repository.MaritalStatusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/maritalStatuses" )
public class MaritalStatusController {
    private final MaritalStatusRepository maritalStatusRepository;


    public MaritalStatusController(MaritalStatusRepository maritalStatusRepository) {
        this.maritalStatusRepository = maritalStatusRepository;
    }

    @GetMapping( "" )
    public List<MaritalStatus> getAllRoles(){
        return maritalStatusRepository.findAll();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<MaritalStatus> getRoleById(@PathVariable(value = "id") Long maritalStatusId)
            throws ResourceNotFoundException {
        MaritalStatus maritalStatus = maritalStatusRepository.findById(maritalStatusId)
                .orElseThrow( () -> new ResourceNotFoundException("User not found with id :: " +  maritalStatusId));
        return ResponseEntity.ok().body(maritalStatus);
    }
}

