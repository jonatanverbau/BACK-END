/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.argprog.jverbauwede.Security.Controller;

import com.argprog.jverbauwede.Security.Dto.JwtDto;
import com.argprog.jverbauwede.Security.Dto.LoginUsuario;
import com.argprog.jverbauwede.Security.Dto.NuevoUsuario;
import com.argprog.jverbauwede.Security.Entity.Rol;
import com.argprog.jverbauwede.Security.Entity.Usuario;
import com.argprog.jverbauwede.Security.Enums.RolNombre;
import com.argprog.jverbauwede.Security.Servicios.RolService;
import com.argprog.jverbauwede.Security.Servicios.UsuarioService;
import com.argprog.jverbauwede.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jonatan
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping ("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){ 
       if(bindingResult.hasErrors())
           return new ResponseEntity(new Mensaje("Campos o Correo Invalidos"),HttpStatus.BAD_REQUEST);
    
       if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
           return new ResponseEntity(new Mensaje("Nombre de usuario ya utilizado"), HttpStatus.BAD_REQUEST);
    
        if(usuarioService.existsByCorreo(nuevoUsuario.getCorreo()))
           return new ResponseEntity(new Mensaje("Correo ya utilizado"), HttpStatus.BAD_REQUEST);
    
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getCorreo(), passwordEncoder.encode(nuevoUsuario.getPassword()));
    
        Set<Rol> roles = new HashSet<>();
        if (nuevoUsuario.getRoles().contains("user"))
            roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());
    
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROL_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity (new Mensaje("Usuario generado con exito"), HttpStatus.CREATED);
        
    }
    
    @PostMapping ("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Usuario o Contraseña Incorrecto"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                            loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
   
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
    
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
        @DeleteMapping("/borrar/{id}")
        public String deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return "El usuario fue eliminado correctamente";
    }
}
