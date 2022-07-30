/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Security.Servicios;

import com.argprog.jverbauwede.Security.Entity.Usuario;
import com.argprog.jverbauwede.Security.Repos.iUsuarioRepo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonatan
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepo iusuarioRepo;
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    public boolean existsByCorreo(String correo){
        return iusuarioRepo.existsByCorreo(correo);
    }
    public void save(Usuario usuario){
        iusuarioRepo.save(usuario);
    }
    public void deleteUsuario (Long id){
            iusuarioRepo.deleteById(id);
    }
}
