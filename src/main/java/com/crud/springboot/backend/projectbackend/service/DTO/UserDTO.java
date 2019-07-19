package com.crud.springboot.backend.projectbackend.service.DTO;

import com.crud.springboot.backend.projectbackend.model.MaritalStatus;
import com.crud.springboot.backend.projectbackend.model.Role;
import com.crud.springboot.backend.projectbackend.model.Skill;
import com.crud.springboot.backend.projectbackend.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private Date birthdate;
    private Role role;
    private MaritalStatus maritalStatus;
    private List<Skill> skillList;
    private String fileName;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName =  user.getFirstName() + "-DTO";
        this.lastName =  user.getLastName();
        this.country =  user.getCountry();
        this.birthdate =  user.getBirthdate();
        this.role =  user.getRole();
        this.maritalStatus =  user.getMaritalStatus();
        this.skillList =  user.getSkillList();
        this.fileName =  user.getFileName();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getBirthdate() { return birthdate; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }
    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
