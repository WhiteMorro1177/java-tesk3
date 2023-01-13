package ru.tsybulko.task3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.tsybulko.task3.model.*;
import ru.tsybulko.task3.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableWebMvc
@EnableJpaRepositories
public class Task3Application {

    public static void main(String[] args) {
        SpringApplication.run(Task3Application.class, args);
    }

    @Bean
    public CommandLineRunner init(
            ClientRepository clientRepository,
            StuffRepository stuffRepository,
            OfficeRepository officeRepository,
            PositionRepository positionRepository) {
        return args -> {
            positionRepository.saveAll(List.of(
                    new Position(UUID.randomUUID(), "Useless manager", 50000),
                    new Position(UUID.randomUUID(), "Main manager", 85000),
                    new Position(UUID.randomUUID(), "Manager", 60000),
                    new Position(UUID.randomUUID(), "Bartender", 120000)
            ));
            clientRepository.saveAll(List.of(
                    new Client(
                            UUID.randomUUID(),
                            "client surname 1",
                            "client name 1",
                            "client last name 1",
                            true,
                            LocalDate.of(2001, 9, 5),
                            "inn 1",
                            "passport series 1",
                            "phone number 1"),
                    new Client(
                            UUID.randomUUID(),
                            "client surname 2",
                            "client name 2",
                            "client last name 2",
                            true,
                            LocalDate.of(1990, 4, 10),
                            "inn 2",
                            "passport series 2",
                            "phone number 2"),
                    new Client(
                            UUID.randomUUID(),
                            "client surname 3",
                            "client name 3",
                            "client last name 3",
                            false,
                            LocalDate.of(1974, 2, 15),
                            "inn 3",
                            "passport series 3",
                            "phone number 3"),
                    new Client(
                            UUID.randomUUID(),
                            "client surname 4",
                            "client name 4",
                            "client last name 4",
                            false,
                            LocalDate.of(1996, 10, 20),
                            "inn 4",
                            "passport series 4",
                            "phone number 4")));

            stuffRepository.saveAll(List.of(
                    new Stuff(
                            UUID.randomUUID(),
                            "stuff surname 1",
                            "stuff name 1",
                            "stuff last name 1",
                            false,
                            LocalDate.of(1972, 11, 17),
                            1.3d,
                            positionRepository.findAll().get(0)),
                    new Stuff(
                            UUID.randomUUID(),
                            "stuff surname 2",
                            "stuff name 2",
                            "stuff last name 2",
                            false,
                            LocalDate.of(1987, 6, 11),
                            1.6d,
                            positionRepository.findAll().get(1)),
                    new Stuff(
                            UUID.randomUUID(),
                            "stuff surname 3",
                            "stuff name 3",
                            "stuff last name 3",
                            true,
                            LocalDate.of(1993, 12, 25),
                            1.1d,
                            positionRepository.findAll().get(2)),
                    new Stuff(
                            UUID.randomUUID(),
                            "stuff surname 4",
                            "stuff name 4",
                            "stuff last name 4",
                            true,
                            LocalDate.of(1956, 8, 23),
                            1.0d,
                            positionRepository.findAll().get(3))
            ));

            officeRepository.save(
                    new Office(
                            UUID.randomUUID(),
                            "physical address",
                            "law address",
                            69)
            );
        };
    }
}
