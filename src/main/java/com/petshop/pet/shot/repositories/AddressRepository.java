package com.petshop.pet.shot.repositories;

import com.petshop.pet.shot.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
