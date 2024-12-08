package com.br.up.oscar_app_back.services

import com.br.up.oscar_app_back.entities.Filme
import com.br.up.oscar_app_back.repositories.FilmeRepository
import org.springframework.stereotype.Service

@Service
class FilmeService {
    private final FilmeRepository filmeRepository

    FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository
    }

    List<Filme> getAllFilmes() {
        return filmeRepository.findAll()
    }
}

