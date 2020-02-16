package com.example.gouveiarocha.appsaulas.ActsEstudos.Navegacao;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gouveiarocha.appsaulas.Fragments.EstudosFragments.ContatosFragment;
import com.example.gouveiarocha.appsaulas.Fragments.EstudosFragments.ConversasFragment;
import com.example.gouveiarocha.appsaulas.R;

public class Fragments extends AppCompatActivity {

    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        //Remove a sombra da ActionBar
        getSupportActionBar().setElevation(0);

        //Instancia os fragments
        conversasFragment = new ConversasFragment();
        contatosFragment = new ContatosFragment();

    }

    public void btnConversas(View view){
        carregarFragment("conversas");
    }

    public void btnContatos(View view){
        carregarFragment("contatos");
    }

    public void carregarFragment(String fragmento){
        if (fragmento.equals("conversas")){
            //Configura objeto para o fragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //Inicia uma transação...
            transaction.replace(R.id.frame_fragments_conteudo, conversasFragment); //Adiciona o conteudo do (2º parametro) ao fragmento(1º parametro)
            transaction.commit(); //Finaliza a transação.
        } else if (fragmento.equals("contatos")){
            //Configura objeto para o fragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //Inicia uma transação...
            transaction.replace(R.id.frame_fragments_conteudo, contatosFragment); //Adiciona o conteudo do (2º parametro) ao fragmento(1º parametro)
            transaction.commit(); //Finaliza a transação.
        } else {
            //Isso não deveria ocorrer.
        }
    }

}
