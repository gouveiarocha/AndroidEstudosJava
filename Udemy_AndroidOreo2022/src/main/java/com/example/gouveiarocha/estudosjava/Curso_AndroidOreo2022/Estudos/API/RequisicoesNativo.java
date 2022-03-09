package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.API;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gouveiarocha.estudosjava.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Exemplos de Requisições Web e utilização de APIs.
 */

public class RequisicoesNativo extends AppCompatActivity {

    private EditText etxtCepDigitado;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisicoes);

        txtResultado = findViewById(R.id.txt_req_resultado);
        etxtCepDigitado = findViewById(R.id.etxt_req_cep);

    }

    public void recuperarCep(View view) {
        String cepDigitado = etxtCepDigitado.getText().toString();
        MyTask task = new MyTask();
        String urlApi = "https://viacep.com.br/ws/" + cepDigitado + "/json/";
        task.execute(urlApi);
    }

    public void recuperarMoedas(View view) {
        MyTask task = new MyTask();
        String urlApi = "https://blockchain.info/ticker";   //api p/ valor bitcoin
        task.execute(urlApi);
    }

    //Minha classe de tarefas para executar as requisições...
    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer stringBuffer = null;               //StringBuffer permite montar uma String 'linha a linha'.

            try {
                URL url = new URL(stringUrl);
                //Faz conexão com a url
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //Recupera os dados em bytes
                inputStream = connection.getInputStream();
                //Lê os dados em bytes e decodifica para caracteres
                inputStreamReader = new InputStreamReader(inputStream);
                //Permite a leitura dos caracteres do InputStreamReader
                BufferedReader reader = new BufferedReader(inputStreamReader);
                //inputStreamReader.read(); //leitura de todos os dados.
                stringBuffer = new StringBuffer();
                String linha = "";
                //Vai ler e gravar o retorno em cada linha da String enquanto for diferente de nulo.
                while ((linha = reader.readLine()) != null) {
                    stringBuffer.append(linha); //o metodo append adiciona linhas a StringBuffer
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return stringBuffer.toString(); //Retorna a String final recuperada.

        }

        @Override
        protected void onPostExecute(String resultado) {
            super.onPostExecute(resultado);

            /*//Recuperando apenas um ou mais registros de acordo com a chave(Exemplo do CEP)
            String logradouro = null;
            String cep = null;
            try {
                JSONObject jsonObject = new JSONObject(resultado);
                logradouro = jsonObject.getString("logradouro");
                cep = jsonObject.getString("cep");
            } catch (JSONException e) {
                e.printStackTrace();
            }*/

            //Recuperando apenas um ou mais registros de acordo com a chave(Exemplo das Moedas). Atenção, nesse exemplo, vamos recuperar um dado
            //que esta dentro do objeto BRL - ou seja estamos recuperando um dado mais 'profundo'.
            String objetoValor = null;
            String valorMoeda = null;
            String simbolo = null;
            try {
                JSONObject jsonObject = new JSONObject(resultado);
                objetoValor = jsonObject.getString("BRL");          //pegamos o obj 'BRL', que trata-se da moeda Real.
                JSONObject jsonObjectReal = new JSONObject(objetoValor);  //criamos um novo jsonObjectReal para adentrar mais profundamente nos dados
                valorMoeda = jsonObjectReal.getString("last");      //pegamos o valor final da moedaem bitcoin.
                simbolo = jsonObjectReal.getString("symbol");       //pegamos o simbolo da moeda Real.
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //txtResultado.setText(resultado);

            //Exemplos resultado CEP
            //txtResultado.setText(logradouro);
            //txtResultado.setText(logradouro+"/"+cep);

            //Exemplos resultados Moedas
            txtResultado.setText("Valor Bitcoin em: " + simbolo + valorMoeda);
        }
    }

}
