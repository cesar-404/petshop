package com.petshop.pet.shot.dtos;

import com.petshop.pet.shot.models.Client;

public record PetDto(String name,
                     String specie,
                     int age,
                     Client client) {
}
