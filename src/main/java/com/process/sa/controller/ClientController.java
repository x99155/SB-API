package com.process.sa.controller;

import com.process.sa.dto.ClientDTO;
import com.process.sa.entites.Client;
import com.process.sa.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client", produces = APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client) {
        this.clientService.create(client);
    }

    @GetMapping()
    public Stream<ClientDTO> getAll() {
        return this.clientService.rechercher();
    }

    @GetMapping(path = "{id}")
    public Client lire(@PathVariable int id) {
        return this.clientService.lire(id);
    }
}
