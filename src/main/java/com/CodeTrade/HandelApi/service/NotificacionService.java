package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.Notificacion;
import com.CodeTrade.HandelApi.persistence.repository.NotificacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionCrudRepository notificacionCrudRepository;
    @Autowired
    public NotificacionService(NotificacionCrudRepository notificacionCrudRepository) {
        this.notificacionCrudRepository = notificacionCrudRepository;
    }

    public List<Notificacion> getAll(){
        return this.notificacionCrudRepository.findAll();
    }
    public Notificacion getNotificacion(int id){
        return this.notificacionCrudRepository.findById(id).orElse(null);
    }
    public Notificacion save(Notificacion notificacion){
        return this.notificacionCrudRepository.save(notificacion);
    }
    public boolean existe(int id){
        return this.notificacionCrudRepository.existsById(id);
    }
    public void delete(int notificacionId){this.notificacionCrudRepository.deleteById(notificacionId);}
}
