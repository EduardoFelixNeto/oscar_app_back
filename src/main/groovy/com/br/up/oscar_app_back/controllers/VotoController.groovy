package com.br.up.oscar_app_back.controllers

import com.br.up.oscar_app_back.services.VotoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/votos")
class VotoController {
    private final VotoService votoService

    VotoController(VotoService votoService) {
        this.votoService = votoService
    }

    @PostMapping
    ResponseEntity<?> registrarVoto(@RequestBody Map<String, Object> request) {
        try {
            Long userId = Long.parseLong(request.get("userId").toString())
            Integer token = Integer.parseInt(request.get("token").toString())
            Long filmeId = Long.parseLong(request.get("filmeId").toString())
            Long diretorId = Long.parseLong(request.get("diretorId").toString())

            votoService.registrarVoto(userId, token, filmeId, diretorId)
            return ResponseEntity.ok([message: "Voto registrado com sucesso"])
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body([error: e.message])
        }
    }

}
