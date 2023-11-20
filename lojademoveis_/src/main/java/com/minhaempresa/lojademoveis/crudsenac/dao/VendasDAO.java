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

/**
 *
 * @author Lucas Andrade
 */
public class VendasDAO {
   
    public static Vendas buscarProdutoPorId(int codProduto) throws SQLException, ClassNotFoundException {
    Vendas produto = null;

    try (Connection conn = Conexao.abrirConexao();
         PreparedStatement stmt = conn.prepareStatement("SELECT NOME, PRECO FROM produtos WHERE CODIGO_PRODUTO = ?")) {

        stmt.setInt(1, codProduto);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                produto = new Vendas();
                produto.setNomeProduto(rs.getString("NOME"));
                produto.setValorUnit(rs.getDouble("PRECO"));
                
            }
        }
    }

    return produto;
}
}
    
