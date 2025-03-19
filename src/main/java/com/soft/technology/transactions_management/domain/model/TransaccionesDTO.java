package com.soft.technology.transactions_management.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionesDTO {
    private Integer id;
    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private Date fechaTransaccion;
    private Long cuitEmpresa;
}
