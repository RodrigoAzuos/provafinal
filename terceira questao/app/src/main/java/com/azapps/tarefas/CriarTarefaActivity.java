package com.azapps.tarefas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azapps.tarefas.util.ConstantsUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import io.objectbox.Box;

public class CriarTarefaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTitulo;
    private EditText edtDescricao;
    private EditText edtDataLimite;
    private Button btnSalvar;
    Box<Tarefa> tarefaBox;
    Box<Usuario> usuarioBox;
    List<Usuario> usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_tarefa);
        bindView();
        setupView();
    }

    public void bindView(){
        edtDataLimite = findViewById(R.id.edt_data_tarefa);
        edtDescricao = findViewById(R.id.edt_descricao_tarefa);
        edtTitulo = findViewById(R.id.edt_titulo_tarefa);
        btnSalvar = findViewById(R.id.btn_criar_tarefa);
    }

    public void setupView(){
        tarefaBox = ((App) getApplication()).getBoxStore().boxFor(Tarefa.class);
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        btnSalvar.setOnClickListener(this);
    }

    public void criarTarefa(){
        usuario = usuarioBox.getAll();
        Calendar date = new GregorianCalendar();
        Tarefa tarefa = new Tarefa(edtTitulo.getText().toString(),
                edtDescricao.getText().toString(), ConstantsUtil.estado[0], date, usuario.get(0).getId());

        tarefaBox.put(tarefa);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_criar_tarefa){
            criarTarefa();
            finish();
        }
    }
}
