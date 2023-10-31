package com.CodeTrade.HandelApi.web.controller;

import com.CodeTrade.HandelApi.persistence.entity.Mensajes;
import com.CodeTrade.HandelApi.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/mensaje")
public class MensajeController {
    private final MensajeService mensajeService;
    @Autowired
    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping
    public ResponseEntity<List<Mensajes>> getAll(){
        return ResponseEntity.ok(this.mensajeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mensajes> getMensaje(int id){
        return ResponseEntity.ok(this.mensajeService.getMensaje(id));
    }

    @PostMapping
    public ResponseEntity<Mensajes> save(@RequestBody Mensajes mensaje){
        if(mensaje.getIdmensajes() == null || this.mensajeService.existe(mensaje.getIdmensajes())){
            return ResponseEntity.ok(this.mensajeService.save(mensaje));
        }
            return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<Mensajes> update(@RequestBody Mensajes mensaje){
        if(mensaje.getIdmensajes()  != null && this.mensajeService.existe(mensaje.getIdmensajes())){
            return ResponseEntity.ok(this.mensajeService.save(mensaje));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable  int id){
        if(this.mensajeService.existe(id)){
            this.mensajeService.delete(id);
            return ResponseEntity.ok().build();
        };
        return ResponseEntity.badRequest().build();
    }
}
