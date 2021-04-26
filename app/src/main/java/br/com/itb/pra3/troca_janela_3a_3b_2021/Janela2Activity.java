package br.com.itb.pra3.troca_janela_3a_3b_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Janela2Activity extends AppCompatActivity {

    Button btnTela2;
    TextView textoDaJanela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janela2);


        // Vinculo
        textoDaJanela = findViewById(R.id.txv_tela2);

        // Receber dados da Intent
        Intent it = getIntent();
        String textoRecebido = it.getStringExtra("texto_digitado");
        // Trocar o texto do label
        textoDaJanela.setText(textoRecebido + " - " + it.getIntExtra("numero_aleatorio", 0));

        // Vínculo do botão da janela
        btnTela2 = findViewById(R.id.btn_tela2);

        // Troca de Janela, desta para a anterior
        btnTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Janela2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}