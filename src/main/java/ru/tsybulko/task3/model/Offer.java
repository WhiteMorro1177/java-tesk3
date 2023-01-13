package ru.tsybulko.task3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "offer_db")
public class Offer {
    @Id
    private UUID id;

    @JsonProperty("serial_number")
    @Column(name = "serial_number")
    private String serialNumber;

    @JsonProperty("sign_date")
    @Column(name = "sign_date")
    private LocalDate signDate;

    @JsonProperty("start_date")
    @Column(name = "start_date")
    private LocalDate startDate;

    @JsonProperty("ending_date")
    @Column(name = "ending_date")
    private LocalDate endDate;

    @JsonProperty("client")
    @ManyToOne(targetEntity = Client.class, optional = false)
    @JoinColumn(name = "client")
    private Client client;

    @JsonProperty("stuff")
    @ManyToOne(targetEntity = Stuff.class, optional = false)
    @JoinColumn(name = "stuff")
    private Stuff stuff;

    @JsonProperty("office")
    @ManyToOne(targetEntity = Office.class, optional = false)
    @JoinColumn(name = "office")
    private Office office;


    // constructor
    public Offer() { }
    public Offer(UUID id, String serialNumber, LocalDate signDate, LocalDate startDate, LocalDate endDate, Client client, Stuff stuff, Office office) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.signDate = signDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.stuff = stuff;
        this.office = office;
    }

    // get
    @JsonProperty("id")
    public UUID getId() { return id; }
    @JsonProperty("serial_number")
    public String getSerialNumber() { return serialNumber; }
    @JsonProperty("sign_date")
    public LocalDate getSignDate() { return signDate; }
    @JsonProperty("start_date")
    public LocalDate getStartDate() { return startDate; }
    @JsonProperty("ending_date")
    public LocalDate getEndDate() { return endDate; }
    @JsonProperty("client")
    public Client getClient() { return client; }
    @JsonProperty("stuff")
    public Stuff getStuff() { return stuff; }
    @JsonProperty("office")
    public Office getOffice() { return office; }

    // set
    public void setId(UUID id) { this.id = id; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setSignDate(LocalDate signDate) { this.signDate = signDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setClient(Client client) { this.client = client; }
    public void setStuff(Stuff stuff) { this.stuff = stuff; }
    public void setOffice(Office office) { this.office = office; }
}
