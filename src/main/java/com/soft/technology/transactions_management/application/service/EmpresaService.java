package com.soft.technology.transactions_management.application.service;

import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import org.springframework.data.domain.Pageable;

public interface EmpresaService {
    Iterable<EmpresaDTO> getEmpresasByLastMonthsOfAdherence(Pageable pageable);
    Iterable<EmpresaDTO> getEmpresasWithTransferencesByLastMonths(Pageable pageable);
    EmpresaDTO addEmpresa(EmpresaDTO empresaDTO);
}
