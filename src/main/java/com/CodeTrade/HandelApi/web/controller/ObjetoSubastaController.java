package com.CodeTrade.HandelApi.web.controller;

import com.CodeTrade.HandelApi.persistence.entity.ObjetoSubasta;
import com.CodeTrade.HandelApi.service.ObjetoSubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/objsubasta")
public class ObjetoSubastaController {
    private final ObjetoSubastaService objetoSubastaService;

    @Autowired
    public ObjetoSubastaController(ObjetoSubastaService objetoSubastaService) {
        this.objetoSubastaService = objetoSubastaService;
    }
    @GetMapping
    public ResponseEntity<List<ObjetoSubasta>> getAll(){
        return ResponseEntity.ok(this.objetoSubastaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetoSubasta> getObjSubasta(@PathVariable("id") int id){

        return ResponseEntity.ok(this.objetoSubastaService.getObjSubasta(id));
    }

    @PostMapping
    public ResponseEntity<ObjetoSubasta> save(@RequestBody ObjetoSubasta objSubasta){
        if (objSubasta.getIdsubastas() == null || !this.objetoSubastaService.existe(objSubasta.getIdsubastas())) {
            return ResponseEntity.ok(this.objetoSubastaService.save(objSubasta));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ObjetoSubasta> update(@RequestBody ObjetoSubasta objSubasta){
        if(objSubasta.getIdsubastas() != null && this.objetoSubastaService.existe(objSubasta.getIdsubastas())){
            return ResponseEntity.ok(this.objetoSubastaService.save(objSubasta));
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable  int id){
        if(this.objetoSubastaService.existe(id)){
            this.objetoSubastaService.delete(id);
            return ResponseEntity.ok().build();
        };
        return ResponseEntity.badRequest().build();
    }
}
