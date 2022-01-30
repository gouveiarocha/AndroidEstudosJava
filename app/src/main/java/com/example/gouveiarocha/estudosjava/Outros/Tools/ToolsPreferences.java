package com.example.gouveiarocha.estudosjava.Outros.Tools;

import android.content.Context;
import android.content.SharedPreferences;

public class ToolsPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "ARQUIVO_PREFERENCIA";
    private final String CHAVE_TEXTO = "txt";

    public ToolsPreferences(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void salvar(String txt){
        editor.putString(CHAVE_TEXTO, txt);
        editor.commit();
    }

    public String recuperar(){
        return preferences.getString(CHAVE_TEXTO, "");
    }

}
