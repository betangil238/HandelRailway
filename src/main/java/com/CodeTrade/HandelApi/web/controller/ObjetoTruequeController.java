package com.CodeTrade.HandelApi.web.controller;
import com.CodeTrade.HandelApi.persistence.entity.ObjetoTrueque;
import com.CodeTrade.HandelApi.service.ObjetoTruequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/objtrueque")
public class ObjetoTruequeController {

    private final ObjetoTruequeService objetoTruequeService;

    @Autowired
    public ObjetoTruequeController(ObjetoTruequeService objetoTruequeService) {
        this.objetoTruequeService = objetoTruequeService;
    }

    @GetMapping
    public ResponseEntity<List<ObjetoTrueque>> getAll(){
        return ResponseEntity.ok(this.objetoTruequeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ObjetoTrueque> getObjTrueque(@PathVariable("id") int id){
        return ResponseEntity.ok(this.objetoTruequeService.getObjTrueque(id));
    }

    @PostMapping
    public ResponseEntity<ObjetoTrueque> save(@RequestBody ObjetoTrueque objTrueque){
        if (objTrueque.getIdTrueques() == null || !this.objetoTruequeService.existe(objTrueque.getIdTrueques())){
            return ResponseEntity.ok(this.objetoTruequeService.save(objTrueque));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ObjetoTrueque> update(@RequestBody ObjetoTrueque objTrueque){
        if(objTrueque.getIdTrueques() != null && this.objetoTruequeService.existe(objTrueque.getIdTrueques())){
            return ResponseEntity.ok(this.objetoTruequeService.save(objTrueque));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable  int id){
        if(this.objetoTruequeService.existe(id)){
            this.objetoTruequeService.delete(id);
            return ResponseEntity.ok().build();
        };
        return ResponseEntity.badRequest().build();
    }

}
