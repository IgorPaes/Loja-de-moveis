/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import com.minhaempresa.lojademoveis.crudsenac.db.Conexao;
import com.minhaempresa.lojademoveis.crudsenac.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique.smenezes1
 */
public class ClientesDAO {
    
    public static Connection conn = null;
    
    public static boolean salvar(Cliente obj) {
    
        boolean retorno = false;
        try {
            conn = Conexao.abrirConexao();
            
            PreparedStatement comandoSQL = conn.prepareStatement("INSERT INTO clientes (NOME, CPF, TELEFONE, EMAIL, SEXO, ESTADO_CIVIL, DATA_NASCIMENTO) VALUES(?,?,?,?,?,?,?)"
                                                , PreparedStatement.RETURN_GENERATED_KEYS );
            //comandoSQL.setInt(1, obj.g);
            
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.cpfFormatada());
            comandoSQL.setString(3, obj.telefoneFormatada());
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, String.valueOf(obj.getSexo()));
            comandoSQL.setString(6, obj.getEstadoCivil());
            comandoSQL.setString(7, "2025/08/20");
            
            //Passo 4 - Executar o comando 
            comandoSQL.executeUpdate();
            
            // Obtém o ID gerado para o cliente
            int idCliente;
            try (ResultSet generatedKeys = comandoSQL.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idCliente = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o ID do cliente.");
                }
            }

            // Configura o ID do cliente no objeto
            obj.setIdCliente(idCliente);
            
            
            
            retorno = true;
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
        
        
    }
    
    
}
