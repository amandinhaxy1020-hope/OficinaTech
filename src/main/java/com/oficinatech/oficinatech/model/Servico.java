package com.oficinatech.oficinatech.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private String descricao;

    private LocalDate dataEntrada;
    private LocalDate previsaoEntrega;

    @Column(nullable = false)
    private String status = "Recebido";

    @Column(nullable = false, unique = true)
    private String codigoAcompanhamento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public LocalDate getPrevisaoEntrega() { return previsaoEntrega; }
    public void setPrevisaoEntrega(LocalDate previsaoEntrega) { this.previsaoEntrega = previsaoEntrega; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCodigoAcompanhamento() { return codigoAcompanhamento; }
    public void setCodigoAcompanhamento(String codigoAcompanhamento) { this.codigoAcompanhamento = codigoAcompanhamento; }
}