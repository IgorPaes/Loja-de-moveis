/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.models;


public class Venda {
    
    private int idCliente, idProduto, quantidadeProduto;
    private String formaPagamento;
    private double valorTotal;
    
    public Venda() {}

    public Venda(int idCliente, int idProduto, int quantidadeProduto, String formaPagamento, double valorTotal) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
    }
    
    public Venda(int idProduto, int quantidadeProduto, double valorTotal) {
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
