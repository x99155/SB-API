package com.process.sa.services;

import com.process.sa.dto.ClientDTO;
import com.process.sa.entites.Client;
import com.process.sa.mapper.ClientDTOMapper;
import com.process.sa.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientDTOMapper clientDTOMapper;

    public ClientService(ClientRepository clientRepository, ClientDTOMapper clientDTOMapper) {
        this.clientRepository = clientRepository;
        this.clientDTOMapper = clientDTOMapper;
    }


    public void create(Client client) {
        this.clientRepository.save(client);
    }


    public Stream<ClientDTO> rechercher() {
        return this.clientRepository.findAll()
                .stream().map(clientDTOMapper);
    }

    public Client lire(int id) {
        // le client peut exister ou pas
        Optional<Client> optional = this.clientRepository.findById(id);
        return optional.orElse(null);
    }


    public Client lireOuCreer(Client clientAcreer) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());

        if (clientDansLaBDD != null) {
            clientDansLaBDD = this.clientRepository.save(clientDansLaBDD);
        }

        return clientDansLaBDD;
    }
}
