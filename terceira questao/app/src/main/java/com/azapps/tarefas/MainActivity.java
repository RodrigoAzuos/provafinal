package com.azapps.tarefas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.azapps.tarefas.adapters.AdapterTarefa;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private FloatingActionButton actionButton;
    private Box<Usuario> boxStore;
    private Box<Tarefa> tarefaBox;
    private List<Usuario> usuario;
    private List<Tarefa> tarefas;
    private AdapterTarefa mAdapterTarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }

    public void setupView(){
        actionButton.setOnClickListener(this);
        boxStore = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        tarefaBox = ((App) getApplication()).getBoxStore().boxFor(Tarefa.class);
    }

    public void checarUsuario(){
        usuario = boxStore.getAll();
        if (usuario.size() < 1){
            startActivity(new Intent(this, CriarUsuarioActivity.class));
            finish();
        }

    }

    public void bindView(){
        actionButton = findViewById(R.id.fab_plus_add_tarefa);
        recyclerView = findViewById(R.id.rv_lista_tarefa_home);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.fab_plus_add_tarefa){
            startActivity(new Intent(this, CriarTarefaActivity.class));
        }
    }

    public void atualizaLista(){
        tarefas = tarefaBox.getAll();
         mAdapterTarefa = new AdapterTarefa(tarefas, this);

        recyclerView.setAdapter(mAdapterTarefa);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        linearLayoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
