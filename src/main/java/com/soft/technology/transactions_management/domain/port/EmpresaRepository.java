package com.soft.technology.transactions_management.domain.port;

import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpresaRepository {
    Iterable<EmpresaDTO> getEmpresasByLastMonthsOfAdherence(Pageable pageable);
    Iterable<EmpresaDTO> findByCuitContaining(List<Long> cuitEmpresas, Pageable pageable);
    EmpresaDTO addEmpresa(EmpresaDTO empresaDTO);
    Boolean findByCuit(Long cuit);
}
