package com.soft.technology.transactions_management.application.service;

import com.soft.technology.transactions_management.domain.port.TransaccionesRepository;

import java.util.List;

public class DomainTransaccionesService implements TransacionesService {
    private final TransaccionesRepository transaccionesRepository;

    public DomainTransaccionesService(TransaccionesRepository transaccionesRepository) {
        this.transaccionesRepository = transaccionesRepository;
    }

    @Override
    public List<Long> getEmpresasWithTransferencesByLastMonths() {
        return transaccionesRepository.getEmpresasWithTransferencesByLastMonths();
    }
}
