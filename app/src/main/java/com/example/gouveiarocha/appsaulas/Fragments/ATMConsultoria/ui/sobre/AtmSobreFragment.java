package com.example.gouveiarocha.appsaulas.Fragments.ATMConsultoria.ui.sobre;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gouveiarocha.appsaulas.R;

import mehdi.sakout.aboutpage.AboutPage;

/**
 * A simple {@link Fragment} subclass.
 */
public class AtmSobreFragment extends Fragment {


    public AtmSobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "A empresa foi fundada em 1919 por Isaac Carasso na Espanha (Barcelona) como uma pequena fábrica " +
                "de produção de iogurte. A fábrica foi nomeada \"Danone\", em catalão, em homenagem ao apelido \"Danon\" " +
                "do nome de seu primeiro filho, Daniel Carasso.[2]\n" +
                "\n" +
                "O grupo Danone é conhecido pelos seus produtos lácteos, especialmente pelos iogurtes. " +
                "Está presente em mais de 120 países, contando em 2009 com 92.209 mil colaboradores, " +
                "sendo o terceiro maior grupo alimentício da Europa, o sétimo maior fabricante de alimentos " +
                "do mundo, e o primeiro em países como a França, Espanha e Itália.\n";

        return new AboutPage(getActivity())
                .setImage(R.drawable.atm_logo) //Imagem superior..
                .setDescription(descricao) //Descrição da pagina...
                .addGroup("FALE CONOSCO") //Cria um grupo de itens...
                .addEmail("contato@atmconsultoria.com", "Envie um e-mail...") //Adiciona link de e-mail...
                .addWebsite("www.google.com.br", "Acesse nosso WebSite...") //Adiciona link de website
                .addGroup("REDES SOCIAIS") //Cria um grupo de itens
                .addFacebook("google", "Curtir página do Facebook...") //Criar link para o facebook, as demais redes sociais funcionam da mesma forma.
                .addTwitter("twitter", "Seguir no Twitter")
                .create();

        //setContentView(sobre);

    }

}
