package com.br.up.oscar_app_back.services

import com.br.up.oscar_app_back.entities.Diretor
import com.br.up.oscar_app_back.repositories.DiretorRepository
import org.springframework.stereotype.Service

@Service
class DiretorService {
    private final DiretorRepository diretorRepository

    DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository
    }

    List<Diretor> getAllDiretores() {
        return diretorRepository.findAll()
    }
}

