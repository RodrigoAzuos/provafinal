package com.azapps.calculamedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azapps.calculamedia.util.ConstantsUtil;

public class CalculaMediaActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtPesoPrimeiraNota;
    private EditText edtPesoSegundaNota;
    private Button btnCalculaNota;
    private float primeraNota;
    private float segundaNota;
    private float pesoSegundaNota;
    private float pesoPrimeiraNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_media);
        bindView();
        setupView();
    }

    public void setupView(){
        Intent intent = getIntent();
        primeraNota = intent.getLongExtra(ConstantsUtil.PRIMEIRANOTA, -1);
        segundaNota = intent.getLongExtra(ConstantsUtil.SEGUNDANOTA, -1);
        btnCalculaNota.setOnClickListener(this);
        pesoPrimeiraNota = Float.parseFloat(edtPesoPrimeiraNota.getText().toString());
        pesoSegundaNota = Float.parseFloat(edtPesoSegundaNota.getText().toString());

    }


    public void bindView(){
        edtPesoPrimeiraNota = findViewById(R.id.edt_peso_primeira_nota);
        edtPesoSegundaNota = findViewById(R.id.edt_peso_segunda_nota);
        btnCalculaNota = findViewById(R.id.btn_calcular_media);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_calcular_media){
          calculaMedia();
        }
    }
    private void calculaMedia() {
        float somaNota = (primeraNota * pesoPrimeiraNota) + (segundaNota * pesoSegundaNota);
        float somaPeso = pesoPrimeiraNota + pesoSegundaNota;
        float media = somaNota / somaPeso;

        Intent intent = new Intent();
        intent.putExtra(ConstantsUtil.MEDIA,media);
        setResult(RESULT_OK, intent);
        finish();
    }
}
