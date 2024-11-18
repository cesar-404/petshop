package com.petshop.pet.shot.controllers;

import com.petshop.pet.shot.dtos.PetDto;
import com.petshop.pet.shot.dtos.UpdatePetDto;
import com.petshop.pet.shot.models.Pet;
import com.petshop.pet.shot.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@AllArgsConstructor
public class PetController {

    PetService petService;

    //Crate a pet
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDto petDto) {
        var pet = petService.savePet(petDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @GetMapping("{petId}")
    public ResponseEntity<Pet> getById(@PathVariable("petId") String petId) {
        var pet = petService.findById(petId);
        if(pet.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(pet.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listAll() {
        List<Pet> pets = petService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pets);
    }

    @PutMapping("{petId}")
    public ResponseEntity<Void> updatePetById(@PathVariable("petId") String petId,
                                              @RequestBody UpdatePetDto updateClientDto) {
        petService.updateById(petId, updateClientDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{petId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("petId") String petId) {
        petService.deleteById(petId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
