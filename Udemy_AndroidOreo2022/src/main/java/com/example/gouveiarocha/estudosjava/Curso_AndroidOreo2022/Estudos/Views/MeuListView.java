package com.example.gouveiarocha.estudosjava.Curso_AndroidOreo2022.Estudos.Views;


import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;

import com.example.gouveiarocha.estudosjava.R;

public class MeuListView extends AppCompatActivity {

    private ListView listViewLocais;
    private String[] itens = {"França", "Alemanha", "Italia", "Espanha", "Angola"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_list_view);

        listViewLocais = findViewById(R.id.list_view_locais);

        //CRIA UM ADAPTER PARA A LISTA...
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                //PARAMETROS DO ADAPTER:
                getApplicationContext(),                //Context
                android.R.layout.simple_list_item_1,    //Layout da Lista
                android.R.id.text1,                     //ID do TEXT da simple_list_item_1
                itens) {
            //CODIGOS ABAIXO AJUSTA A COR DO TEXTVIEW:
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };

        //ADICIONA DO ADAPTADOR PARA A LISTA
        listViewLocais.setAdapter(adapter);

        //ADICIONA EVENTO DE CLICK NOS ITENS DA LISTA
        listViewLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = listViewLocais.getItemAtPosition(position).toString();
                Toast.makeText(MeuListView.this, valorSelecionado, Toast.LENGTH_SHORT).show();

            }
        });

    }
}