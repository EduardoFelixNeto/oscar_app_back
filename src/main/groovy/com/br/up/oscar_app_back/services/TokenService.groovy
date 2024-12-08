package com.br.up.oscar_app_back.services

import com.br.up.oscar_app_back.entities.Usuario
import com.br.up.oscar_app_back.repositories.UsuarioRepository
import org.springframework.stereotype.Service

import java.util.Random

@Service
class TokenService {
    private final UsuarioRepository usuarioRepository

    TokenService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository
    }

    Integer generateToken(Long userId) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
        Random random = new Random()
        Integer token = random.nextInt(100)
        usuario.token = token
        usuarioRepository.save(usuario)
        return token
    }

    void validateToken(Long userId, Integer token) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
        if (usuario.token != token) {
            throw new RuntimeException("Token inválido")
        }
    }
}

