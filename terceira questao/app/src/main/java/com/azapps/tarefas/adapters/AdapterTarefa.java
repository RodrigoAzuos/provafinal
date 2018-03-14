package com.azapps.tarefas.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azapps.tarefas.R;
import com.azapps.tarefas.Tarefa;
import com.azapps.tarefas.util.ConstantsUtil;

import java.util.List;

/**
 * Created by rodrigo-souza on 14/03/18.
 */

public class AdapterTarefa extends RecyclerView.Adapter<AdapterTarefa.ViewHolder> {
    private List<Tarefa> tarefaList;
    private Context mContext;

    public AdapterTarefa(List<Tarefa> tarefaList, Context mContext) {
        this.tarefaList = tarefaList;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView descricao;
        TextView data;
        ImageView comecar;
        ImageView finalizar;
        ImageView concluir;

        public ViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.layout_titulo_tarefa);
            descricao = itemView.findViewById(R.id.layout_descricao_tarefa);
            data = itemView.findViewById(R.id.layout_data_expiracao);
            comecar = itemView.findViewById(R.id.layout_iniciar_tarefa);
            finalizar = itemView.findViewById(R.id.layout_finalizar_tarefa);
            concluir = itemView.findViewById(R.id.layout_tarefa_concluida);

        }
    }

    @Override
    public AdapterTarefa.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View jobView = inflater.inflate(R.layout.layout_adapter_tarefa, parent ,false);
        ViewHolder viewHolder = new ViewHolder(jobView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Tarefa tarefa = tarefaList.get(position);

        holder.titulo.setText( tarefa.getTitulo());
        holder.descricao.setText(tarefa.getDescricao());
        holder.data.setText(tarefa.getDataLimite().toString());


        holder.comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarefa.setEstado(ConstantsUtil.estado[1]);
            }
        });

        holder.finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarefa.setEstado(ConstantsUtil.estado[3]);
            }

        });

        holder.concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarefa.setEstado(ConstantsUtil.estado[2]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public Context getContext() {
        return mContext;
    }
}
