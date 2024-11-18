package com.petshop.pet.shot.services;

import com.petshop.pet.shot.dtos.PetDto;
import com.petshop.pet.shot.models.Pet;
import com.petshop.pet.shot.repositories.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

}
