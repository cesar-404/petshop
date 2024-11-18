package com.petshop.pet.shot.services;

import com.petshop.pet.shot.dtos.ClientDto;
import com.petshop.pet.shot.dtos.UpdateClientDto;
import com.petshop.pet.shot.models.Client;
import com.petshop.pet.shot.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public Client saveClient(ClientDto clientDto) {
        var client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        clientRepository.save(client);
        return client;
    }

    public Optional<Client> finById(String clientId) {
        var id = UUID.fromString(clientId);
        return clientRepository.findById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void updateById(String clientId, UpdateClientDto updateClientDto) {
        var id = UUID.fromString(clientId);
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            client.get().setEmail(updateClientDto.email());
            client.get().setPhoneNumber(updateClientDto.phoneNumber());
            client.get().setCep(updateClientDto.cep());
            clientRepository.save(client.get());
        }
    }


    public void deleteById(String clientId) {
        var id = UUID.fromString(clientId);
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
        } else {
            throw new NoSuchElementException("Client with id " + clientId + " not found.");
        }
    }


}
