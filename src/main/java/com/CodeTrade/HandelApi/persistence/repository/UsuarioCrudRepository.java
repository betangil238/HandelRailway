package com.CodeTrade.HandelApi.persistence.repository;

import com.CodeTrade.HandelApi.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends ListCrudRepository<Usuario,Integer> {
    List<Usuario> findByNameOrderByIdUsuarioAsc(String name);
    Optional<List<Usuario>> findByResetLessThanAndSaldo(int reset, BigDecimal saldo);
    Usuario findByEmail(String email);
    Usuario findByUsuario1(String usuario);
    @Modifying
    @Query("UPDATE Usuario u SET u.imagen = :imagen WHERE u.id = :id")
    int updateImagen(@Param("id") Long id, @Param("imagen") byte[] imagen);
}
