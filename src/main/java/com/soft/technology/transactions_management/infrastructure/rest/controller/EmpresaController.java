package com.soft.technology.transactions_management.infrastructure.rest.controller;

import com.soft.technology.transactions_management.application.service.EmpresaService;
import com.soft.technology.transactions_management.domain.model.EmpresaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
@Slf4j
@Tag(name = "Empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @Operation(summary = "Busca las empresas que tuvieron una adhesión en el último mes.")
    @GetMapping(path = "/lastmonth")
    public ResponseEntity<Iterable<EmpresaDTO>> getEmpresasByLastMonthsOfAdherence() {
        try {
            Iterable<EmpresaDTO> response = this.empresaService.getEmpresasByLastMonthsOfAdherence();
            if (response == null || !response.iterator().hasNext()) {
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Busca las empresas que tuvieron alguna transferencia en el último mes.")
    @GetMapping(path = "/transference/lastmonth")
    public ResponseEntity<Iterable<EmpresaDTO>> getEmpresasWithTransferencesByLastMonths() {
        try {
            Iterable<EmpresaDTO> response = this.empresaService.getEmpresasWithTransferencesByLastMonths();
            if (response == null || !response.iterator().hasNext()) {
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Agrega una empresa.")
    @PostMapping()
    public ResponseEntity<EmpresaDTO> addEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        try {
            return new ResponseEntity<>(this.empresaService.addEmpresa(empresaDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
