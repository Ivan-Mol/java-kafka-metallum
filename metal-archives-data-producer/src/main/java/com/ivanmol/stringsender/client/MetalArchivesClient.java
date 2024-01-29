package com.ivanmol.stringsender.client;

import com.ivanmol.stringsender.model.Band;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MetalArchivesClient {

    private final WebClient webClient;

    @Autowired
    public MetalArchivesClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Band getBandById(String id) {
        return webClient
                .get()
                .uri(String.join("", "/bands/", id))
                .retrieve()
                .bodyToMono(Band.class)
                .doOnError(error -> log.error("An error has occurred {}", error.getMessage()))
                .block();
    }

    public List<Band> getBandsByName(String name) {
        return webClient
                .get()
                .uri(String.join("", "/search/bands/name/", name))
                .retrieve()
                .bodyToFlux(Band.class)
                .toStream()
                .collect(Collectors.toList());
    }
}
