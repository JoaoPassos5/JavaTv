/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author USer
 */
import java.sql.*;
import java.util.ArrayList;
import model.Filme;
import model.Serie;
import model.Video;

public class VideoDAO {

    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Video> listar() throws SQLException {

        String sql = "SELECT * FROM tbvideo";
        PreparedStatement statement = conn.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        ArrayList<Video> lista = new ArrayList<>();

        while (rs.next()) {

            int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            int duracao = rs.getInt("duracao");
            String tipo = rs.getString("tipo");

            if (tipo.equals("filme")) {
                lista.add(new Filme(id, titulo, duracao));
            } else {
                lista.add(new Serie(id, titulo, duracao));
            }
        }

        return lista;
    }
    
    public ArrayList<Video> buscar(String nome) throws SQLException {

    String sql = "SELECT * FROM tbvideo WHERE titulo ILIKE ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, "%" + nome + "%");

    ResultSet rs = statement.executeQuery();

    ArrayList<Video> lista = new ArrayList<>();

    while (rs.next()) {

        int id = rs.getInt("id");
        String titulo = rs.getString("titulo");
        int duracao = rs.getInt("duracao");
        String tipo = rs.getString("tipo");

        if (tipo.equals("filme")) {
            lista.add(new Filme(id, titulo, duracao));
        } else {
            lista.add(new Serie(id, titulo, duracao));
        }
    }

    return lista;
}
}
