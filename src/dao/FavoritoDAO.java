/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author USer
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoritoDAO {

    private Connection conn;

    public FavoritoDAO(Connection conn) {
        this.conn = conn;
    }

    public void adicionarFavorito(int usuarioId, int videoId) throws SQLException {

        String sql = "INSERT INTO tbfavorito (usuario_id, video_id) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, usuarioId);
        stmt.setInt(2, videoId);

        stmt.execute();
    }

    public void removerFavorito(int usuarioId, int videoId) throws SQLException {

        String sql = "DELETE FROM tbfavorito WHERE usuario_id = ? AND video_id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, usuarioId);
        stmt.setInt(2, videoId);

        stmt.execute();
    }

    public ResultSet listarFavoritos(int usuarioId) throws SQLException {

        String sql = """
            SELECT tbvideo.*
            FROM tbvideo
            JOIN tbfavorito
            ON tbvideo.id = tbfavorito.video_id
            WHERE tbfavorito.usuario_id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, usuarioId);

        return stmt.executeQuery();
    }
}
