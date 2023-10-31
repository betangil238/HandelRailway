package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.ObjetoSubasta;
import com.CodeTrade.HandelApi.persistence.repository.ObjetoSubastaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoSubastaService {

    private final ObjetoSubastaCrudRepository subastaCrudRepository;
    @Autowired
    public ObjetoSubastaService(ObjetoSubastaCrudRepository subastaCrudRepository) {
        this.subastaCrudRepository = subastaCrudRepository;
    }

    public List<ObjetoSubasta> getAll(){
        return this.subastaCrudRepository.findAll();
    }
    public ObjetoSubasta getObjSubasta(int id){
        return this.subastaCrudRepository.findById(id).orElse(null);
    }
    public ObjetoSubasta save(ObjetoSubasta objectBid){
        return this.subastaCrudRepository.save(objectBid);
    }
    public boolean existe(int id){
        return this.subastaCrudRepository.existsById(id);
    }

    public void delete(int ObjSubId){this.subastaCrudRepository.deleteById(ObjSubId);}
}
