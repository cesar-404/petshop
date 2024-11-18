package com.petshop.pet.shot.services;

import com.petshop.pet.shot.dtos.PetDto;
import com.petshop.pet.shot.dtos.UpdateClientDto;
import com.petshop.pet.shot.dtos.UpdatePetDto;
import com.petshop.pet.shot.models.Client;
import com.petshop.pet.shot.models.Pet;
import com.petshop.pet.shot.repositories.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PetService {

    PetRepository petRepository;

    //CreatePet
    public Pet savePet(PetDto petDto) {
        var pet = new Pet();
        pet.setName(petDto.name());
        pet.setSpecie(petDto.specie());
        pet.setAge(petDto.age());
        pet.setClient(petDto.client());
        petRepository.save(pet);
        return pet;
    }

    public Optional<Pet> findById(String petId) {
        var id = UUID.fromString(petId);
        return petRepository.findById(id);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public void updateById(String petId, UpdatePetDto updatePetDto) {
        var id = UUID.fromString(petId);
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            pet.get().setName(updatePetDto.name());
            pet.get().setSpecie(updatePetDto.specie());
            pet.get().setAge(updatePetDto.age());
            petRepository.save(pet.get());
        }
    }

    public void deleteById(String petId) {
        var id = UUID.fromString(petId);
        Optional<Pet> pet = petRepository.findById(id);
        if (pet.isPresent()) {
            petRepository.delete(pet.get());
        } else {
            throw new NoSuchElementException("Client with id " + petId + " not found.");
        }
    }

}
