package com.petshop.pet.shot.dtos;

import com.petshop.pet.shot.models.Pet;

import java.util.List;
import java.util.UUID;

public record ClientDto(String name,
                        String email,
                        String phoneNumber,
                        String cep){
}
