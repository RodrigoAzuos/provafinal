package com.azapps.tarefas;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by rodrigo-souza on 14/03/18.
 */
@Entity
public class Usuario {
    @Id
    private long id;
    private String Nome;

    public Usuario(String nome) {
        Nome = nome;
    }

    public long getId() {
        return id;
    }
}

