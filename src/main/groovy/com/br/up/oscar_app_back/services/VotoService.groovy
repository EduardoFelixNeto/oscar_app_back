package com.br.up.oscar_app_back.services

import com.br.up.oscar_app_back.entities.Usuario
import com.br.up.oscar_app_back.repositories.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class VotoService {
    private final UsuarioRepository usuarioRepository
    private final TokenService tokenService

    VotoService(UsuarioRepository usuarioRepository, TokenService tokenService) {
        this.usuarioRepository = usuarioRepository
        this.tokenService = tokenService
    }

    void registrarVoto(Long userId, Integer token, Long filmeId, Long diretorId) {
        tokenService.validateToken(userId, token)
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
        if (usuario.votoFilme || usuario.votoDiretor) {
            throw new RuntimeException("Votos já registrados")
        }
        usuario.votoFilme = filmeId
        usuario.votoDiretor = diretorId
        usuarioRepository.save(usuario)
    }
}

