package com.petshop.pet.shot.dtos;

import java.util.UUID;

public record AddressDto(String logradouro,
                         String bairro,
                         String localidade,
                         String uf,
                         UUID id) {
}