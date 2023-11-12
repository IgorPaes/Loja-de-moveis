/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Lucas Andrade
 */
public class CepService {
    
     public static EnderecoCliente consultar(String cep) {
        try {
            // URL da API que você quer acessar
            String apiUrl = "http://viacep.com.br/ws/" + cep + "/json/";

            // Criação de um objeto URL a partir da string da API
            URL url = new URL(apiUrl);

            // Abertura da conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configuração do método da requisição
            connection.setRequestMethod("GET");

            // Leitura da resposta da API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Fechamento da conexão
            connection.disconnect();

            EnderecoCliente enderecoCliente = converteEmEndereco(response.toString());

            return enderecoCliente;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ConsultaCepException(cep + "----> " + e.getMessage());
        }
    }

 private static EnderecoCliente converteEmEndereco(String response) {
    response = new String(response.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        EnderecoCliente enderecoCliente = new EnderecoCliente();
        enderecoCliente.setCep(obterValorCampo(response, "cep"));
        enderecoCliente.setLogradouro(obterValorCampo(response, "logradouro"));
        enderecoCliente.setCidade(obterValorCampo(response, "localidade"));
        enderecoCliente.setBairro(obterValorCampo(response, "bairro"));
        enderecoCliente.setComplemento(obterValorCampo(response, "complemento"));

        return enderecoCliente;
}
   private static String obterValorCampo(String json, String campo) {
    String chave = "\"" + campo + "\":";
    int indiceInicio = json.indexOf(chave) + chave.length();
    int indiceFim = json.indexOf(",", indiceInicio);

    if (indiceFim == -1) {
        indiceFim = json.indexOf("}", indiceInicio);
    }

    String valorCampo = json.substring(indiceInicio, indiceFim).replace("\"", "").trim();
    return EnderecoCliente.removerCaracteresEspeciais(valorCampo);
}
    
}
