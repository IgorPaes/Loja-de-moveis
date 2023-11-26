/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.models;

/**
 *
 * @author Lucas Andrade
 */
public class Produto {
    
    private Integer codProduto;
    private String nome, marca, categoria, descProduto;
    private Double preco;
    private Integer quantidade;
    
    public Produto() {}

    public Produto(Integer codProduto, String nome, String marca, Double preco, String categoria, Integer quantidade, String descProduto) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.descProduto = descProduto;
        
    }

     public Produto(Integer codProduto, String nome, String marca, Double preco, String categoria, Integer quantidade) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
        
    }
     
    public Produto(String nome, String marca, Double preco, String categoria, Integer quantidade, String descProduto) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.descProduto = descProduto;
        
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

   
   
}
