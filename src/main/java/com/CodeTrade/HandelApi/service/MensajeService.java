package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.Mensajes;
import com.CodeTrade.HandelApi.persistence.repository.MensajesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeService {

    private final MensajesCrudRepository mensajesCrudRepository;

    @Autowired
    public MensajeService(MensajesCrudRepository mensajesCrudRepository) {
        this.mensajesCrudRepository = mensajesCrudRepository;
    }

    public List<Mensajes> getAll(){
        return this.mensajesCrudRepository.findAll();
    }
    public Mensajes getMensaje(int id){
        return this.mensajesCrudRepository.findById(id).orElse(null);
    }
    public Mensajes save(Mensajes mensajes){
        return this.mensajesCrudRepository.save(mensajes);
    }
    public boolean existe(int id){
        return this.mensajesCrudRepository.existsById(id);
    }
    public void delete(int mensajeId){
        this.mensajesCrudRepository.deleteById(mensajeId);}
    }
