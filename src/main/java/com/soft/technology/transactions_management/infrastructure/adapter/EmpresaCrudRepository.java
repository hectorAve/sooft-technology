package com.soft.technology.transactions_management.infrastructure.adapter;

import com.soft.technology.transactions_management.infrastructure.entity.EmpresaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpresaCrudRepository extends PagingAndSortingRepository<EmpresaEntity, Long> {
    Page<EmpresaEntity> findByFechaAdhesionAfter(Date fechaAdhesion, Pageable pageable);

    @Query("select e from EmpresaEntity e where e.cuit in ?1")
    Page<EmpresaEntity> findByCuitContaining(List<Long> cuitEmpresas, Pageable pageable);

    EmpresaEntity save(EmpresaEntity empresaEntity);

    Boolean existsByCuit(Long cuit);
}
