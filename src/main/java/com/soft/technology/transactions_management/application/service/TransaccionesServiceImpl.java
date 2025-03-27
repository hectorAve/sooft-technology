package com.soft.technology.transactions_management.application.service;

import com.soft.technology.transactions_management.domain.port.TransaccionesRepository;

import java.util.List;

public class TransaccionesServiceImpl implements TransaccionesService {
    private final TransaccionesRepository transaccionesRepository;

    public TransaccionesServiceImpl(TransaccionesRepository transaccionesRepository) {
        this.transaccionesRepository = transaccionesRepository;
    }

    @Override
    public List<Long> getEmpresasWithTransferencesByLastMonths() {
        return transaccionesRepository.getEmpresasWithTransferencesByLastMonths();
    }
}
