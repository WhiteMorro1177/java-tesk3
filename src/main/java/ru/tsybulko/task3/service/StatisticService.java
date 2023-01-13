package ru.tsybulko.task3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tsybulko.task3.dto.Statistic;
import ru.tsybulko.task3.model.Client;
import ru.tsybulko.task3.repository.ClientRepository;
import ru.tsybulko.task3.repository.OfferRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatisticService {
    private final OfferRepository offerRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public StatisticService(OfferRepository offerRepository, ClientRepository clientRepository) {
        this.offerRepository = offerRepository;
        this.clientRepository = clientRepository;
    }

    public Statistic getStatistic() {
        final Statistic statistic = new Statistic();

        final Set<String> clientSurnames = clientRepository
                .findAll()
                .stream()
                .map(Client::getSurname)
                .collect(Collectors.toSet());

        final Map<String, Integer> clientOffers = new HashMap<>();


        final Map<String, Integer> stuffOffers = new HashMap<>();

        for (var offer : offerRepository.findAll()) {
            final var clientSurname = offer.getClient().getSurname();
            if (clientOffers.containsKey(clientSurname)) {
                final var offersCount = clientOffers.get(clientSurname);
                clientOffers.replace(clientSurname, offersCount, offersCount + 1);
            } else {
                clientOffers.put(clientSurname, 1);
            }

            final var stuffSurname = offer.getStuff().getSurname();
            if (stuffOffers.containsKey(stuffSurname)) {
                final var offersCount = stuffOffers.get(stuffSurname);
                stuffOffers.replace(stuffSurname, offersCount, offersCount + 1);
            } else {
                stuffOffers.put(stuffSurname, 1);
            }
        }

        statistic.setClientsSurnames(clientSurnames);
        statistic.setClientOffers(clientOffers);
        statistic.setStuffOffers(stuffOffers);

        return statistic;
    }
}
