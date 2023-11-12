/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.service;

/**
 *
 * @author Lucas Andrade
 */
public class ConsultaCepException extends RuntimeException {
    
    private static final String MESSAGE = "Erro para consulta o CEP: %s";

    public ConsultaCepException(String cep) {
        super(String.format(MESSAGE, cep));
    }
    
}
