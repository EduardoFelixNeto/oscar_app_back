package com.br.up.oscar_app_back.entities

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String nome

    @Column(unique = true, nullable = false)
    String email

    @Column(nullable = false)
    String senha

    Integer token

    Long votoFilme

    Long votoDiretor
}
