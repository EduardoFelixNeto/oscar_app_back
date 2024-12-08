package com.br.up.oscar_app_back.controllers

import com.br.up.oscar_app_back.entities.Diretor
import com.br.up.oscar_app_back.services.DiretorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diretores")
class DiretorController {
    private final DiretorService diretorService

    DiretorController(DiretorService diretorService) {
        this.diretorService = diretorService
    }

    @GetMapping
    ResponseEntity<List<Diretor>> getAllDiretores() {
        return ResponseEntity.ok(diretorService.getAllDiretores())
    }
}

