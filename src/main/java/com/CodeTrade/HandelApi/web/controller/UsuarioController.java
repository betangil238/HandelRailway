package com.CodeTrade.HandelApi.web.controller;
import com.CodeTrade.HandelApi.persistence.entity.Usuario;
import com.CodeTrade.HandelApi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(this.usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.usuarioService.getUser(id));
    }

    @GetMapping("/validacion/{email}")
    public ResponseEntity<Optional<Usuario>> getUserEmail(@PathVariable("email") String email){
        return  ResponseEntity.ok(this.usuarioService.getUserEmail(email));
    }
    @GetMapping("/validusuario/{usuario}")
    public ResponseEntity<Optional<Usuario>> getUuario1(@PathVariable("usuario") String usuario){
        return  ResponseEntity.ok(this.usuarioService.getUsuario1(usuario));
    }
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario user){
        if(user.getIdUsuario() == null || !this.usuarioService.existe(user.getIdUsuario())){
            return ResponseEntity.ok(this.usuarioService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario user){
        if(user.getIdUsuario() != null && this.usuarioService.existe(user.getIdUsuario())){
            return ResponseEntity.ok(this.usuarioService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable  int id){
        if(this.usuarioService.existe(id)){
            this.usuarioService.delete(id);
            return ResponseEntity.ok().build();
        };
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/{id}/imagen")
    public ResponseEntity<String> actualizarImagen(
            @PathVariable Long id,
            @RequestPart("imagen") MultipartFile imagenFile) {
        try {
            byte[] imagen = imagenFile.getBytes();
            int rowsAffected = usuarioService.actualizarImagen(id, imagen);
            if (rowsAffected > 0) {
                return ResponseEntity.ok("Imagen actualizada con éxito.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el usuario.");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la imagen.");
        }
    }

}
