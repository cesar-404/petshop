package com.petshop.pet.shot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_pets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "specie")
    private String specie;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
