package com.oficinatech.oficinatech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "materiais")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double quantidade;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false)
    private Double quantidadeMinima;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getQuantidade() { return quantidade; }
    public void setQuantidade(Double quantidade) { this.quantidade = quantidade; }

    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }

    public Double getQuantidadeMinima() { return quantidadeMinima; }
    public void setQuantidadeMinima(Double quantidadeMinima) { this.quantidadeMinima = quantidadeMinima; }
}