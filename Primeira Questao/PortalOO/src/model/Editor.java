package model;

public class Editor extends Jornalista{

    public boolean chefe;
    public Area area;

    public Editor(int idade, String nome, String usuario, String senha,Area area) {
        super(idade,nome,usuario, senha);
        this.area = area;
        this.chefe = false;
    }

    public Area getArea() {
        return this.area;
    }

    public void tornarChefe(){
        this.chefe = true;
    }

    public boolean isChefe(){
        return this.chefe;
    }
}
