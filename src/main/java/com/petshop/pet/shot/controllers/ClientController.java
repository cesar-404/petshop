package com.petshop.pet.shot.controllers;

import com.petshop.pet.shot.dtos.ClientDto;
import com.petshop.pet.shot.dtos.UpdateClientDto;
import com.petshop.pet.shot.models.Client;
import com.petshop.pet.shot.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {

    ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Client> saveClient(@RequestBody ClientDto clientDto) {
        var client = clientService.saveClient(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable("clientId") String clientId) {
        var client = clientService.finById(clientId);
        if (client.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(client.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<Void> updateClientById(@PathVariable("clientId") String clientId,
                                                   @RequestBody UpdateClientDto updateClientDto) {
        clientService.updateById(clientId, updateClientDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("clientId") String clientId) {
        clientService.deleteById(clientId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
