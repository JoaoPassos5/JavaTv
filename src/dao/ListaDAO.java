/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USer
 */
public class ListaDAO {
    
    private Connection conn;

    public ListaDAO(Connection conn) {
        this.conn = conn;
    
    }
    
    public void criarLista(int usuarioId, String nome)
        throws SQLException {

    String sql =
        "INSERT INTO tblista (nome, usuario_id) VALUES (?, ?)";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setString(1, nome);
    stmt.setInt(2, usuarioId);

    stmt.execute();
    }
    
    public int contarListas(int usuarioId)
        throws SQLException {

    String sql =
        "SELECT COUNT(*) AS total FROM tblista WHERE usuario_id = ?";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, usuarioId);

    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {

        return rs.getInt("total");
    }

    return 0;
    }
}
