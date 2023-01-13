package ru.tsybulko.task3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.boot.jackson.JsonComponent;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "stuff_db")
public class Stuff {
    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private UUID id;

    @Column(name = "surname")
    @JsonProperty("surname")
    private String surname;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "patronymic")
    @JsonProperty("patronymic")
    private String lastName;

    @Column(name = "sex")
    @JsonProperty("sex")
    private Boolean sex;

    @Column(name = "birth_date")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @Column(name = "salary_multiplier")
    @JsonProperty("salary_multiplier")
    private Double salaryMultiplier;

    @ManyToOne(targetEntity = Position.class, optional = false)
    @JoinColumn(name = "position")
    @JsonProperty("position")
    private Position position;


    // constructor
    public Stuff() { }
    public Stuff(UUID id, String surname, String name, String lastName, Boolean sex, LocalDate birthDate, Double salaryMultiplier, Position position) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.salaryMultiplier = salaryMultiplier;
        this.position = position;
    }

    // get
    @JsonProperty("id")
    public UUID getId() { return id; }
    @JsonProperty("surname")
    public String getSurname() { return surname; }
    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("patronymic")
    public String getLastName() { return lastName; }
    @JsonProperty("sex")
    public Boolean getSex() { return sex; }
    @JsonProperty("birth_date")
    public LocalDate getBirthDate() { return birthDate; }
    @JsonProperty("salary_multiplier")
    public Double getSalaryMultiplier() { return salaryMultiplier; }
    @JsonProperty("position")
    public Position getPosition() { return position; }

    // set
    public void setId(UUID id) { this.id = id; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSex(Boolean sex) { this.sex = sex; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setSalaryMultiplier(Double salaryMultiplier) { this.salaryMultiplier = salaryMultiplier; }
    public void setPosition(Position position) { this.position = position; }
}
