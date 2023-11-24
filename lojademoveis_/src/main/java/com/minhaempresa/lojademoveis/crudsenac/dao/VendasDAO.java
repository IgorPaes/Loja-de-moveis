/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import com.minhaempresa.lojademoveis.crudsenac.db.Conexao;
import com.minhaempresa.lojademoveis.crudsenac.models.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendasDAO {
   
    public static Vendas buscarProdutoPorId(int codProduto) throws SQLException, ClassNotFoundException {
        Vendas produto = null;

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement modeloSQL = conn.prepareStatement("SELECT NOME, PRECO FROM produtos WHERE CODIGO_PRODUTO = ?")) {

            modeloSQL.setInt(1, codProduto);

            try (ResultSet rs = modeloSQL.executeQuery()) {
                if (rs.next()) {
                    produto = new Vendas();
                    produto.setNomeProduto(rs.getString("NOME"));
                    produto.setValorUnit(rs.getDouble("PRECO"));
                }
            }
        }

        return produto;
    }
    
    public static Vendas buscarClientePorCep(String cpfCliente) throws ClassNotFoundException, SQLException{
        Vendas cliente = null;
        
        try (Connection conn = Conexao.abrirConexao();
                
        PreparedStatement modeloSQL = conn.prepareStatement("select cl.NOME, end.logradouro from clientes cl\n" +
            "inner join endereco end on cl.ID_CLIENTE = end.id_clientes\n" +
            "where cl.CPF = ?")) 
        {
            modeloSQL.setString(1, cpfCliente);
            
            try (ResultSet rs = modeloSQL.executeQuery()) {
                if (rs.next()) {
                    cliente = new Vendas();
                    cliente.setNomeCliente(rs.getString("NOME"));
                    cliente.setEnderecoCliente(rs.getString("logradouro"));
                    
                }    
            }
        }
        return cliente;
    }
    
    public static Vendas mostraTabelaVendas(int id) throws ClassNotFoundException, SQLException{
        Vendas iVendas = new Vendas();
        
        try(Connection conn = Conexao.abrirConexao();
          
        PreparedStatement modeloSQL = conn.prepareStatement("select codigo_produto,nome,categoria,preco from produtos where codigo_produto = ?")) {
           
            modeloSQL.setInt(1, id);

            try(ResultSet resultSet = modeloSQL.executeQuery()) {
  
                if(resultSet.next()) {
                    iVendas.setCodProdutoFK(resultSet.getInt("codigo_produto"));
                    iVendas.setNomeProduto(resultSet.getString("nome"));  
                    iVendas.setCategoria(resultSet.getString("categoria"));
                    iVendas.setValorUnit(resultSet.getDouble("preco"));
                }

            }
            
        }
                
        return iVendas;
    }

}