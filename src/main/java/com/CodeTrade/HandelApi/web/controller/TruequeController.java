package com.CodeTrade.HandelApi.web.controller;
import com.CodeTrade.HandelApi.persistence.entity.Trueque;
import com.CodeTrade.HandelApi.service.TruequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/trueque")
public class TruequeController {

    private final TruequeService truequeService;
    @Autowired
    public TruequeController(TruequeService truequeService) {
        this.truequeService = truequeService;
    }
    @GetMapping
    public ResponseEntity<List<Trueque>> getAll(){
        return ResponseEntity.ok(this.truequeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trueque> getTrueque(@PathVariable("id") int id){
        return ResponseEntity.ok(this.truequeService.getTrueque(id));
    }
    @PostMapping
    public ResponseEntity<Trueque> save(@RequestBody Trueque trueque){
        if(this.truequeService.existeTrueque(trueque)){
            return ResponseEntity.badRequest().build();
        }
        int id = this.truequeService.verificarTrueque(trueque);
        if(id!=0){
            Trueque truequeCompleto= getTrueque(id).getBody();
            truequeCompleto.setEstado("Exitoso");
            return ResponseEntity.ok(this.truequeService.save(truequeCompleto));
        }
        if (trueque.getIdtrueques() == null || !this.truequeService.existe(trueque.getIdtrueques())){
            if(trueque.getIdObjetoTrueque1().equals(trueque.getIdObjetoTrueque2())){
                return ResponseEntity.badRequest().build();
            }else{
                return ResponseEntity.ok(this.truequeService.save(trueque));
            }
        }
            return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Trueque> update(@RequestBody Trueque trueque){
        if(trueque.getIdtrueques() != null && this.truequeService.existe(trueque.getIdtrueques())){
            return ResponseEntity.ok(this.truequeService.save(trueque));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable  int id){
        if(this.truequeService.existe(id)){
            this.truequeService.delete(id);
            return ResponseEntity.ok().build();
        };
        return ResponseEntity.badRequest().build();
    }

}
