package com.soft.technology.transactions_management.domain.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Min(1000000)
    @Max(999999999)
    private Long cuit;
    @NotNull
    @Size(min = 4, max = 100, message="El campo debe tener entre 4 y 100 caracteres")
    private String razonSocial;
    @NotNull
    private Date fechaAdhesion;
}