package br.com.itb.pra3.troca_janela_3a_3b_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Declaração do objeto
    Button btnTela1;
    EditText caixaDeTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Vinculo do objeto Java com o objeto da janela XML
        btnTela1 = findViewById(R.id.btn_tela1);
        caixaDeTexto = findViewById(R.id.edtNome);


        // Implementar clique no botão
        btnTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Troca de Janela
                Intent it = new Intent(MainActivity.this, Janela2Activity.class);
                // Passar o texto da caixa para o objeto Intent
                it.putExtra("texto_digitado", caixaDeTexto.getText().toString());
                it.putExtra("numero_aleatorio", (int) Math.floor(Math.random() * 100) + 1);

                // Check if we're running on Android 5.0 or higher
                // Checando se o aparelho esta rodando Android 5.0 ou superior
                // Assim a animação é executada na troca de janela
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // Apply activity transition
                    startActivity(it,
                            ActivityOptions.makeSceneTransitionAnimation(
                                    MainActivity.this).toBundle());
                } else {
                    // Swap without transition
                    // Troca de Janela sem transição ou animação
                    startActivity(it);
                }


            }
        });
    }
}