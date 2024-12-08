package com.br.up.oscar_app_back.repositories

import com.br.up.oscar_app_back.entities.Diretor
import org.springframework.data.jpa.repository.JpaRepository

interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
