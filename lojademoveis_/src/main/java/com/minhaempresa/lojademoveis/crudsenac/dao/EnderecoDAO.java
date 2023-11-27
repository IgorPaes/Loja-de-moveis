/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import com.minhaempresa.lojademoveis.crudsenac.db.Conexao;
import com.minhaempresa.lojademoveis.crudsenac.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO {
    
    public static Connection conn = null;
    
    public static boolean salvar(Endereco obj) {
    
        boolean retorno = false;
        try {
            conn = Conexao.abrirConexao();
            
            PreparedStatement comandoSQL = conn.prepareStatement("INSERT INTO enderecos (cep, logradouro, numero, cidade, bairro, complemento) VALUES(?,?,?,?,?,?)", 
            PreparedStatement.RETURN_GENERATED_KEYS);
            //comandoSQL.setInt(1, obj.g);
            
            comandoSQL.setString(1, obj.removerCaracteresEspeciaisCep());
            comandoSQL.setString(2, obj.getLogradouro());
            comandoSQL.setInt(3, obj.getNumero());
            comandoSQL.setString(4, obj.getCidade());
            comandoSQL.setString(5, obj.getBairro());
            comandoSQL.setString(6, obj.getComplemento());
            
            //Passo 4 - Executar o comando 
            comandoSQL.executeUpdate();
            
            retorno = true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
    public static int pegarId() {
    
        ResultSet rs = null;
        int idEndereco = 0;

        try {
            conn = Conexao.abrirConexao();

            PreparedStatement comandoSQL = conn.prepareStatement("SELECT id_endereco FROM enderecos ORDER BY id_endereco DESC LIMIT 1");

            // Executar o comando
            rs = comandoSQL.executeQuery();

            // Verificar se há algum resultado no ResultSet
            if(rs.next()) {
                // Acessar o valor da coluna "id_endereco" do resultado
                idEndereco = rs.getInt("id_endereco");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fechar recursos no bloco finally para garantir que sejam fechados, mesmo em caso de exceção
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return idEndereco;
        
    }
    
}
