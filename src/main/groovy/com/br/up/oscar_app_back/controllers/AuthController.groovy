package com.br.up.oscar_app_back.controllers

import com.br.up.oscar_app_back.entities.Usuario
import com.br.up.oscar_app_back.repositories.UsuarioRepository
import com.br.up.oscar_app_back.services.TokenService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus


@RestController
@RequestMapping("/auth")
class AuthController {
    private final TokenService tokenService
    private final UsuarioRepository usuarioRepository
    private final BCryptPasswordEncoder passwordEncoder

    AuthController(TokenService tokenService, UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.tokenService = tokenService
        this.usuarioRepository = usuarioRepository
        this.passwordEncoder = passwordEncoder
    }

    @GetMapping("/token/{idUsuario}")
    ResponseEntity<?> generateToken(@PathVariable Long idUsuario) {
        try {
            Integer token = tokenService.generateToken(idUsuario)
            return ResponseEntity.ok([token: token])
        } catch (Exception e) {
            return ResponseEntity.status(400).body([error: e.message])
        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email")
            String senha = request.get("senha")
            System.out.println("Login attempt - Email: " + email + ", Senha: " + senha)

            Usuario usuario = usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> {
                        System.out.println("Usuário não encontrado para o email: " + email)
                        return new RuntimeException("Usuário não encontrado")
                    })

            if (senha != usuario.getSenha()) {
                System.out.println("Senha inválida para o usuário: " + email)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha inválida")
            }

            Integer token = tokenService.generateToken(usuario.getId())
            System.out.println("Autenticação bem-sucedida - Usuário ID: " + usuario.getId() + ", Token: " + token)

            return ResponseEntity.ok(Map.of("id", usuario.getId(), "token", token))
        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage())
            return ResponseEntity.status(400).body([error: e.message])
        }
    }

}

