package com.br.up.oscar_app_back.controllers

import com.br.up.oscar_app_back.entities.Filme
import com.br.up.oscar_app_back.services.FilmeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/filmes")
class FilmeController {
    private final FilmeService filmeService

    FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService
    }

    @GetMapping
    ResponseEntity<List<Filme>> getAllFilmes() {
        return ResponseEntity.ok(filmeService.getAllFilmes())
    }
}
