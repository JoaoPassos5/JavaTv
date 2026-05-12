/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USer
 */
public class Serie extends Video {
    
    private String situacao;

    public Serie(String situacao, int id, String titulo, int duracao, String genero, int anolancamento) {
        super(id, titulo, duracao, genero, anolancamento);
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
   
    @Override
public String toString() {

    return super.toString() +
           "\nSituação: " + situacao;
}

    @Override
    public void exibirInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
