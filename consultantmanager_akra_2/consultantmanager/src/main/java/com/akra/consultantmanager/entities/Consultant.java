package com.akra.consultantmanager.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String surname;

    private boolean project;

   // private List<String> technologies;

    public Consultant() {}

    public Consultant(String name, String surname, boolean project/*, List<String> technologies*/) {
        this.name = name;
        this.surname = surname;
        this.project = project;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public boolean isProject() {
        return project;
    }

    public void setProject(boolean project) {
        this.project = project;
    }

   // public List<String> getTechnologies() {
   //     return technologies;
  //  }
//
   // public void setTechnologies(List<String> technologies) {
   //     this.technologies = technologies;
  //  }
}