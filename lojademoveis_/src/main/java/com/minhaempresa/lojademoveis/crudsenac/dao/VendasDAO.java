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
import java.sql.Statement;

public class VendasDAO {
   
    public static Vendas buscarProdutoPorId(int codProduto) throws SQLException, ClassNotFoundException {
        Vendas produto = null;

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement modeloSQL = conn.prepareStatement("SELECT nome, preco FROM produtos WHERE id_produto = ?")) {

            modeloSQL.setInt(1, codProduto);

            try (ResultSet rs = modeloSQL.executeQuery()) {
                if (rs.next()) {
                    produto = new Vendas();
                    produto.setNomeProduto(rs.getString("nome"));
                    produto.setValorUnit(rs.getFloat("preco"));
                }
            }
        }

        return produto;
    }
    
    public static Vendas buscarClientePorCpf(String cpfCliente) throws ClassNotFoundException, SQLException{
        Vendas cliente = null;
        
        try (Connection conn = Conexao.abrirConexao();
                
        PreparedStatement modeloSQL = conn.prepareStatement("SELECT cl.nome, end.logradouro " +
        "FROM clientes cl " +
        "INNER JOIN enderecos end ON cl.id_endereco = end.id_endereco " +
        "WHERE cl.cpf = ?")) 
        {
            modeloSQL.setString(1, cpfCliente);
            
            try (ResultSet rs = modeloSQL.executeQuery()) {
                if (rs.next()) {
                    cliente = new Vendas();
                    cliente.setNomeCliente(rs.getString("nome"));
                    cliente.setEnderecoCliente(rs.getString("logradouro")); 
                }    
            }
        }
        
        return cliente;
    }
    
    public static Vendas mostraTabelaVendas(int id) throws ClassNotFoundException, SQLException {
        Vendas iVendas = new Vendas();
        
        try(Connection conn = Conexao.abrirConexao();
          
        PreparedStatement modeloSQL = conn.prepareStatement("select id_produto,nome,categoria,preco from produtos where id_produto = ?")) {
           
            modeloSQL.setInt(1, id);

            try(ResultSet resultSet = modeloSQL.executeQuery()) {
  
                if(resultSet.next()) {
                    iVendas.setCodProdutoFK(resultSet.getInt("id_produto"));
                    iVendas.setNomeProduto(resultSet.getString("nome"));  
                    iVendas.setCategoria(resultSet.getString("categoria"));
                    iVendas.setValorUnit(resultSet.getFloat("preco"));
                }

            }
            
        }
                
        return iVendas;
    }

    public static int adicionaVenda(int idCliente, float total) throws ClassNotFoundException, SQLException {
        
        int idVenda = 0;
        
            try (Connection conn = Conexao.abrirConexao();
                PreparedStatement query = conn.prepareStatement("INSERT INTO vendas (id_cliente, preco_total, data) VALUES (?, ?, NOW())", 
  Statement.RETURN_GENERATED_KEYS);
            ) {
            
            query.setInt(1, idCliente);
            query.setDouble(2, total);
            
            int linhasAfetada = query.executeUpdate();
            
            if(linhasAfetada > 0) {
                
                ResultSet generatedKeys = query.getGeneratedKeys();

                if(generatedKeys.next()) {
                    idVenda = generatedKeys.getInt(1);
                }
                
            }else {
                System.out.println("Falhou!");
            }

        }

        return idVenda;
    }
    
    public static boolean adicionaItemVenda(int idVenda, int idProduto, int quantidade, float precoUnidade) throws ClassNotFoundException, SQLException {
        
        boolean retorno = false;
        
        try (Connection conn = Conexao.abrirConexao();
            PreparedStatement query = conn.prepareStatement("INSERT INTO itens_venda (id_venda, id_produto, quantidade, preco_unidade) VALUES (?, ?, ?, ?)");
        ) {
            query.setInt(1, idVenda);
            query.setInt(2, idProduto);
            query.setInt(3, quantidade);
            query.setFloat(4, precoUnidade);
            
            query.executeUpdate();
            retorno = true;
        }
        
        return retorno;
    }

    public void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}