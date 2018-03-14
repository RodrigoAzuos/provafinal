package model;

import exceptions.PermicaoNegadaException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Noticia extends Base implements Comparable<Noticia> {

    private String titulo;
    private String corpo;
    private String resumo;
    private Image imagem;
    private Area area;
    private Jornalista autor;
    private Editor editor;
    private String status;
    private String log;
    private int qtdAcessos;
    private List<Noticia> noticiasRealacionadas;

    public Noticia(String titulo, String corpo, String resumo, Image imagem, Area area, Jornalista autor, Editor editor) {
        super();
        this.titulo = titulo;
        this.corpo = corpo;
        this.imagem = imagem;
        this.area = area;
        this.autor = autor;
        this.editor = editor;
        this.status = ConstantesUtil.STATUSCONSTANTES[0];
        this.qtdAcessos = 0;
        this.noticiasRealacionadas =  new ArrayList<>();

        if(resumo.length() <141){
            this.resumo = resumo;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public Image getImagem() {
        return imagem;
    }

    public Area getArea() {
        return area;
    }

    public String getLog() {
        return log;
    }

    public Jornalista getAutor() {
        return autor;
    }

    public int getQtdAcessos() {
        return qtdAcessos;
    }

    public Editor getEditor() {
        return editor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQtdAcessos(int qtdAcessos) {
        this.qtdAcessos =+ qtdAcessos;
    }

    public String setTitulo(String titulo, Jornalista autorEditor) {
        if (autorEditor.getId() == this.getAutor().getId() ||
                autorEditor.getId() == this.getEditor().getId() ){
            this.titulo = titulo;
            atualizaLog("publicação editada por", autorEditor);
            return this.getLog();
        }else{
            throw  new PermicaoNegadaException("Você não tem permição para modificar");
        }
    }

    public String desativar(Jornalista autorEditor){
        if (autorEditor.getId() == this.getAutor().getId() ||
                autorEditor.getId() == this.getEditor().getId() ){
            this.status = ConstantesUtil.STATUSCONSTANTES[4];
            atualizaLog("publicação finalizada por", autorEditor);
            return this.getLog();
        }else{
            return "Você não tem permição para editar essa publicação";
        }
    }

    public String setCorpo(String corpo, Jornalista autorEditor) throws PermicaoNegadaException {
        if (autorEditor.getId() == this.getAutor().getId() ||
                autorEditor.getId() == this.getEditor().getId() ) {
            this.corpo = corpo;
            atualizaLog("publicação editada por",autorEditor);
            return this.getLog();
        }else {
            throw  new PermicaoNegadaException("Você não tem permição para modificar");
        }
    }

    public String setImagem(Image imagem, Jornalista autorEditor) throws PermicaoNegadaException {
        if (autorEditor.getId() == this.getAutor().getId() ||
                autorEditor.getId() == this.getEditor().getId() ) {
            this.imagem = imagem;
            atualizaLog("publicação editada por",autorEditor);
            return this.getLog();
        }else{
            throw  new PermicaoNegadaException("Você não tem permição para modificar");
        }
    }

    public String setArea(Area area, Jornalista autorEditor) throws PermicaoNegadaException {
        if (autorEditor.getId() == this.getAutor().getId() ||
                autorEditor.getId() == this.getEditor().getId() ) {
            this.area = area;
            atualizaLog("publicação editada por",autorEditor);
            return this.getLog();
        }else{
            throw  new PermicaoNegadaException("Você não tem permição para modificar");
        }
    }

    protected void atualizaLog(String texto,Jornalista autorEditor){
        super.setEditadaEm();
        this.log += texto + autorEditor.getNome() + "em" + getEditadaEm() + "estado:" + getStatus();
    }

    public String tornarProntaParaRevisao(Jornalista autor) throws PermicaoNegadaException {
        if(autor.getId() == getAutor().getId()){
            this.status = ConstantesUtil.STATUSCONSTANTES[1];
            atualizaLog("Tornada prota, por: ",autor);
            return this.getLog();
        }else{
            throw  new PermicaoNegadaException("Você não tem permição para modificar");
        }
    }

    public String revisar(Editor editor) throws PermicaoNegadaException {
        if (editor.getArea().equals(this.getArea())){
            this.editor = editor;
            atualizaLog("Revisada por",editor);
            this.status = ConstantesUtil.STATUSCONSTANTES[2];
            return this.getLog();
        }else{
            throw  new PermicaoNegadaException("Você não tem permição para modificar");
        }
    }

    public void adcionarNoticiasRealacionadas(Noticia noticiaRealacionada) {
        if(noticiasRealacionadas.size() <= 10)
            this.noticiasRealacionadas.add(noticiaRealacionada);
    }

    @Override
    public int compareTo(Noticia noticia) {
        if (this.getQtdAcessos() > noticia.getQtdAcessos()) {
            return -1;
        }
        if (this.getQtdAcessos() < noticia.getQtdAcessos()) {
            return 1;
        }
        return 0;
    }
}
