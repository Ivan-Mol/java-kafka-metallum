package com.ivanmol.stringsender.service;

import com.ivanmol.stringsender.client.MetalArchivesClient;
import com.ivanmol.stringsender.model.Band;
import com.ivanmol.stringsender.repository.BandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BandService {
    private final BandRepository bandRepository;
    private final MetalArchivesClient metalArchivesClient;

    public BandService(BandRepository bandRepository, MetalArchivesClient metalArchivesClient) {
        this.bandRepository = bandRepository;
        this.metalArchivesClient = metalArchivesClient;
    }


    public Band saveBandFromClientToDatabase(String id) {
        Band band = metalArchivesClient.getBandById(id);
        return bandRepository.save(band);
    }

    public List<Band> saveBandsFromClientToDatabaseByPrefix(String name) {
        List<Band> bands = metalArchivesClient.getBandsByName(name);
        return bandRepository.saveAll(bands);
    }

    public List<Band> getAllFromDatabase() {
        return bandRepository.findAll();
    }

    public Band getById(Long id) {
        return bandRepository.getByIdAndCheck(id);
    }

    public List<Band> getAllByPrefix(String prefix) {
        return bandRepository.findByNameContainsIgnoreCase(prefix);
    }
}
