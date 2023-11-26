/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.models;

/**
 *
 * @author henrique.smenezes1
 */
public class Endereco {
    
    private String cep;
    private String logradouro;
    private int numero;
    private String cidade;
    private String bairro;
    private String complemento;

    public Endereco() {
    }
    
    public Endereco(String cep, String logradouro, int numero, String cidade, String bairro, String complemento){
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
    }
    
    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String removerCaracteresEspeciaisCep(){
        String texto = this.cep.replace("-", "");

        return texto;
    }
    
}
