package com.soft.technology.transactions_management.infrastructure.conf;

import com.soft.technology.transactions_management.application.service.DomainEmpresaService;
import com.soft.technology.transactions_management.application.service.EmpresaService;
import com.soft.technology.transactions_management.application.service.TransacionesService;
import com.soft.technology.transactions_management.domain.port.EmpresaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanEmpresaConfiguration {
    @Bean
    EmpresaService empresaBeanService(final EmpresaRepository empresaRepository, final TransacionesService transacionesService) {
        return new DomainEmpresaService(empresaRepository, transacionesService);
    }
}
