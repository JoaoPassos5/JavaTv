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
    
//Conta quantas listas existem, se tem 3, a proxima sera Lista 4
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

   public ResultSet listarListas(int usuarioId)
        throws SQLException {

    String sql =
        "SELECT * FROM tblista WHERE usuario_id = ?";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, usuarioId);

    return stmt.executeQuery();
}
    
    public int pegarIdLista(String nome, int usuarioId)
        throws SQLException {

    String sql =
        "SELECT id FROM tblista " +
        "WHERE nome = ? AND usuario_id = ?";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setString(1, nome);

    stmt.setInt(2, usuarioId);

    ResultSet rs =
        stmt.executeQuery();

    if (rs.next()) {

        return rs.getInt("id");
    }

    return 0;
   }
    
// Criei pois estava conflitando entre tbvideo e tblista, fazendo assim ele exclui o video da lista antes e ai exclui a lista
    public void excluirLista(int usuarioId, String nome)
        throws SQLException {

    int listaId =
        pegarIdLista(nome, usuarioId);

    String sql1 =
        "DELETE FROM tblista_video " +
        "WHERE lista_id = ?";

    PreparedStatement stmt1 =
        conn.prepareStatement(sql1);

    stmt1.setInt(1, listaId);

    stmt1.execute();

    String sql2 =
        "DELETE FROM tblista " +
        "WHERE id = ?";

    PreparedStatement stmt2 =
        conn.prepareStatement(sql2);

    stmt2.setInt(1, listaId);

    stmt2.execute();
}

//Busca os videos dentro da lista
    public ResultSet listarVideosLista(int listaId)
        throws SQLException {

    String sql =
        "SELECT tbvideo.titulo, tblista_video.ordem " +
        "FROM tblista_video " +
        "JOIN tbvideo " +
        "ON tbvideo.id = tblista_video.video_id " +
        "WHERE tblista_video.lista_id = ? " +
        "ORDER BY ordem";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, listaId);

    return stmt.executeQuery();
   }
    
//Conta quantos videos tem na lista
    public int contarVideosLista(int listaId)
        throws SQLException {

    String sql =
        "SELECT COUNT(*) AS total " +
        "FROM tblista_video " +
        "WHERE lista_id = ?";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, listaId);

    ResultSet rs =
        stmt.executeQuery();

    if (rs.next()) {

        return rs.getInt("total");
    }

    return 0;
    }
    
    public void adicionarVideoLista(
        int listaId,
        int videoId,
        int ordem)
        throws SQLException {

    String sql =
        "INSERT INTO tblista_video " +
        "(lista_id, video_id, ordem) " +
        "VALUES (?, ?, ?)";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, listaId);
    stmt.setInt(2, videoId);
    stmt.setInt(3, ordem);

    stmt.execute();
    }
    
    public void removerVideoLista(
        int listaId,
        String titulo)
        throws SQLException {

    String sql =
        "DELETE FROM tblista_video " +
        "WHERE lista_id = ? " +
        "AND video_id = (" +
        "SELECT id FROM tbvideo " +
        "WHERE titulo = ?" +
        ")";

    PreparedStatement stmt =
        conn.prepareStatement(sql);

    stmt.setInt(1, listaId);

    stmt.setString(2, titulo);

    stmt.execute();
   }
}
