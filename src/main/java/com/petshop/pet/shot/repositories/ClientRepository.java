package com.petshop.pet.shot.repositories;

import com.petshop.pet.shot.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
