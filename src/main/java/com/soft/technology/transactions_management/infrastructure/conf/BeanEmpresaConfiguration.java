package com.soft.technology.transactions_management.infrastructure.conf;

import com.soft.technology.transactions_management.application.service.EmpresaServiceImpl;
import com.soft.technology.transactions_management.application.service.EmpresaService;
import com.soft.technology.transactions_management.application.service.TransaccionesService;
import com.soft.technology.transactions_management.domain.port.EmpresaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanEmpresaConfiguration {
    @Bean
    EmpresaService empresaBeanService(final EmpresaRepository empresaRepository, final TransaccionesService transaccionesService) {
        return new EmpresaServiceImpl(empresaRepository, transaccionesService);
    }
}
