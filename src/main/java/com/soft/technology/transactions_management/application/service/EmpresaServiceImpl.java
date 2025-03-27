package com.soft.technology.transactions_management.application.service;

import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import com.soft.technology.transactions_management.domain.port.EmpresaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final TransaccionesService transaccionesService;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, TransaccionesService transaccionesService) {
        this.empresaRepository = empresaRepository;
        this.transaccionesService = transaccionesService;
    }

    @Override
    public Iterable<EmpresaDTO> getEmpresasByLastMonthsOfAdherence(Pageable pageable) {
        return this.empresaRepository.getEmpresasByLastMonthsOfAdherence(pageable);
    }

    @Override
    public Iterable<EmpresaDTO> getEmpresasWithTransferencesByLastMonths(Pageable pageable) {
        List<Long> cuitEmpresas = transaccionesService.getEmpresasWithTransferencesByLastMonths();
        return this.empresaRepository.findByCuitContaining(cuitEmpresas, pageable);
    }

    @Override
    public EmpresaDTO addEmpresa(EmpresaDTO empresaDTO) {
        Boolean existCuit = this.empresaRepository.findByCuit(empresaDTO.getCuit());

        if (existCuit) {
            return empresaDTO;
        }

        return this.empresaRepository.addEmpresa(empresaDTO);
    }
}
