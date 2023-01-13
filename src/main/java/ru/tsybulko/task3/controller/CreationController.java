package ru.tsybulko.task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tsybulko.task3.dto.NewOfferParameters;
import ru.tsybulko.task3.model.*;
import ru.tsybulko.task3.repository.*;
import ru.tsybulko.task3.service.LeasingOfferService;
import ru.tsybulko.task3.service.OfferService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CreationController {
    private final OfferRepository offerRepository;
    private final ClientRepository clientRepository;
    private final OfficeRepository officeRepository;
    private final StuffRepository stuffRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public CreationController(final OfferRepository offerRepository,
                              final ClientRepository clientRepository,
                              final OfficeRepository officeRepository,
                              final StuffRepository stuffRepository,
                              final PositionRepository positionRepository) {
        this.offerRepository = offerRepository;
        this.clientRepository = clientRepository;
        this.officeRepository = officeRepository;
        this.stuffRepository = stuffRepository;
        this.positionRepository = positionRepository;
    }

    @GetMapping("/client")
    public List<Client> GetClients() { return clientRepository.findAll(); }

    @GetMapping("/client/{id}")
    public Client GetClientByID(@PathVariable("id") UUID id) { return clientRepository.findById(id).orElse(null); }

    @GetMapping("/offer")
    public List<Offer> GetOffers() { return offerRepository.findAll(); }

    @GetMapping("/offer/{id}")
    public Offer GetOfferByID(@PathVariable("id") UUID id) { return offerRepository.findById(id).orElse(null); }

    @GetMapping("/office")
    public List<Office> GetOffices() { return officeRepository.findAll(); }

    @GetMapping("/office/{id}")
    public Office GetOfficeByID(@PathVariable("id") UUID id) { return officeRepository.findById(id).orElse(null); }

    @GetMapping("/stuff")
    public List<Stuff> GetStuff() { return stuffRepository.findAll(); }

    @GetMapping("/stuff/{id}")
    public Stuff GetStuffByID(@PathVariable("id") UUID id) { return stuffRepository.findById(id).orElse(null); }

    @GetMapping("/position")
    public List<Position> GetPositions() { return positionRepository.findAll(); }

    @GetMapping("/position/{id}")
    public Position GetPositionByID(@PathVariable("id") UUID id) { return positionRepository.findById(id).orElse(null); }

    @PutMapping("/offer")
    public Offer SignNewOffer(@RequestBody() NewOfferParameters newOfferParameters) {
        final Client client = clientRepository.findById(newOfferParameters.getClientId()).orElse(null);
        final Stuff stuff = stuffRepository.findById(newOfferParameters.getStuffId()).orElse(null);

        final OfferService offerService = new LeasingOfferService(offerRepository, officeRepository);

        return offerService.SignNewOffer(
                newOfferParameters.getStartDate(),
                newOfferParameters.getEndingDate(),
                client, stuff);
    }
}
