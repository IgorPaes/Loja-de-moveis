/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import com.minhaempresa.lojademoveis.crudsenac.db.Conexao;
import com.minhaempresa.lojademoveis.crudsenac.models.Cliente;
import com.minhaempresa.lojademoveis.crudsenac.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Andrade
 */
public class EnderecoDAO {
    
      public static Connection conn = null;
    
    public static boolean salvar(Endereco obj, Integer idCliente) {
    
        boolean retorno = false;
        try {
            conn = Conexao.abrirConexao();
            
            PreparedStatement comandoSQL = conn.prepareStatement("INSERT INTO endereco (logradouro, numero, cidade, bairro, complemento, id_clientes) VALUES(?,?,?,?,?,?)"
                                                , PreparedStatement.RETURN_GENERATED_KEYS );
            //comandoSQL.setInt(1, obj.g);
            
            comandoSQL.setString(1, obj.getLogradouro());
            comandoSQL.setInt(2, obj.getNumero());
            comandoSQL.setString(3, obj.getCidade());
            comandoSQL.setString(4, obj.getBairro());
            comandoSQL.setString(5, obj.getComplemento());
            comandoSQL.setInt(6, idCliente);
            
       
            
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
    
}
