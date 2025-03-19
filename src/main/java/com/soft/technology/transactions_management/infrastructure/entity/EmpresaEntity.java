package com.soft.technology.transactions_management.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="EMPRESA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaEntity {
    @Id
    @Column(name = "CUIT")
    private Long cuit;

    @NotBlank(message = "Razón Social no debe estar vacío")
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    @Column(name = "FECHA_ADHESION")
    @NotNull
    private Date fechaAdhesion;
}
