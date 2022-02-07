package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Teste;


import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Comprador;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteJDBC {

    public static void main(String[] args) {
        
        //Testes de conexão//
        Connection conexao = ConexaoFactory.abrirConexao(); //abre a conexão
        //ConexaoFactory.fecharConexao(conexao);              //fecha a conexão
        
        //Testes Firebird
        //Connection conexaoFirebird = ConexaoFactory.abrirConexaoFireBird();
        
        //Testes manipulação dados//
        List<Comprador> listaCompradores = new ArrayList<>();
        listaCompradores.add(new Comprador("Douglas", "347.202.728.27"));
        listaCompradores.add(new Comprador("Caroline", "442.132.551.47"));
        listaCompradores.add(new Comprador("Adriano", "342.932.581.12"));

        //Salvar
        //CompradorDB.salvar(listaCompradores.get(2));
        //Deletar
        //listaCompradores.get(1).setId(3);
        //CompradorDB.deletar(listaCompradores.get(1));
        //Atualizar
        //listaCompradores.get(1).setId(3);
        //CompradorDB.atualizar(listaCompradores.get(1));
        //Selecionar Todos
        //System.out.println(CompradorDBOLD.selecionarTodos());
        //Selecionar por Nome/Contém
        //System.out.println(CompradorDBOLD.selecionarPorNomeContem("Ad"));
        //Teste busca Metadados.
        //CompradorDB.selecionarMetaDados();
        //Testes Gerais
        //CompradorDB.checarDriverStatus();
        //CompradorDB.testeTypeScroll();
        //CompradorDB.manipularDadosComResultSet();                                                     //Atualizar, Inserir e Deletar
        //System.out.println(CompradorDBOLD.selecionarPorNomeContemPreparedStatement("as"));               //Busca com Prepared Statement
        //CompradorDB.atualizarPreparedStetament(new Comprador(1, "PS da Silva", "321.321.321-21"));    //Atualizar com PreparedStatement
        //System.out.println(CompradorDBOLD.selecionarPorNomeContemCallableStatement(""));                 //Busca com CallableStatemente (para procedure)
        //System.out.println(CompradorDBOLD.selecionarPorNomeRowSet("lu"));                                //Busca com RowSet
        //CompradorDB.atualizarRowSet(new Comprador(1, "JRS da Silva", "321.321.321-21"));              //Atualizar com RowSet
        //CompradorDB.atualizarRowSetCached(new Comprador(1, "RowSetCached", "321.321.321-21"));        //Atualizar com RowSetCached
        
        //Salvando com Transaction:
        //try {
        //    CompradorDBOLD.salvarTransaction();
        //} catch (SQLException ex) {
        //    Logger.getLogger(TesteJDBC.class.getName()).log(Level.SEVERE, null, ex);
        //}

    }

}
