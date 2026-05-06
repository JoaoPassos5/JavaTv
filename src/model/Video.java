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

    public Video(int id, String titulo, int duracao) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
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

    public abstract void exibirInfo();
    
    @Override
    public String toString() {
      return titulo;
}
}