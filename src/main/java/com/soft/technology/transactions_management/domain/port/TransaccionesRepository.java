package com.soft.technology.transactions_management.domain.port;

import java.util.List;

public interface TransaccionesRepository {
    List<Long> getEmpresasWithTransferencesByLastMonths();
}
