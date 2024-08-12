package com.process.sa.services;

import com.process.sa.entites.Client;
import com.process.sa.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    // injection de dépendance via le constructeur
    // c'est ici qu'on lie le repository à notre service
    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // maintenant qu'un lient existe en mon repository et mon service
    // ici je peux maintenant intéragir avec ma bdd

    // ici je crée (stock) un utilisateur dans ma bdd à partir de la requete
    public void create(Client client) {

        // ce que je fais ici
        this.clientRepository.save(client);
    }

    // recupère tous les clients de ma bdd
    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        // le client peut exister ou pas
        Optional<Client> optional = this.clientRepository.findById(id);

        // si il existe on retourne sinon on ne retourne rien
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
