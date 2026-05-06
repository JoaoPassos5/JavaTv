/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ContaDAO;
import dao.Conexao;
import model.Conta;
import view.Login;
import view.Logado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleLogin {

    private Login tela;

    public ControleLogin(Login tela) {
        this.tela = tela;
    }

    public void loginConta() {

        Conta conta = new Conta(
            null,
            tela.getTxtUsuario().getText(),
            tela.getTxtSenha().getText()
        );

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection();

            ContaDAO dao = new ContaDAO(conn);
            ResultSet res = dao.consultar(conta);

          if (res.next()) {
              JOptionPane.showMessageDialog(
              tela,
              "Login feito",
              "Aviso",
              JOptionPane.INFORMATION_MESSAGE
    );

            int id = res.getInt("id"); 

           String nome = res.getString("nome");
           String usuario = res.getString("usuario");
           String senha = res.getString("senha");

           Logado tela2 = new Logado(new Conta(id, nome, usuario, senha)); 

           tela2.setVisible(true);
           tela.setVisible(false);

              } else {
                JOptionPane.showMessageDialog(
                    tela,
                    "Login não efetuado",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                tela,
                "Erro de conexão",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
