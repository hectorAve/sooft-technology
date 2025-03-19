package com.soft.technology.transactions_management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmpresaDTO {
    private Long cuit;
    private String razonSocial;
    private Date fechaAdhesion;
}