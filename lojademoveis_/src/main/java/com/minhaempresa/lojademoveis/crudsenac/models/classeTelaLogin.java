
package com.minhaempresa.lojademoveis.crudsenac.models;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author henrique.smenezes1
 */
public class classeTelaLogin {
//;
    private String usuarioPadrao = "Admin";
    private String senhaPadrao = "123";
//
//    public TelaLogin(String User, String Senha) {
//        this.user = User;
//        this.senha = Senha;
//    }

    public boolean[] validarUsuario(String login, String pin) {

        boolean verificaLogin = login.equalsIgnoreCase(usuarioPadrao);
        boolean verificaPIN = pin.equalsIgnoreCase(senhaPadrao);

        boolean vecValidados[] = {verificaLogin, verificaPIN};
        
        return vecValidados;
    }
    
}
