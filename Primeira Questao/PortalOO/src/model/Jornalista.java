package model;

public class Jornalista {

    public static int sequencia = 0;
    private int id;
    private int idade;
    private String nome;
    private String usuario;
    private String senha;


    public Jornalista(int idade, String nome, String usuario, String senha) {
        this.id = sequencia++;
        this.idade = idade;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }
}
