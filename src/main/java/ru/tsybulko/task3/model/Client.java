package ru.tsybulko.task3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "client_db")
public class Client {
    @Id
    private UUID id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @JsonProperty("patronymic")
    @Column(name = "patronymic")
    private String lastName;

    @JsonProperty("sex")
    @Column(name = "sex")
    private Boolean sex;

    @JsonProperty("birth_date")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonProperty("inn")
    @Column(name = "inn")
    private String inn;

    @JsonProperty("passport_serial")
    @Column(name = "passport_serial")
    private String passportSeries;

    @JsonProperty("phone")
    @Column(name = "phone")
    private String phoneNumber;


    public Client() { }
    public Client(
            UUID id,
            String surname,
            String name,
            String lastName,
            Boolean sex,
            LocalDate birthDate,
            String inn,
            String passportSeries,
            String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.inn = inn;
        this.passportSeries = passportSeries;
        this.phoneNumber = phoneNumber;
    }

    // get
    public UUID getId() { return id; }
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public Boolean getSex() { return sex; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getInn() { return inn; }
    public String getPassportSeries() { return passportSeries; }
    public String getPhoneNumber() { return phoneNumber; }

    // set
    public void setId(UUID id) { this.id = id; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setName(String name) { this.name = name; }
    public void setSex(Boolean sex) { this.sex = sex; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setInn(String inn) { this.inn = inn; }
    public void setPassportSeries(String passportSeries) { this.passportSeries = passportSeries; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
