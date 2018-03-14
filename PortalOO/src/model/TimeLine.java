package model;

import java.util.*;

public class TimeLine {

    private List<Noticia> noticias;
    private List<Noticia> noticiasDestaque;
    private Noticia noticiaPrincipal;

    public TimeLine(List<Noticia> noticias) {
        this.noticias = new ArrayList<>();
        this.noticiasDestaque = new ArrayList<>();
        this.noticiaPrincipal = null;
    }

    public void adicionarNoticia(Noticia noticia){
        if (noticia.getStatus().equals(ConstantesUtil.STATUSCONSTANTES[2])) {
            noticias.add(noticia);
            noticia.setStatus(ConstantesUtil.STATUSCONSTANTES[3]);
            noticia.atualizaLog("Publicada por: ", noticia.getAutor());
        }
    }

    public void noticiaPrincipal(Editor editor, Noticia noticia){
        if(editor.isChefe())
            this.noticiaPrincipal = noticia;
        }

    public List<Noticia> noticiasMaisLidas(){
        Date dataHoje = new Date();
        int dia = dataHoje.getDay();
        List<Noticia> maislidas = new ArrayList<>();
        List<Noticia> noticiasTemporarias = new ArrayList<>();
        for (Noticia noticia : noticias ){
            if (dia - noticia.getCriadaEm().getDay() <= 3){
                noticiasTemporarias.add(noticia);
            }
        }

        Collections.sort(noticiasTemporarias);

        for (int i = 0; i <= 10; i++){
            maislidas.add(noticiasTemporarias.get(i));
        }

        return maislidas;

    }

    public List<Noticia> noticiasDestaque(Editor editor , List<Noticia> noticias){
        if (editor.isChefe()){
            this.noticiasDestaque = noticias;
        }

        return this.noticiasDestaque;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public Noticia getNoticiaPrincipal() {
        return noticiaPrincipal;
    }

    public void desativarNoticia(Editor editor, Noticia noticia ){
        if(editor.isChefe()){
            noticia.setStatus(ConstantesUtil.STATUSCONSTANTES[4]);
        }
    }
}
