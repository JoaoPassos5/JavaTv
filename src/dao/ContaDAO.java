/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Conta;

public class ContaDAO {

    private Connection conn;

    public ContaDAO(Connection conn) {
        this.conn = conn;
    }

    public ResultSet consultar(Conta conta) throws SQLException {
        String sql = "select * from tbusuario where usuario = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, conta.getUsuario());
        statement.setString(2, conta.getSenha());

        ResultSet resultado = statement.executeQuery();
        return resultado;
    }

    public void inserir(Conta conta) throws SQLException {
        String sql = "insert into tbusuario (nome, usuario, senha) values (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, conta.getNome());
        statement.setString(2, conta.getUsuario());
        statement.setString(3, conta.getSenha());

        statement.execute();
        conn.close();
    }

}
