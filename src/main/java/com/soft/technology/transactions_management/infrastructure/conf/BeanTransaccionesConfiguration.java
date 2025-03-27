package com.soft.technology.transactions_management.infrastructure.conf;

import com.soft.technology.transactions_management.application.service.TransaccionesServiceImpl;
import com.soft.technology.transactions_management.application.service.TransaccionesService;
import com.soft.technology.transactions_management.domain.port.TransaccionesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTransaccionesConfiguration {
    @Bean
    TransaccionesService transaccionesBeanService(final TransaccionesRepository transaccionesRepository) {
        return new TransaccionesServiceImpl(transaccionesRepository);
    }
}
