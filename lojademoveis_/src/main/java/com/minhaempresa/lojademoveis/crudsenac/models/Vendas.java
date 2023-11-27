/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.models;

public class Vendas {
    
    private Integer codProdutoFK, quantidade;
    private String nomeProduto, nomeCliente, enderecoCliente, cpfCliente, categoria, data;
    private Double desconto, descontoTotal, TotalPagar;
    private Float valorUnit;

    public Vendas() {}

    public Vendas(Double TotalPagar, String nomeCliente, String data) {
      
        this.TotalPagar = TotalPagar;
        this.nomeCliente = nomeCliente;
        this.data = data;
    }

    public Vendas(String nomeProduto, Integer quantidade) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        
    }

    public Vendas(Integer codProdutoFK, Integer quantidade, String nomeProduto, String nomeCliente, String enderecoCliente, String cpfCliente, String categoria, Float valorUnit, Double desconto, Double descontoTotal, Double TotalPagar) {
        this.codProdutoFK = codProdutoFK;
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.cpfCliente = cpfCliente;
        this.categoria = categoria;
        this.valorUnit = valorUnit;
        this.desconto = desconto;
        this.descontoTotal = descontoTotal;
        this.TotalPagar = TotalPagar;
    }

    public Integer getCodProdutoFK() {
        return codProdutoFK;
    }

    public void setCodProdutoFK(Integer codProdutoFK) {
        this.codProdutoFK = codProdutoFK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public Float getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Float valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getDescontoTotal() {
        return descontoTotal;
    }

    public void setDescontoTotal(Double descontoTotal) {
        this.descontoTotal = descontoTotal;
    }

    public Double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(Double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
