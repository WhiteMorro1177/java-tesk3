package ru.tsybulko.task3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "position_db")
public class Position {
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;


    // constructor
    public Position() { }
    public Position(UUID id, String name, Integer salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // get
    public UUID getId() { return id; }
    public String getName() { return name; }
    public Integer getSalary() { return salary; }

    // set
    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(Integer salary) { this.salary = salary; }
}
