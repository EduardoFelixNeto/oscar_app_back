package com.br.up.oscar_app_back.services

import com.br.up.oscar_app_back.entities.Usuario
import com.br.up.oscar_app_back.repositories.UsuarioRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService {
    private final UsuarioRepository usuarioRepository
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder()

    AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository
    }

    Usuario authenticate(String email, String senha) {
        System.out.println("Autenticando usuário - Email: " + email)

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> {
                    System.out.println("Usuário não encontrado: " + email)
                    return new RuntimeException("Usuário não encontrado")
                })

        if (!passwordEncoder.matches(senha, usuario.senha)) {
            System.out.println("Senha inválida para o email: " + email)
            throw new RuntimeException("Senha inválida")
        }

        System.out.println("Usuário autenticado com sucesso: " + usuario.getId())
        return usuario
    }

}
