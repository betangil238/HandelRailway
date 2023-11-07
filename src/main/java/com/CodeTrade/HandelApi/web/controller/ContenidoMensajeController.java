package com.CodeTrade.HandelApi.web.controller;

import com.CodeTrade.HandelApi.persistence.entity.ContenidoMensaje;
import com.CodeTrade.HandelApi.service.ContenidoMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contenido")
public class ContenidoMensajeController {

    private final ContenidoMensajeService contenidoMensajeService;

    @Autowired
    public ContenidoMensajeController(ContenidoMensajeService contenidoMensajeService) {
        this.contenidoMensajeService = contenidoMensajeService;
    }

    @GetMapping
    public ResponseEntity<List<ContenidoMensaje>> getAll(){
        return ResponseEntity.ok(this.contenidoMensajeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContenidoMensaje> getMensaje(int id){
        return ResponseEntity.ok(this.contenidoMensajeService.getMensaje(id));
    }

    @PostMapping
    public ResponseEntity<ContenidoMensaje> save(@RequestBody ContenidoMensaje contenido){
        if(contenido.getIdChat() == null || this.contenidoMensajeService.existe(contenido.getIdChat())){
            return ResponseEntity.ok(this.contenidoMensajeService.save(contenido));
        }
        return ResponseEntity.badRequest().build();
    }
}
