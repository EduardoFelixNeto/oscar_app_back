package com.br.up.oscar_app_back.entities

import jakarta.persistence.*

@Entity
@Table(name = "filmes")
class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false)
    String nome

    @Column(nullable = false)
    String genero

    @Column(name = "foto_url", nullable = false)
    String fotoUrl
}

