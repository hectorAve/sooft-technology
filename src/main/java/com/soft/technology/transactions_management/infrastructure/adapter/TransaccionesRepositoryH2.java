package com.soft.technology.transactions_management.infrastructure.adapter;

import com.soft.technology.transactions_management.domain.port.TransaccionesRepository;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Log4j
public class TransaccionesRepositoryH2 implements TransaccionesRepository {
    private final TransaccionesCrudRepository transaccionesCrudRepository;

    @Autowired
    public ModelMapper modelMapper;

    public TransaccionesRepositoryH2(TransaccionesCrudRepository transaccionesCrudRepository) {
        this.transaccionesCrudRepository = transaccionesCrudRepository;
    }


    @Override
    public List<Long> getEmpresasWithTransferencesByLastMonths() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);

        return this.transaccionesCrudRepository.findByFechaTransaccionAfter(cal.getTime());
    }
}
