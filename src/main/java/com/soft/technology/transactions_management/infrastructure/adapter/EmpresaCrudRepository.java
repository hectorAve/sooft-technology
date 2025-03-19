package com.soft.technology.transactions_management.infrastructure.adapter;

import com.soft.technology.transactions_management.infrastructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpresaCrudRepository extends CrudRepository<EmpresaEntity, Long> {
    Iterable<EmpresaEntity> findByFechaAdhesionAfter(Date fechaAdhesion);
    @Query("select e from EmpresaEntity e where e.cuit in ?1")
    Iterable<EmpresaEntity> findByCuitContaining(List<Long> cuitEmpresas);
}
