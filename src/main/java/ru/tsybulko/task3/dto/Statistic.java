package ru.tsybulko.task3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class Statistic {
    @JsonProperty("client_statistics")
    private Map<String, Integer> clientOffers = new HashMap<String, Integer>();
    @JsonProperty("stuff_statistics")
    private Map<String, Integer> stuffOffers = new HashMap<String, Integer>();
    @JsonProperty("client_surnames")
    private Set<String> clientsSurnames = new HashSet<String>();


    public Statistic() {  }
    public Statistic(Map<String, Integer> clientOffers, Map<String, Integer> stuffOffers, Set<String> clientsSurnames) {
        this.clientOffers = clientOffers;
        this.stuffOffers = stuffOffers;
        this.clientsSurnames = clientsSurnames;
    }

    // get
    public Map<String, Integer> getClientOffers() { return clientOffers; }
    public Map<String, Integer> getStuffOffers() { return stuffOffers; }
    public Set<String> getClientsSurnames() { return clientsSurnames; }

    // set
    public void setClientOffers(Map<String, Integer> clientOffers) { this.clientOffers = clientOffers; }
    public void setStuffOffers(Map<String, Integer> stuffOffers) { this.stuffOffers = stuffOffers; }
    public void setClientsSurnames(Set<String> clientsSurnames) { this.clientsSurnames = clientsSurnames; }
}
