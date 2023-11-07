/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minhaempresa.lojademoveis.crudsenac.dao;

import com.minhaempresa.lojademoveis.crudsenac.models.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            
            PreparedStatement comandoSQL = conn.prepareStatement("INSERT INTO...");
            //comandoSQL.setInt(1, obj.g);
            
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
