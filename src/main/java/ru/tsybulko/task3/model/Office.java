package ru.tsybulko.task3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "office_db")
public class Office {
    @Id
    @JsonProperty("id")
    @Column(name = "id")
    private UUID id;

    @JsonProperty("address")
    @Column(name = "address")
    private String address;

    @JsonProperty("law_address")
    @Column(name = "law_address")
    private String lawAddress;

    @JsonProperty("cabinets_count")
    @Column(name = "cabinets_count")
    private Integer cabinetsCount;


    public Office() {  }
    public Office(UUID id, String address, String lawAddress, Integer cabinetsCount) {
        this.id = id;
        this.address = address;
        this.lawAddress = lawAddress;
        this.cabinetsCount = cabinetsCount;
    }

    // get
    public UUID getId() { return id; }

    @JsonProperty("address")
    public String getAddress() { return address; }

    @JsonProperty("law_address")
    public String getLawAddress() { return lawAddress; }

    @JsonProperty("cabinets_count")
    public Integer getCabinetsCount() { return cabinetsCount; }

    // set
    public void setId(UUID id) { this.id = id; }
    public void setAddress(String address) { this.address = address; }
    public void setLawAddress(String lawAddress) { this.lawAddress = lawAddress; }
    public void setCabinetsCount(Integer cabinetsCount) {
        this.cabinetsCount = cabinetsCount;
    }
}
