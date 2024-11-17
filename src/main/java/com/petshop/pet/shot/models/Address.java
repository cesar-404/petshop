package com.petshop.pet.shot.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "street")
    private String logradouro;

    @Column(name = "address_complement")
    private String complemento;

    @Column(name = "district")
    private String bairro;

    @Column(name = "city")
    private String localidade;

    @Column(name = "state")
    private String uf;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
