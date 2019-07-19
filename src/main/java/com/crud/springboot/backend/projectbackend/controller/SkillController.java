package com.crud.springboot.backend.projectbackend.controller;

import com.crud.springboot.backend.projectbackend.exception.ResourceNotFoundException;
import com.crud.springboot.backend.projectbackend.model.Skill;
import com.crud.springboot.backend.projectbackend.repository.SkillRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/skills" )
public class SkillController {
    private final SkillRepository skillRepository;


    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping( "" )
    public List<Skill> getAllRoles(){
        return skillRepository.findAll();
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Skill> getRoleById(@PathVariable(value = "id") Long skillId)
            throws ResourceNotFoundException {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow( () -> new ResourceNotFoundException("User not found with id :: " +  skillId));
        return ResponseEntity.ok().body(skill);
    }
}

