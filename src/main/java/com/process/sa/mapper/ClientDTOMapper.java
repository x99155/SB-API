package com.process.sa.mapper;

import com.process.sa.dto.ClientDTO;
import com.process.sa.entites.Client;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail());
    }
}
