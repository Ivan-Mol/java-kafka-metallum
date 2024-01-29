package com.ivanmol.stringsender.controller;

import com.ivanmol.stringsender.KafkaProducer;
import com.ivanmol.stringsender.model.Band;
import com.ivanmol.stringsender.service.BandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class BandController {

    public final KafkaProducer kafkaProducer;
    private final BandService bandService;

    public BandController(KafkaProducer kafkaProducer, BandService bandService) {
        this.kafkaProducer = kafkaProducer;
        this.bandService = bandService;
    }

    @PostMapping("/metallum/band/{id}")
    public Band saveBandFromClientToDatabase(@PathVariable String id) {
        return bandService.saveBandFromClientToDatabase(id);
    }

    @PostMapping("/metallum/bands/{namePrefix}")
    public List<Band> saveBandsFromClientToDatabaseByNamePrefix(@PathVariable String namePrefix) {
        List<Band> bands = bandService.saveBandsFromClientToDatabaseByPrefix(namePrefix);
        return bands;
    }

    @GetMapping("/bands")
    public List<Band> getAllFromDatabase() {
        return bandService.getAllFromDatabase();
    }

    @GetMapping("/bands/{id}")
    public Band getById(@PathVariable Long id) {
        return bandService.getById(id);
    }

    @PostMapping("/producer/band/{id}")
    public Band sendToKafka(@PathVariable Long id) {
        Band band = bandService.getById(id);
        kafkaProducer.produce(band);
        return band;
    }

    @PostMapping("/producer/bands/{prefix}")
    public List<Band> sendToKafka(@PathVariable String prefix) {
        List<Band> bands = bandService.getAllByPrefix(prefix);
        kafkaProducer.produce(bands);
        return bands;

    }
}
