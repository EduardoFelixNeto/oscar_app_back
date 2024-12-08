package com.br.up.oscar_app_back.entities

import jakarta.persistence.*

@Entity
@Table(name = "diretores")
class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    String nome
}

