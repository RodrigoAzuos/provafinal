package com.azapps.tarefas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CriarUsuarioActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nomeUsuario;
    private Button btnConfirma;
    private Box<Usuario> boxStore;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_usuario);
        bindView();
        setupView();
    }

    public void bindView(){
        nomeUsuario = findViewById(R.id.edt_nome_usuario);
        btnConfirma = findViewById(R.id.btn_criarUsuario);

    }

    public void setupView(){
        btnConfirma.setOnClickListener(this);
        boxStore = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_criarUsuario){
            criarUsuario();
        }
    }

    private void criarUsuario() {
        usuario = new Usuario(nomeUsuario.getText().toString());
        boxStore.put(usuario);
        startActivity(new Intent(this, MainActivity.class));
    }
}

