package com.CodeTrade.HandelApi.web.controller;

import com.CodeTrade.HandelApi.persistence.entity.Notificacion;
import com.CodeTrade.HandelApi.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notificacion")
public class NotificacionController {
    private final NotificacionService notificacionService;
    @Autowired
    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }
    @GetMapping
    public ResponseEntity<List<Notificacion>> getAll(){
        return ResponseEntity.ok(this.notificacionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> getNotificacion(@PathVariable("id") int id){
        return ResponseEntity.ok(this.notificacionService.getNotificacion(id));
    }

    @PostMapping
    public ResponseEntity<Notificacion> save(@RequestBody Notificacion notificacion){
        if (notificacion.getIdnotificacion() == null || !this.notificacionService.existe(notificacion.getIdnotificacion())) {
        return ResponseEntity.ok(this.notificacionService.save(notificacion));
    }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Notificacion> update(@RequestBody Notificacion notificacion){
        if(notificacion.getIdnotificacion() != null && this.notificacionService.existe(notificacion.getIdnotificacion())){
            return ResponseEntity.ok(this.notificacionService.save(notificacion));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable  int id){
        if(this.notificacionService.existe(id)){
            this.notificacionService.delete(id);
            return ResponseEntity.ok().build();
        };
        return ResponseEntity.badRequest().build();
    }

}
