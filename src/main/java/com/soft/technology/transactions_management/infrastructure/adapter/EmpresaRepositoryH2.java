package com.soft.technology.transactions_management.infrastructure.adapter;

import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import com.soft.technology.transactions_management.domain.port.EmpresaRepository;
import com.soft.technology.transactions_management.infrastructure.entity.EmpresaEntity;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;


@Repository
@Log4j
public class EmpresaRepositoryH2 implements EmpresaRepository {
    private final EmpresaCrudRepository empresaCrudRepository;

    @Autowired
    public ModelMapper modelMapper;

    public EmpresaRepositoryH2(EmpresaCrudRepository empresaCrudRepository) {
        this.empresaCrudRepository = empresaCrudRepository;
    }

    @Override
    public Iterable<EmpresaDTO> getEmpresasByLastMonthsOfAdherence() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);

        Iterable<EmpresaEntity> listEmpresas = this.empresaCrudRepository.findByFechaAdhesionAfter(cal.getTime());;
        return StreamSupport.stream(listEmpresas.spliterator(), false)
                .map(empresa ->
                        modelMapper.map(empresa, EmpresaDTO.class))
                .toList();
    }

    @Override
    public Iterable<EmpresaDTO> findByCuitContaining(List<Long> cuitEmpresas) {
        Iterable<EmpresaEntity> listEmpresas = empresaCrudRepository.findByCuitContaining(cuitEmpresas);

        return StreamSupport.stream(listEmpresas.spliterator(), false)
                .map(empresa ->
                        modelMapper.map(empresa, EmpresaDTO.class))
                .toList();
    }

    @Override
    public EmpresaDTO addEmpresa(EmpresaDTO empresaDTO) {
        EmpresaEntity empresa = modelMapper.map(empresaDTO, EmpresaEntity.class);

        return modelMapper.map(empresaCrudRepository.save(empresa), EmpresaDTO.class);
    }
}
