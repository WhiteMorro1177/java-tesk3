package ru.tsybulko.task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsybulko.task3.dto.Statistic;
import ru.tsybulko.task3.repository.ClientRepository;
import ru.tsybulko.task3.repository.OfferRepository;
import ru.tsybulko.task3.service.StatisticService;

@RestController
@RequestMapping("/api/v1")
public class StatisticController {
    private final StatisticService service;

    @Autowired
    public StatisticController(OfferRepository offerRepository, ClientRepository clientRepository) {
        service = new StatisticService(offerRepository, clientRepository);
    }

    @GetMapping("/offer/statistic")
    public Statistic GetStatistic() {
        return service.getStatistic();
    }
}
