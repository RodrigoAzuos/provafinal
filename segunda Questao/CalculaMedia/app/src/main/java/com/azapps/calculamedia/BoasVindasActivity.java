package com.azapps.calculamedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azapps.calculamedia.util.ConstantsUtil;
import com.azapps.calculamedia.util.PreferencesUtil;

public class BoasVindasActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nome;
    Button botaoConfirmar;
    PreferencesUtil mPreferencesUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
            bindView();
            setupView();


    }

    public void setupView(){
        mPreferencesUtil = new PreferencesUtil(this);
        botaoConfirmar.setOnClickListener(this);
    }

    public void bindView(){
        nome = findViewById(R.id.edt_nome_boas_vindas);
        botaoConfirmar = findViewById(R.id.btn_salvar_nome_boas_vindas);
    }

    public void salvarNome(){
        String nomeUsuario = nome.getText().toString();
        mPreferencesUtil.storeString(ConstantsUtil.NOMEUSUARIO,  nomeUsuario);
        startActivity(new Intent(this, MainActivity.class));
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_salvar_nome_boas_vindas){
            salvarNome();
        }
    }
}
