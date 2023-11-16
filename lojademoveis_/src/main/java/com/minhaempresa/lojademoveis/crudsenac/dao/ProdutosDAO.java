/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import com.minhaempresa.lojademoveis.crudsenac.db.Conexao;
import com.minhaempresa.lojademoveis.crudsenac.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Andrade
 */
public class ProdutosDAO {
  
    public static Connection conn = null;
    
    public static Produto salvar(Produto produtos) throws ClassNotFoundException, SQLException{
        
        boolean retorno = false;
       
        try {
        conn = Conexao.abrirConexao();
        
        PreparedStatement comandoSQL = conn.prepareStatement("INSERT INTO produtos (NOME, MARCA, PRECO, CATEGORIA, QUANTIDADE, DESCRICAO_PRODUTO) VALUES(?,?,?,?,?,?)",
                     PreparedStatement.RETURN_GENERATED_KEYS);
        
        comandoSQL.setString(1, produtos.getNome());
        comandoSQL.setString(2, produtos.getMarca());
        comandoSQL.setDouble(3, produtos.getPreco());
        comandoSQL.setString(4, produtos.getCategoria());
        comandoSQL.setInt(5, produtos.getQuantidade());
        comandoSQL.setString(6, produtos.getDescProduto());
        
         comandoSQL.executeUpdate();
        
          // Obtém o ID gerado para o cliente
            int CodProduto;
            try (ResultSet generatedKeys = comandoSQL.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    CodProduto = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o ID do cliente.");
                }
            }
            // Configura o ID do cliente no objeto
            produtos.setCodProduto(CodProduto);

            return produtos;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public static ArrayList<Produto> listar() throws ClassNotFoundException, SQLException {
        ArrayList<Produto> lista = new ArrayList<>();
         conn = null;
         PreparedStatement comandoSQL = null;
         ResultSet rs = null;
         
         conn = Conexao.abrirConexao();
         
         comandoSQL = conn.prepareStatement(" SELECT * FROM produtos",
                     PreparedStatement.RETURN_GENERATED_KEYS);
         
         rs = comandoSQL.executeQuery();
        try{ 
         
         if (rs != null) {

                while (rs.next()) {
                    int id = rs.getInt("CODIGO_PRODUTO");
                    String nome = rs.getString("NOME");
                    String marca = rs.getString("MARCA");
                    double preco = rs.getDouble("PRECO");
                    String categoria = rs.getString("CATEGORIA");
                    int quantidade = rs.getInt("Quantidade");
                    String descProduto = rs.getString("DESCRICAO_PRODUTO");

                    Produto produtos = new Produto(id, nome, marca, preco, categoria, quantidade, descProduto);

                    lista.add(produtos);

                }

            }
        }
             catch (Exception e) {
            System.out.println("erro para listar -> " + e.getMessage());
            lista = null;
        } finally {

            if (conn != null) {
               Conexao.fecharConexao();
            }

        }

        return lista;
    }
    
    public static boolean alterarProduto(int codProduto, Produto produto) throws ClassNotFoundException, SQLException{
         conn = null;
        PreparedStatement comandoSQL = null;
        boolean retorno = false;

        conn = Conexao.abrirConexao();

        try {
            comandoSQL = conn.prepareStatement(
                    "UPDATE produtos SET NOME = ?, MARCA = ?, PRECO = ?, CATEGORIA = ?, QUANTIDADE = ?, DESCRICAO_PRODUTO = ? WHERE CODIGO_PRODUTO = ? ");

            comandoSQL.setString(1, produto.getNome());
            comandoSQL.setString(2, produto.getMarca());
            comandoSQL.setDouble(3, produto.getPreco());
            comandoSQL.setString(4, produto.getCategoria());
            comandoSQL.setInt(5, produto.getQuantidade());
            comandoSQL.setString(6, produto.getDescProduto());
            comandoSQL.setInt(7, codProduto);

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }
        }catch (SQLException e) {
            System.out.println("Erro para alterar registro -> " + e.getMessage());
            return false;
        }
        return retorno;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
