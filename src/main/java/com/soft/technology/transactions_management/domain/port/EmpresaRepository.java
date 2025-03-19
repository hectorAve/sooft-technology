package com.soft.technology.transactions_management.domain.port;

import com.soft.technology.transactions_management.domain.model.EmpresaDTO;

import java.util.List;

public interface EmpresaRepository {
    Iterable<EmpresaDTO> getEmpresasByLastMonthsOfAdherence();
    Iterable<EmpresaDTO> findByCuitContaining(List<Long> cuitEmpresas);
    EmpresaDTO addEmpresa(EmpresaDTO empresaDTO);
}
