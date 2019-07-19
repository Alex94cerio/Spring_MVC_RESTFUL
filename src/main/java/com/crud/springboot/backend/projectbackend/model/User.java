package com.crud.springboot.backend.projectbackend.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class User implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String country;
    private Date birthdate;
    private Role role;
    private MaritalStatus maritalStatus;
    private List<Skill> skillList;
    private String fileName;

    public User() {}

    public User(String firstName, String lastName, String country, Date birthdate, Role role, MaritalStatus maritalStatus, List<Skill> skillList, String fileName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthdate = birthdate;
        this.role = role;
        this.maritalStatus = maritalStatus;
        this.skillList = skillList;
        this.fileName = fileName;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column
    public long getId() { return id; }
    public void setId( long id ) { this.id = id; }

    @Column( nullable = false )
    @NotEmpty(message = "First name must not be empty")
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$", message = "First name must contain only characters")
    @Size( min = 2, max = 20)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column( nullable = false )
    @NotEmpty(message = "Last name must not be empty")
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$", message = "Last name must contain only characters")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Column
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$", message = "Country name must contain only characters")
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    @Past(message = "Birthdate must be in the past")
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @ManyToOne
    @JoinColumn
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    @ManyToOne
    @JoinColumn
    public MaritalStatus getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(MaritalStatus maritalStatus) { this.maritalStatus = maritalStatus; }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Skill> getSkillList() { return skillList; }
    public void setSkillList(List<Skill> skillList) { this.skillList = skillList; }


    @Column (length = 100)
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

}
