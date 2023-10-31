package com.CodeTrade.HandelApi.persistence.repository;

import com.CodeTrade.HandelApi.persistence.entity.Usuario;
import org.springframework.data.repository.ListCrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends ListCrudRepository<Usuario,Integer> {
    List<Usuario> findByNameOrderByIdUsuarioAsc(String name);
    Optional<List<Usuario>> findByResetLessThanAndSaldo(int reset, BigDecimal saldo);
}
