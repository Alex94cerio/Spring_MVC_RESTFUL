package com.crud.springboot.backend.projectbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class MaritalStatus implements Serializable {


    private Integer id;
    private String name;

    public MaritalStatus(){}
    public MaritalStatus(Integer id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty
    @Column(length=30, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaritalStatus that = (MaritalStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "MaritalStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
