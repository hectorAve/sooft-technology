package com.soft.technology.transactions_management.application.service;

import com.soft.technology.transactions_management.domain.model.EmpresaDTO;

public interface EmpresaService {
    Iterable<EmpresaDTO> getEmpresasByLastMonthsOfAdherence();
    Iterable<EmpresaDTO> getEmpresasWithTransferencesByLastMonths();
    EmpresaDTO addEmpresa(EmpresaDTO empresaDTO);
}
