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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientesDAO {

    public static Connection conn = null;

    public static Cliente salvar(Cliente obj) throws ParseException {

        try {
            conn = Conexao.abrirConexao();

            PreparedStatement comandoSQL = conn.prepareStatement("INSERT INTO clientes (NOME, CPF, TELEFONE, EMAIL, SEXO, ESTADO_CIVIL, DATA_NASCIMENTO) VALUES(?,?,?,?,?,?,?)",
                     PreparedStatement.RETURN_GENERATED_KEYS);
            //comandoSQL.setInt(1, obj.g);

            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getCpf());
            comandoSQL.setString(3, obj.telefoneFormatada());
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, String.valueOf(obj.getSexo()));
            comandoSQL.setString(6, obj.getEstadoCivil());
            comandoSQL.setString(7, obj.dataFormatada());

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

            return obj;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static ArrayList<Cliente> listar() throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {

            //busca a tabela no banco
            conexao = Conexao.abrirConexao();
            comandoSQL = conexao.prepareStatement("SELECT * FROM clientes");

            //Executar a CONSULTA
            rs = comandoSQL.executeQuery();

            if (rs != null) {

                //Pega as informaçoes da tabela;      
                while (rs.next()) {

                    String id = rs.getString("ID_CLIENTE");
                    String nome = rs.getString("NOME");
                    String cpf = rs.getString("CPF");
                    String telefone = rs.getString("TELEFONE");
                    String email = rs.getString("EMAIL");
                    String sexo = rs.getString("SEXO");
                    String estadoCivil = rs.getString("ESTADO_CIVIL");
                    String dataNascimento = rs.getString("DATA_NASCIMENTO");

                    Integer idCliente = Integer.parseInt(id);

                    //Converte a variavel de string para char
                    char sexoChar = (!sexo.isEmpty()) ? sexo.charAt(0) : '\0';

                    //Passa as informaçoes para o obj cliente
                    Cliente cliente = new Cliente(idCliente, nome, cpf, telefone, email, sexoChar, estadoCivil, dataNascimento);

                    //Add na lista
                    lista.add(cliente);

                }

            }

        } catch (Exception e) {
            System.out.println("erro para listar -> " + e.getMessage());
            lista = null;
        } finally {

            if (conexao != null) {
                Conexao.fecharConexao();
            }

        }

        return lista;
    }//Fim do método listar

    public static boolean alterar(int id, Cliente cliente) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;

        try {

            conexao = Conexao.abrirConexao();

            //Passo 3 - Preparar o comando SQL
            comandoSQL
                    = conexao.prepareStatement("UPDATE clientes SET NOME = ?, CPF = ?, TELEFONE = ?, EMAIL = ?, SEXO = ?, ESTADO_CIVIL = ?, DATA_NASCIMENTO = ? WHERE ID_CLIENTE = ?");

            comandoSQL.setString(1, cliente.getNome());
            comandoSQL.setString(2, cliente.getCpf());
            comandoSQL.setString(3, cliente.getTelefone());
            comandoSQL.setString(4, cliente.getEmail());
            comandoSQL.setString(5, String.valueOf(cliente.getSexo()));
            comandoSQL.setString(6, cliente.getEstadoCivil());
            comandoSQL.setString(7, cliente.dataFormatada());
            comandoSQL.setInt(8, cliente.getIdCliente());

            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (Exception e) {
            System.out.println("Erro para alterar registro -> " + e.getMessage());
            return false;
        }

        return retorno;
    }
     
    public static boolean excluirClienteComEndereco(int idClienteExcluir) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQLCliente = null;
        PreparedStatement comandoSQLEndereco = null;

        try {
            conexao = Conexao.abrirConexao();

            // os commits não são mais automaticos ele precisa ser chamado manualmente
            conexao.setAutoCommit(false);

            // Passo 1 - Preparar o comando SQL para excluir endereço relacionado ao Id_cliente
            comandoSQLEndereco = conexao.prepareStatement("DELETE FROM endereco WHERE id_clientes = ?");
            comandoSQLEndereco.setInt(1, idClienteExcluir);

            // Passo 2 - Executar o comando para excluir endereço
            int linhasAfetadasEndereco = comandoSQLEndereco.executeUpdate();

            // Passo 3 - Preparar o comando SQL para excluir id do cliente na tabela cliente
            comandoSQLCliente = conexao.prepareStatement("DELETE FROM clientes WHERE ID_CLIENTE = ?");
            comandoSQLCliente.setInt(1, idClienteExcluir);

            // Passo 4 - Executar o comando para excluir cliente
            int linhasAfetadasCliente = comandoSQLCliente.executeUpdate();

            // Commit da transação se ambas as operações foram bem-sucedidas - chama manualmente
            if (linhasAfetadasCliente > 0 && linhasAfetadasEndereco > 0) {
                conexao.commit();
                retorno = true;
            } else {
                // Rollback se algo deu errado
                conexao.rollback();
            }

        } catch (Exception e) {
            // Tratar exceção
            System.out.println("Erro para excluir cliente com endereço -> " + e.getMessage());
            try {
                // Rollback em caso de exceção é acionado para desfazer as mudanças feitas.
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException e1) {
                System.out.println("Erro ao realizar rollback -> " + e1.getMessage());
            }
            return false;
        } finally {
            try {
                // Restaurar o comportamento padrão de commit automático
                if (conexao != null) {
                    conexao.setAutoCommit(true);
                }
            } catch (SQLException e) {
                System.out.println("Erro ao restaurar auto commit -> " + e.getMessage());
            }
        }

        return retorno;
    }

}
