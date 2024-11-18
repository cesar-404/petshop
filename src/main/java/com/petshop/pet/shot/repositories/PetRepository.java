package com.petshop.pet.shot.repositories;

import com.petshop.pet.shot.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetRepository extends JpaRepository<Pet, UUID> {
}
