package com.petshop.pet.shot.dtos;

public record UpdateClientDto(String email,
                              String phoneNumber,
                              String cep) {
}
