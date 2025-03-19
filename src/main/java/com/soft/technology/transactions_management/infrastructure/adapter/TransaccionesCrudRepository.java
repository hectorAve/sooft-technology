package com.soft.technology.transactions_management.infrastructure.adapter;

import com.soft.technology.transactions_management.infrastructure.entity.TransaccionesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransaccionesCrudRepository extends CrudRepository<TransaccionesEntity, Long> {

    @Query("select t.empresaEntity.cuit from TransaccionesEntity t where t.fechaTransaccion >= ?1")
    List<Long> findByFechaTransaccionAfter(Date fechaTransaccion);
}
