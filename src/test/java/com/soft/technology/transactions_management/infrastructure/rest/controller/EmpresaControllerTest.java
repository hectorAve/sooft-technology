package com.soft.technology.transactions_management.infrastructure.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft.technology.transactions_management.application.service.EmpresaService;
import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmpresaControllerTest {

    private static final String PATH = "/empresas";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mock
    private EmpresaService empresaService;

    private MockMvc mockMvc;

    final static Pageable pageable = PageRequest.of(0, 10);

    @BeforeEach
    void setUpForEachTest() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new EmpresaController(empresaService))
                .build();
    }

    @Test
    void when_service_lastmonth_returns_ERROR_then_internalServerError() throws Exception {
        RuntimeException re = new RuntimeException();
        doThrow(re)
                .when(empresaService)
                .getEmpresasByLastMonthsOfAdherence(any());

        mockMvc.perform(get(PATH+"/lastmonth"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void when_service_lastmonth_returns_empty_then_statusNotContent() throws Exception {
        Iterable<EmpresaDTO> listEmpty = Collections.emptyList();

        doReturn(listEmpty)
                .when(empresaService)
                .getEmpresasByLastMonthsOfAdherence(pageable);

        mockMvc.perform(get(PATH+"/lastmonth"))
                .andExpect(status().isNoContent());
    }

    @Test
    void when_service_lastmonth_returns_empresas_then_success() throws Exception {
        EmpresaDTO expected = new EmpresaDTO(1234L, "SUPER", new Date());

        Iterable<EmpresaDTO> listEmpresas = Collections.singletonList(expected);

        doReturn(listEmpresas)
                .when(empresaService)
                .getEmpresasByLastMonthsOfAdherence(pageable);

        mockMvc.perform(get(PATH+"/lastmonth"))
                .andExpect(status().isOk());
    }

    @Test
    void when_service_transference_lastmonth_returns_ERROR_then_internalServerError() throws Exception {
        RuntimeException re = new RuntimeException();
        doThrow(re)
                .when(empresaService)
                .getEmpresasWithTransferencesByLastMonths(any());

        mockMvc.perform(get(PATH+"/transference/lastmonth"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void when_service_transference_lastmonth_returns_empty_then_statusNotContent() throws Exception {
        Iterable<EmpresaDTO> listEmpty = Collections.emptyList();

        doReturn(listEmpty)
                .when(empresaService)
                .getEmpresasWithTransferencesByLastMonths(any());

        mockMvc.perform(get(PATH+"/transference/lastmonth"))
                .andExpect(status().isNoContent());
    }

    @Test
    void when_service_transference_lastmonth_returns_empresas_then_success() throws Exception {
        EmpresaDTO expected = new EmpresaDTO(1234L, "SUPER", new Date());

        Iterable<EmpresaDTO> listEmpresas = Collections.singletonList(expected);

        doReturn(listEmpresas)
                .when(empresaService)
                .getEmpresasWithTransferencesByLastMonths(pageable);

        mockMvc.perform(get(PATH+"/transference/lastmonth"))
                .andExpect(status().isOk());
    }

    @Test
    void when_service_create_empresa_returns_ERROR_then_internalServerError() throws Exception {
        EmpresaDTO empresa = new EmpresaDTO(1000001L, "SUPER", new Date());

        RuntimeException re = new RuntimeException();
        doThrow(re)
                .when(empresaService)
                .addEmpresa(empresa);

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(empresa)))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void when_service_create_empresa_with_not_contains_cuit_then_badRequest() throws Exception {
        EmpresaDTO empresa = new EmpresaDTO(null, "SUPER", new Date());

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(empresa)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void when_service_create_empresa_with_not_contains_razonSocial_then_badRequest() throws Exception {
        EmpresaDTO empresa = new EmpresaDTO(1000001L, "", new Date());

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(empresa)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void when_service_create_empresa_with_not_contains_fechaAdhesion_then_badRequest() throws Exception {
        EmpresaDTO empresa = new EmpresaDTO(1000001L, "SUPER", null);

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(empresa)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void when_service_create_empresa_returns_success_statusCreated() throws Exception {
        EmpresaDTO empresa = new EmpresaDTO(1000001L, "SUPER", new Date());

        doReturn(empresa)
                .when(empresaService)
                .addEmpresa(empresa);

        mockMvc.perform(post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(empresa)))
                .andExpect(status().isCreated());
    }

    private static String asJsonString(Object request) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(request);
    }
}