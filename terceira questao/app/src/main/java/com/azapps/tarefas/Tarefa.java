package com.azapps.tarefas;

import java.util.Calendar;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by rodrigo-souza on 14/03/18.
 */
@Entity
public class Tarefa{

    @Id
    private long id;
    private String titulo;
    private String descricao;
    private String estado;
    private Calendar dataLimite;
    private ToOne<Usuario> usuario;

    public Tarefa(String titulo, String descricao, String estado, Calendar dataLimite, long usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.estado = estado;
        this.dataLimite = dataLimite;
        this.usuario.setTargetId(usuario);
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstado() {
        return estado;
    }

    public Calendar getDataLimite() {
        return dataLimite;
    }

    public ToOne<Usuario> getUsuario() {
        return usuario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDataLimite(Calendar dataLimite) {
        this.dataLimite = dataLimite;
    }


}
