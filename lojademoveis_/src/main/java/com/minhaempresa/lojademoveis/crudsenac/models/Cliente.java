/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente {
    
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private char sexo;
    private String estadoCivil;
    private String data;
    private Endereco endereco;
    
    public Cliente(int idCliente){
        this.idCliente = idCliente;
    }

    public Cliente(String nome, String cpf, String telefone, String email, char sexo, String estadoCivil, String data) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.data = data;
    }
    
    public Cliente(String nome, String cpf, String telefone, String email, char sexo, String estadoCivil, String data, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.data = data;
        this.endereco = endereco;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
      public String cpfFormatada(){
        this.cpf = this.cpf;
        
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
      
        return cpfLimpo;
    }
    
    public String telefoneFormatada(){
        this.telefone = this.telefone;
        
        String telefoneLimpo = telefone.replaceAll("[^0-9]", "");
      
        return telefoneLimpo;
    }
    
      public String dataFormatada() throws ParseException{
          this.data = this.data;
          
             SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");
              Date data = sdfEntrada.parse(this.data);
            
              SimpleDateFormat sdfSaida = new SimpleDateFormat("MM/dd/yyyy");
            String dataAnericana = sdfSaida.format(data);
        return dataAnericana;
    }
    
}
