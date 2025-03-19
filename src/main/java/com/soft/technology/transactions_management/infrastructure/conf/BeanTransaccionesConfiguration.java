package com.soft.technology.transactions_management.infrastructure.conf;

import com.soft.technology.transactions_management.application.service.DomainTransaccionesService;
import com.soft.technology.transactions_management.application.service.TransacionesService;
import com.soft.technology.transactions_management.domain.port.TransaccionesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTransaccionesConfiguration {
    @Bean
    TransacionesService transaccionesBeanService(final TransaccionesRepository transaccionesRepository) {
        return new DomainTransaccionesService(transaccionesRepository);
    }
}
