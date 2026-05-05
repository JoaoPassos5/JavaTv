/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USer
 */
public class Filme extends Video {
    
    private String diretor, genero;

    public Filme(String titulo, int duracao, String diretor, String genero) {
        super(titulo, duracao);
        this.diretor = diretor;
        this.genero = genero;
    }

    @Override
    public void exibirInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
