package com.example.demo.persistence;

import javax.persistence.*;

@Entity(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable =false)
    private String firstname;

    @Column(name = "last_name", nullable =false)
    private String lastname;

    @Column(name = "is_vaccinated")
    private Boolean vaccinated;

    @Column(name = "test")
    private String testColumn;

    public String getTestColumn() {
        return testColumn;
    }

    public void setTestColumn(String testColumn) {
        this.testColumn = testColumn;
    }

    public PersonEntity(String firstname, String lastname, Boolean vaccinated) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.vaccinated = vaccinated;
    }
    protected PersonEntity(){

    }

    public Long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
