package com.process.sa.controller;

import com.process.sa.entites.Client;
import com.process.sa.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
* lorsque l'utilisateur va saisir l'adresse localhost:8080/api/client
* cette requete va etre transmise à ce controller
 */

@RestController
@RequestMapping(path = "client", produces = APPLICATION_JSON_VALUE)
public class ClientController {

    // injection de dépendace via le controlleur
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // on crée un utilisateur (POST: http://localhost:8080/api/client)
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client) {
        this.clientService.create(client);
    }

    // on liste tous les utilisateurs (GET: http://localhost:8080/api/client)
    @GetMapping()
    public List<Client> getAll() {
        return this.clientService.rechercher();
    }

    // on liste un client en particulier (GET: http://localhost:8080/api/client/{id})
    @GetMapping(path = "{id}")
    public Client lire(@PathVariable int id) {
        return this.clientService.lire(id);
    }
}
