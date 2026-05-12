/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USer
 */
public abstract class Video {

    protected int id;
    protected String titulo;
    protected int duracao;
    protected String genero;
    protected int anolancamento;

    public Video(int id, String titulo, int duracao, String genero, int anolancamento) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.anolancamento = anolancamento;
    }


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnolancamento() {
        return anolancamento;
    }
    

    public abstract void exibirInfo();
    
    @Override
public String toString() {

    return "Título: " + titulo +
           "\nGênero: " + genero +
           "\nDuração: " + duracao +
           "\nAno: " + anolancamento;
}
}