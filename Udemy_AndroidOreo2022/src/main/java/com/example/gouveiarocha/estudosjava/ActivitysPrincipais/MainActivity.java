package com.example.gouveiarocha.estudosjava.ActivitysPrincipais;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gouveiarocha.estudosjava.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIA A HOMEPAGE
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        //startActivity(new Intent(MainActivity.this, Threads.class));

    }

    /**
     * Sobre:
     * Este projeto contempla conteudo do curso ANDROID OREO da UDEMY - PROF. Jamilton Damasceno.
     * Contempla todas as aulas dos módulos 1 ao 14 e...
     * E demais experiencias proprias.
     * Os Apps CLONES, do mesmo curso, seram desenvolvidos em projetos exclusivos.
     */

    /** LOCALIZAÇÕES IMPORTANTES:
     * Método para envio de e-mail: AppAtmConsultoria.enviaEmail()
     */

    /** CÓDIGOS ACTION BAR
     * Retirar sombra da ActionBar: getSupportActionBar().setElevation(0);
     * Esconder ActionBar: getSupportActionBar().hide();
     * Trocar o title: getSupportActionBar().setTitle("Abas");
     * Trocar a cor: getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D32F2F")));
     * String nomeArquivo = UUID.randomUUID().toString();          //A Classe UUID cria um ID unico com base na data e hora atual.
     */

    /** COMANDOS IDE:
     * CTRL+SHIFT+SETA CIMA OU BAIXO: Joga a linha atual para cima ou para baixo.
     * CTRK+D: Duplica a linha atual
     * CTRL+ALT+L - Formata o código, seja o java ou o xml.
     * CTRL+ALT+M - Extrai trecho de codigo para um metodo
     * CTRL+ALT+O - Limpa os imports nao utilizados
     */

    /** CLASSES E CODIGOS UTEIS
     * CLASSE UUID = Essa classe gera ids unicos baseados na data\hora\minuto\segundo. Para gerar um id, bast utilizar o código: UUID.randomUUID().toString()
     */

}
