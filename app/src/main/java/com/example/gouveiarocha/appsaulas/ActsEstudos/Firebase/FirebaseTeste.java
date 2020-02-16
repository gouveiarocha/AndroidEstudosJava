package com.example.gouveiarocha.appsaulas.ActsEstudos.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gouveiarocha.appsaulas.Classes.Modelos.Usuario;
import com.example.gouveiarocha.appsaulas.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

/**
 * Atenção: As aulas estão separadas por métodos.
 */

public class FirebaseTeste extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase
            .getInstance()      //Recupera instancia do Firebase para salvar/atualizar dados...
            .getReference();    //Retorna ao nó raiz

    private FirebaseAuth auth = FirebaseAuth
            .getInstance();     //Recupera instancia do Firebase Auth...

    private StorageReference storage = FirebaseStorage
            .getInstance()      //Recupera instancia do Firebase Storage...
            .getReference();    //Retorna ao nó raiz

    private TextView valorRecuperado;
    private ImageView imgUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_teste);

        //salvandoDados();        //Salvando/Atualizando dados...
        //recuperandoDados();     //Recuperando dados...
        //authCadastro();         //Cadastro de usuário...
        //authAutenticacao();     //Autenticação de usuário...
        //login("logar");         //Login - Logar e Deslogar...
        //identificadorUnico();   //Salvar dados com id unico...
        //filtros();              //filtros e pesquisas...

    }

    public void salvandoDados() {
        //1º Forma - Acessando nó por nó...
        reference.child("clientes").child("001").child("fantasia").setValue("SOFTCLEVER2");

        //2º Forma - Criando uma referencia para o nó principal...
        DatabaseReference clientes = reference.child("clientes");
        clientes.child("002").child("fantasia").setValue("Pão de Açucar");

        //3º Forma - Com objetos
        Usuario usuario1 = new Usuario("Carlos", "Nascimento", 50);
        DatabaseReference usuarios = reference.child("usuarios");
        usuarios.child("003").setValue(usuario1);
    }

    public void identificadorUnico() {
        DatabaseReference usuarios = reference.child("usuarios");
        //O método push criar um identificar unico...
        usuarios.push().setValue(new Usuario("Thiago", "Rocha", 23));
    }

    public void recuperandoDados() {
        valorRecuperado = findViewById(R.id.txt_dbref_recuperado);

        DatabaseReference usuarios = reference.child("usuarios");

        //Ouvinte. Altera os dados em tempo real...
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //valorRecuperado.setText(dataSnapshot.getValue().toString());              //Nó auth completo...
                valorRecuperado.setText(dataSnapshot.child("001").getValue().toString());   //Apenas o nó 001...
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void authCadastro() {
        auth.createUserWithEmailAndPassword("gouveiatab@gmail.com", "dg@123456789")
                .addOnCompleteListener(FirebaseTeste.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Conferir se o cadastro deu certo...
                        if (task.isSuccessful()) {
                            Toast.makeText(FirebaseTeste.this, "Sucesso ao cadastrar usuário...", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(FirebaseTeste.this, "Erro ao cadastrar usuário...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void authAutenticacao() {
        if (auth.getCurrentUser() != null) {
            //Usuario logado
        } else {
            //Usuario deslogado
        }
    }

    public void login(String login) {
        auth = FirebaseAuth.getInstance();
        if (login.equals("logar")) {
            auth.signInWithEmailAndPassword("gouveia.tab@gmail.com", "abc123")
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(FirebaseTeste.this, "Usuario Logado...", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(FirebaseTeste.this, "Usuário não logado...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else if (login.equals("deslogar")) {
            auth.signOut();
        } else {
            //String não corresponde...
        }
    }

    public void filtros() {

        DatabaseReference usuarios = reference.child("usuarios");

        DatabaseReference pesquisaUsuario = usuarios.child("-M-Uj1MHmJcX3EqGPYRu"); //usando o id unico para posterior pesquisa.

        Query pesquisaNomeUnico = usuarios      //cria um obj Query
                .orderByChild("nome")           //ordena pelo nome
                .equalTo("Douglas");            //filtra o registro

        Query pesquisaIdade = usuarios.orderByChild("idade").equalTo(29);                           //Pesquisa pela idade*.
        Query pesquisaTodos = usuarios;                                                             //Pesquisa todos os usuários.
        Query pesquisaComLimitePrimeiro = usuarios.orderByKey().limitToFirst(3);                    //limita os resultados a partir do primeiro.
        Query pesquisaComLimiteUltimo = usuarios.orderByKey().limitToLast(3);                       //limita os resultados a partir do ultimo.
        Query pesquisaTodosMaiorIgual = usuarios.orderByChild("idade").startAt(40);                 //usuarios com idade >= (maior ou igual) 40*.
        Query pesquisaTodosMenorIgual = usuarios.orderByChild("idade").endAt(40);                   //usuarios com idade <= (menor ou igual) 40*.
        Query pesquisaTodosEntre = usuarios.orderByChild("idade").startAt(40).endAt(50);            //usuarios entre 40* e 50*.
        Query pesquisaNome = usuarios.orderByChild("nome").startAt("D").endAt("D" + "\uf8ff");      //usuarios que nome começe com a letra D*.

        //Ouvinte que executa o retorno da pesquisa em tempo real...
        pesquisaNome.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Usuario dadosUsuarios = dataSnapshot.getValue(Usuario.class);     //associa uma classe para o retorno dataSnapshot
                //Log.i("Filtro Usuarios", "nome: " + dadosUsuarios.getNome());     //filtro a partir de uma classe.

                Log.i("Filtro Usuarios", dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void storageUpload(View view) {

        imgUpload = findViewById(R.id.img_upload);

        //Configura para a imagem ser salva em memória
        imgUpload.setDrawingCacheEnabled(true);
        imgUpload.buildDrawingCache();

        //Recupera o bitmnap da imagem
        Bitmap bitmap = imgUpload.getDrawingCache();

        //Converter em png/jpeg
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);

        //Converte o baos para pixels brutos em uma matriz de bytes
        //(dados da imagem)
        byte[] dadosImagem = baos.toByteArray();

        //Define nós para o storage
        StorageReference imagens = storage.child("imagens");        //Se não existir, será criada uma nova pasta imagens. Se existir, recupera a ref.

        //Nome do arquivo
        String nomeArquivo = UUID.randomUUID().toString();          //A Classe UUID cria um ID unico com base na data e hora atual.
        StorageReference imagemRef = imagens.child(nomeArquivo);

        //Retorna obj que irá controlar o storageUpload
        UploadTask uploadTask = imagemRef.putBytes(dadosImagem);

        //Verifica sucesso ou erro.
        uploadTask.addOnSuccessListener(FirebaseTeste.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri url = taskSnapshot.getUploadSessionUri();
                Toast.makeText(FirebaseTeste.this, "Sucesso ao enviar imagem..." + url.toString(), Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(FirebaseTeste.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FirebaseTeste.this, "Erro ao enviar imagem..." + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void storageDeletar(View view) {

        StorageReference imagens = storage.child("imagens");            //Recupera a pasta de imagens.
        StorageReference imagemRef = imagens.child("celular.jpeg");     //Recupera a ref. para o arquivo que será deletado.

        //Deleta a imagem e verifica sucesso ou erro...
        imagemRef.delete().addOnSuccessListener(FirebaseTeste.this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(FirebaseTeste.this, "Sucesso ao deletar imagem...", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(FirebaseTeste.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FirebaseTeste.this, "Erro ao deletar imagem..." + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void storageDownlaod(View view) {

        imgUpload = findViewById(R.id.img_upload);

        StorageReference imagens = storage.child("imagens");            //Recupera a pasta de imagens.
        StorageReference imagemRef = imagens.child("celular.jpeg");     //Recupera a ref. para o arquivo que será baixado.

        Glide.with(FirebaseTeste.this)
                .using(new FirebaseImageLoader())
                .load(imagemRef)
                .into(imgUpload);

    }

}
