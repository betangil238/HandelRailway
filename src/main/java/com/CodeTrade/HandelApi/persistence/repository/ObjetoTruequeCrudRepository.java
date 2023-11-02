package com.CodeTrade.HandelApi.persistence.repository;

import com.CodeTrade.HandelApi.persistence.entity.ObjetoTrueque;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ObjetoTruequeCrudRepository extends ListCrudRepository<ObjetoTrueque,Integer> {

}
