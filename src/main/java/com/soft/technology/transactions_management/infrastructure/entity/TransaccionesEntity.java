package com.soft.technology.transactions_management.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="TRANSACCIONES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull(message = "El importe de la transacción es requerido")
    @Positive(message = "El importe de la transacción no debe ser un número negativo o cero")
    @Column(name = "IMPORTE")
    private BigDecimal importe;

    @NotNull(message = "La cuenta debito es requerida")
    @Column(name = "CUENTA_DEBITO")
    private String cuentaDebito;

    @NotNull(message = "La cuenta credito es requerida")
    @Column(name = "CUENTA_CREDITO")
    private String cuentaCredito;

    @NotNull(message = "La fecha de la transacción es requerida")
    @Column(name = "FECHA_TRANSACCION")
    private Date fechaTransaccion;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUIT_EMPRESA", referencedColumnName = "CUIT")
    private EmpresaEntity empresaEntity;
}
