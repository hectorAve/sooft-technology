package com.soft.technology.transactions_management.domain.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionesDTO {
    @NotNull
    private Integer id;
    @NotNull
    @Positive
    private BigDecimal importe;
    @NotNull
    @Size(min = 6, max = 20, message="El cuenta debito debe tener entre 6 y 20 caracteres")
    private String cuentaDebito;
    @NotNull
    @Size(min = 6, max = 20, message="El cuenta credito debe tener entre 6 y 20 caracteres")
    private String cuentaCredito;
    @NotNull
    private Date fechaTransaccion;
    @NotNull
    @Min(1000000)
    @Max(999999999)
    private Long cuitEmpresa;
}
