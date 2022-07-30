/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Security.Servicios;

import com.argprog.jverbauwede.Security.Entity.Rol;
import com.argprog.jverbauwede.Security.Enums.RolNombre;
import com.argprog.jverbauwede.Security.Repos.IRolRepo;
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
public class RolService {
    @Autowired
    IRolRepo irolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepo.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        irolRepo.save(rol);
    }
}
