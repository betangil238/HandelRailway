package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.ContenidoMensaje;
import com.CodeTrade.HandelApi.persistence.repository.ContenidoMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContenidoMensajeService {
    private final ContenidoMensajeRepository contenidoMensajeRepository;
    @Autowired
    public ContenidoMensajeService(ContenidoMensajeRepository contenidoMensajeRepository) {
        this.contenidoMensajeRepository = contenidoMensajeRepository;
    }
    public ContenidoMensaje save(ContenidoMensaje contenido){
        return this.contenidoMensajeRepository.save(contenido);
    }
    public List<ContenidoMensaje> getAll(){
        return this.contenidoMensajeRepository.findAll();
    }
    public ContenidoMensaje getMensaje(int id){
        return this.contenidoMensajeRepository.findById(id).orElse(null);
    }
    public boolean existe(int id){
        return this.contenidoMensajeRepository.existsById(id);
    }
}
