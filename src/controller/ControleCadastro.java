/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ContaDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Conta;
import view.Cadastro;

public class ControleCadastro {

    private Cadastro tela3;

    public ControleCadastro(Cadastro tela3) {
        this.tela3 = tela3;
    }

    public void salvarConta() {

        String nome = tela3.getTxtNome().getText();
        String usuario = tela3.getTxtUsuario().getText();
        String senha = tela3.getTxtSenha().getText();

        Conta conta = new Conta(nome, usuario, senha);

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection();

            ContaDAO dao = new ContaDAO(conn);
            dao.inserir(conta);

            JOptionPane.showMessageDialog(
                tela3,
                "Usuário cadastrado!",
                "Aviso",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (SQLException ex) {
    ex.printStackTrace(); // MOSTRA O ERRO REAL

    JOptionPane.showMessageDialog(
        tela3,
        "Erro: " + ex.getMessage(),
        "Erro",
        JOptionPane.ERROR_MESSAGE
    );
}
    }
}
