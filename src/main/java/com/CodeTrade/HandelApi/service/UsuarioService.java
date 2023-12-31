package com.CodeTrade.HandelApi.service;

import com.CodeTrade.HandelApi.persistence.entity.Usuario;
import com.CodeTrade.HandelApi.persistence.repository.UsuarioCrudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    public UsuarioService(UsuarioCrudRepository usuarioCrudRepository) {
        this.usuarioCrudRepository = usuarioCrudRepository;
    }

    public List<Usuario> getAll(){
        return this.usuarioCrudRepository.findAll();
    }

    public Optional<List<Usuario>> getByNombre(String nombre){
        return Optional.ofNullable(this.usuarioCrudRepository.findByNameOrderByIdUsuarioAsc(nombre));
    }

    public Optional<List<Usuario>> getWithOutReset(){
        BigDecimal saldoMax = new BigDecimal("0.000");
        return this.usuarioCrudRepository.findByResetLessThanAndSaldo(1,saldoMax);
    }

    public Usuario getUser(int id){
        return this.usuarioCrudRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario user){
        return this.usuarioCrudRepository.save(user);
    }

    public Optional<Usuario> getUserEmail(String email){
        return Optional.ofNullable(this.usuarioCrudRepository.findByEmail(email));
    }

    public Optional<Usuario> getUsuario1(String usuario){
        return Optional.ofNullable(this.usuarioCrudRepository.findByUsuario1(usuario));
    }
    public boolean existe(int id){
        return this.usuarioCrudRepository.existsById(id);
    }

    public void delete(int userId){
        this.usuarioCrudRepository.deleteById(userId);
    }

    @Transactional
    public int actualizarImagen(Long id, byte[] imagen) {
        return usuarioCrudRepository.updateImagen(id, imagen);
    }

}
