package ru.tsybulko.task3.service;

import ru.tsybulko.task3.model.Client;
import ru.tsybulko.task3.model.Offer;
import ru.tsybulko.task3.model.Stuff;

import java.time.LocalDate;

public interface OfferService {
    public Offer SignNewOffer(LocalDate start, LocalDate end, Client client, Stuff stuff);
}
