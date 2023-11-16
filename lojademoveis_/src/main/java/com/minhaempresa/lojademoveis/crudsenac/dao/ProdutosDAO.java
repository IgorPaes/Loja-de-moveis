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
    
    public static boolean salvar(Produto produtos) throws ClassNotFoundException, SQLException{
        
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
        
        retorno = true;
    }
       catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
