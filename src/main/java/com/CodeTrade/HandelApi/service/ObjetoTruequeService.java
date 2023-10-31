package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.ObjetoTrueque;
import com.CodeTrade.HandelApi.persistence.repository.ObjetoTruequeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ObjetoTruequeService {

    private final ObjetoTruequeCrudRepository objetoTruequeCrudRepository;
    @Autowired
    public ObjetoTruequeService(ObjetoTruequeCrudRepository objetoTruequeCrudRepository) {
        this.objetoTruequeCrudRepository = objetoTruequeCrudRepository;
    }

    public List<ObjetoTrueque> getAll(){
        return this.objetoTruequeCrudRepository.findAll();
    }
    public ObjetoTrueque getObjTrueque(int id){
        return this.objetoTruequeCrudRepository.findById(id).orElse(null);
    }
    public ObjetoTrueque save(ObjetoTrueque objtrueque){
        return this.objetoTruequeCrudRepository.save(objtrueque);
    }

    public boolean existe(int id){
        return this.objetoTruequeCrudRepository.existsById(id);
    }
    public void delete(int objtruequeId){
        this.objetoTruequeCrudRepository.deleteById(objtruequeId);
    }
}
