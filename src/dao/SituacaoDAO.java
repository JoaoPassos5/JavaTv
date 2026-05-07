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

public class SituacaoDAO {

    private Connection conn;

    public SituacaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvarSituacao(int usuarioId, int videoId, boolean curtido) throws SQLException {

        String delete = "DELETE FROM tbsituacao WHERE usuario_id = ? AND video_id = ?";

        PreparedStatement stmtDelete = conn.prepareStatement(delete);
        stmtDelete.setInt(1, usuarioId);
        stmtDelete.setInt(2, videoId);
        stmtDelete.execute();

        String insert = "INSERT INTO tbsituacao (usuario_id, video_id, curtido) VALUES (?, ?, ?)";

        PreparedStatement stmtInsert = conn.prepareStatement(insert);
        stmtInsert.setInt(1, usuarioId);
        stmtInsert.setInt(2, videoId);
        stmtInsert.setBoolean(3, curtido);

        stmtInsert.execute();
    }

    public ResultSet listarCurtidos(int usuarioId) throws SQLException {

        String sql = """
            SELECT tbvideo.*
            FROM tbvideo
            JOIN tbsituacao
            ON tbvideo.id = tbsituacao.video_id
            WHERE tbsituacao.usuario_id = ?
            AND tbsituacao.curtido = true
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);

        return stmt.executeQuery();
    }

    public ResultSet listarDescurtidos(int usuarioId) throws SQLException {

        String sql = """
            SELECT tbvideo.*
            FROM tbvideo
            JOIN tbsituacao
            ON tbvideo.id = tbsituacao.video_id
            WHERE tbsituacao.usuario_id = ?
            AND tbsituacao.curtido = false
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);

        return stmt.executeQuery();
    }
}