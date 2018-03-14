package model;

public class Area {

    private String nome;
    private String cor;

    public Area(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }
}
