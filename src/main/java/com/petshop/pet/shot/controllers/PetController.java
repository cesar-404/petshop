package com.petshop.pet.shot.controllers;

import com.petshop.pet.shot.dtos.PetDto;
import com.petshop.pet.shot.models.Pet;
import com.petshop.pet.shot.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
