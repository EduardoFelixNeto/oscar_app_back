package com.br.up.oscar_app_back.repositories

import com.br.up.oscar_app_back.entities.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email)
}
