/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.argprog.jverbauwede.Security.Repos;

import com.argprog.jverbauwede.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jonatan
 */
public interface iUsuarioRepo extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario (String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByCorreo(String correo);
}
