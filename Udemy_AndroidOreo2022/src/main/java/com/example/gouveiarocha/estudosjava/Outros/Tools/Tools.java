package com.example.gouveiarocha.estudosjava.Outros.Tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public abstract class Tools {

    /**
     * Metodo para envio de e-mail...
     */

    public static void enviarEmail(Context c) {
        Intent email = new Intent(Intent.ACTION_SEND);

        //E-mail, Assunto, Msg e Type.
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"atmconsultoria@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato APP");
        email.putExtra(Intent.EXTRA_TEXT, "Mensagem automática...");
        email.setType("message/rfc822");
        //Cria tela de opção para o Usuario escolher o app que deseja usar...
        //c.startActivity(Intent.createChooser(email, "Escolha o App de E-mail..."));
        c.startActivity(email);

        //EX Outros types:
        //Site com diversos MIME Types: https://www.sitepoint.com/mime-types-complete-list/
        //email.setType("text/plain");      //Textos
        //email.setType("application/pdf"); //Arquivos PDF
        //email.setType("image/png");       //Arquivos de imagem PNG

    }

    /**
     * APENAS PARA TESTES
     * Para abrir link de uma imagem. Método incompleto apenas para testes... A ACTION_VIEW serve
     * para outras finalidades, como abrir um end. no app de GPS(bastaria ter a string do end. do app)
     * e ele iria executar diretamente no app, se instalado no celular.
     */

    public static void abrirImagem(Context c) {
        String img = "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwiY7faS6JLnAhVsrlkKHRjmAgoQjRx6BAgBEAQ&url=https%3A%2F%2Fpleno.news%2Fentretenimento%2Fcultura-e-lazer%2Fimagem-de-esquilo-cheirando-flor-faz-sucesso-na-internet.html&psig=AOvVaw0NVB1zB4Atvk54YfE0_a08&ust=1579631528786680";
        c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(img)));
    }

}
