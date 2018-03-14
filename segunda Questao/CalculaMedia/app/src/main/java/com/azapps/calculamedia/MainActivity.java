package com.azapps.calculamedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azapps.calculamedia.util.ConstantsUtil;
import com.azapps.calculamedia.util.PreferencesUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtPrimeiraNota;
    private EditText edtSegundaNota;
    private Button btnConfirmarNota;
    private PreferencesUtil mPreferencesUtil;
    private String usuario;
    private float primeraNota;
    private float segundaNota;
    private EditText resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupView();
        checarUsuario();
    }

    public void setupView(){
        mPreferencesUtil = new PreferencesUtil(this);
        btnConfirmarNota.setOnClickListener(this);
        primeraNota = Float.parseFloat(edtPrimeiraNota.getText().toString());
        segundaNota = Float.parseFloat(edtSegundaNota.getText().toString());
    }

    public void bindView(){
        edtPrimeiraNota = findViewById(R.id.edt_primeira_nota);
        edtSegundaNota = findViewById(R.id.edt_segunda_nota);
        btnConfirmarNota = findViewById(R.id.btn_confirmar_notas);
        resultado = findViewById(R.id.resultadoMedia);
    }

    public void checarUsuario(){
        usuario = mPreferencesUtil.getStoredString(ConstantsUtil.NOMEUSUARIO);
        if (usuario.equals("-1")){
            startActivity(new Intent(this, BoasVindasActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_confirmar_notas){
            Intent intent = new Intent(this, CalculaMediaActivity.class);
            intent.putExtra(ConstantsUtil.PRIMEIRANOTA, primeraNota );
            intent.putExtra(ConstantsUtil.SEGUNDANOTA, segundaNota );
            startActivityForResult(intent, ConstantsUtil.REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ConstantsUtil.REQUEST_CODE)
            if (resultCode == RESULT_OK){

                Float media = data.getFloatExtra(ConstantsUtil.MEDIA, -1);

                if (media >= 7){
                    resultado.setText(usuario + "Você está aprovado, média: " + media);
                }
                else if (media >= 4){
                    resultado.setText(usuario + "Você está de prova final, média: " + media);
                }
                else{
                    resultado.setText(usuario + "Você está reprovado, média: " + media);
                }

            }
    }
}
