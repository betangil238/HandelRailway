package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.Trueque;
import com.CodeTrade.HandelApi.persistence.repository.TruequeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruequeService {

    private final TruequeCrudRepository truequeCrudRepository;

    @Autowired
    public TruequeService(TruequeCrudRepository truequeCrudRepository) {
        this.truequeCrudRepository = truequeCrudRepository;
    }

    public List<Trueque> getAll(){
        return this.truequeCrudRepository.findAll();
    }
    public Trueque getTrueque(int id){
        return this.truequeCrudRepository.findById(id).orElse(null);
    }

    public Trueque save(Trueque trueque){
        return this.truequeCrudRepository.save(trueque);
    }

    public boolean existe(int id){
        return this.truequeCrudRepository.existsById(id);
    }

    public boolean existeTrueque(Trueque trueque){
        List<Trueque> trueques = getAll();
        for (Trueque t: trueques) {
            if(t.getIdObjetoTrueque1().equals(trueque.getIdObjetoTrueque1()) && t.getIdObjetoTrueque2().equals(trueque.getIdObjetoTrueque2())){
                return this.truequeCrudRepository.existsById(t.getIdtrueques());
            }
        }
        return false;
    }

    public int verificarTrueque(Trueque trueque){
        List<Trueque> trueques = getAll();
        for (Trueque t: trueques) {
            if(t.getIdObjetoTrueque1().equals(trueque.getIdObjetoTrueque2()) && t.getIdObjetoTrueque2().equals(trueque.getIdObjetoTrueque1())){
                return t.getIdtrueques();
            }
        }
        return 0;
    }


    public void delete(int truequeId){
        this.truequeCrudRepository.deleteById(truequeId);
    }
}
