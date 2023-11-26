/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gotib
 */
public class Cliente {
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private char sexo;
    private char estadoCivil;
    private String data;
    private int idEndereco;
    
    public Cliente() {}
    
    public Cliente(int idCliente){
        this.idCliente = idCliente;
    }
    
    public Cliente(Integer idCliente, String nome, String cpf, String telefone, String email, char sexo, char estadoCivil, String data) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.data = data;
    }
    
    public Cliente(String nome, String cpf, String telefone, String email, char sexo, char estadoCivil, String data) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.data = data;
    }
    
    public Cliente(String nome, String cpf, String telefone, String email, char sexo, char estadoCivil, String data, int endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.data = data;
        this.idEndereco = endereco;
    }
    
    public int getIdEndereco() {
        return idEndereco;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
         // SimpleDateFormat converte = new SimpleDateFormat("yyyy/MM/dd");
          //this.data = converte.format(this.data);
        this.data = data;
    }

    public String cpfFormatada(){
        String cpfLimpo = this.cpf.replaceAll("[^0-9]", "");
        return cpfLimpo;
    }
    
    public String telefoneFormatada(){
    
        String telefoneLimpo = this.telefone.replaceAll("[^0-9]", "");

        return telefoneLimpo;
    }
    
      public String dataFormatada() throws ParseException{

        SimpleDateFormat sdfAtual = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAtual = sdfAtual.parse(this.data);

        SimpleDateFormat sdfSaida = new SimpleDateFormat("yyyy-MM-dd");
        String dataAmericana = sdfSaida.format(dataAtual);
        return dataAmericana;
    }
  
}
