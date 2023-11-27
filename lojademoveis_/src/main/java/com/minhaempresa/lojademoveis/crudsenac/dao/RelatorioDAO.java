/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import static com.minhaempresa.lojademoveis.crudsenac.dao.ProdutosDAO.conn;
import com.minhaempresa.lojademoveis.crudsenac.db.Conexao;
import com.minhaempresa.lojademoveis.crudsenac.models.Produto;
import com.minhaempresa.lojademoveis.crudsenac.models.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas Andrade
 */
public class RelatorioDAO {
    
    public static ArrayList<Vendas> relatorioSintetico() throws ClassNotFoundException, SQLException{
         ArrayList<Vendas> lista = new ArrayList<>();
         conn = null;
         PreparedStatement comandoSQL = null;
         ResultSet rs = null;
        
         
         conn = Conexao.abrirConexao();
         
          comandoSQL = conn.prepareStatement("SELECT v.preco_total, c.nome, v.data\n" +
"FROM vendas v\n" +
"JOIN clientes c ON v.id_cliente = c.id_cliente",
                     PreparedStatement.RETURN_GENERATED_KEYS);
        
          rs = comandoSQL.executeQuery();
          
          try{ 
         
         if (rs != null) {

                while (rs.next()) {
                    Double precoTotal = rs.getDouble("preco_total");
                    String nome = rs.getString("nome");
                    String data = rs.getString("data");
                   

                    Vendas venda = new Vendas(precoTotal, nome, data);

                    lista.add(venda);

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
    
    public static ArrayList<Vendas> relatorioAnalitico() throws ClassNotFoundException, SQLException{
         ArrayList<Vendas> lista = new ArrayList<>();
         conn = null;
         PreparedStatement comandoSQL = null;
         ResultSet rs = null;
        
         
         conn = Conexao.abrirConexao();
         
          comandoSQL = conn.prepareStatement("SELECT p.nome AS nome_produto, iv.quantidade\n" +
"                FROM vendas v \n" +
"                JOIN itens_venda iv ON v.id_venda = iv.id_venda \n" +
"                JOIN produtos p ON iv.id_produto = p.id_produto",
                     PreparedStatement.RETURN_GENERATED_KEYS);
        
          rs = comandoSQL.executeQuery();
          
          try{ 
         
         if (rs != null) {

                while (rs.next()) {
                    String nome = rs.getString("nome_produto");
                    int quantidade = rs.getInt("quantidade");
                    
                   

                    Vendas venda = new Vendas(nome, quantidade);

                    lista.add(venda);

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
