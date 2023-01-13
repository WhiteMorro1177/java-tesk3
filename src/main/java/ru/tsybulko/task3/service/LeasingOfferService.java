package ru.tsybulko.task3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsybulko.task3.model.*;
import ru.tsybulko.task3.repository.OfferRepository;
import ru.tsybulko.task3.repository.OfficeRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class LeasingOfferService implements OfferService {

    private final OfferRepository offerRepository;
    private final OfficeRepository officeRepository;

    @Autowired
    public LeasingOfferService(OfferRepository offerRepository, OfficeRepository officeRepository) {
        this.offerRepository = offerRepository;
        this.officeRepository = officeRepository;
    }

    // methods
    private static String GenerateSerialNumber() {
        Random random = new Random();
        return "№" + random.nextInt(100)
                + LocalDate.now().getYear()
                + LocalDate.now().getMonthValue()
                + LocalDate.now().getDayOfMonth()
                + LocalDateTime.now().getSecond();
    }

    @Override
    public Offer SignNewOffer(LocalDate start, LocalDate end, Client client, Stuff stuff) {
        return offerRepository.save(
                new Offer(
                        UUID.randomUUID(),
                        GenerateSerialNumber(),
                        LocalDate.now(),
                        start,
                        end,
                        client,
                        stuff,
                        officeRepository.findAll().get(0)));
    }
}
