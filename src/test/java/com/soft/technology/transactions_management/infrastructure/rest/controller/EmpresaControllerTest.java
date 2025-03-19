package com.soft.technology.transactions_management.infrastructure.rest.controller;

import com.soft.technology.transactions_management.application.service.EmpresaService;
import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmpresaControllerTest {

    private static final String PATH = "/empresas/lastmonth";

    @Mock
    private EmpresaService empresaService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUpForEachTest() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new EmpresaController(empresaService))
                .build();
    }

    @Test
    void when_service_returns_ERROR_then_internalServerError() throws Exception {
        RuntimeException re = new RuntimeException();
        doThrow(re)
                .when(empresaService)
                .getEmpresasByLastMonthsOfAdherence();

        mockMvc.perform(get(PATH))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void when_service_returns_empresas_then_success() throws Exception {
        EmpresaDTO expected = new EmpresaDTO(1234L, "SUPER", new Date());

        Iterable<EmpresaDTO> listEmpresas = Collections.singletonList(expected);

        doReturn(listEmpresas)
                .when(empresaService)
                .getEmpresasByLastMonthsOfAdherence();

        mockMvc.perform(get(PATH))
                .andExpect(status().isOk());
    }
}