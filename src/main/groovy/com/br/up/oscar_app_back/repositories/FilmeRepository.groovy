package com.br.up.oscar_app_back.repositories

import com.br.up.oscar_app_back.entities.Filme
import org.springframework.data.jpa.repository.JpaRepository

interface FilmeRepository extends JpaRepository<Filme, Long> {
}
