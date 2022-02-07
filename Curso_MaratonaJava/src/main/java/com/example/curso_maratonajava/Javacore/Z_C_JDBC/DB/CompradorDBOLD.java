package com.example.curso_maratonajava.Javacore.Z_C_JDBC.DB;

import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Comprador;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.MeuRowSetListener;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Conexao.ConexaoFactory;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Savepoint;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

public class CompradorDBOLD {

    public static void salvar(Comprador comprador) {

        String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('" + comprador.getNome() + "', '" + comprador.getCpf() + "');";

        Connection conn = ConexaoFactory.abrirConexao();    //cria um obj Connection e abre conexão...
        try {
            Statement stmt = conn.createStatement();        //cria um obj Statement
            stmt.executeUpdate(sql);                        //o Statement executa o comando sql no banco de dados
            ConexaoFactory.fecharConexao(conn, stmt);       //fecha a Connection e a Statement

            System.out.println("INSERIDO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void salvarTransaction() throws SQLException {

        String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('TESTE1', 'TESTE1');";
        String sql2 = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('TESTE2', 'TESTE2');";
        String sql3 = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES ('TESTE3', 'TESTE3');";
        
        Connection conn = ConexaoFactory.abrirConexao();
        Savepoint savepoint = null;
        try {
            conn.setAutoCommit(false);                  //Inicia uma transaction. Informa para o banco não comitar automaticamente.
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            savepoint = conn.setSavepoint("One"); //Salvar até um determinado ponto, antes do erro - utilizando o Savepoint
            stmt.executeUpdate(sql2);
            //Com o erro abaixo, independente se commitamos, não vai inserir no BD - pois houve um erro no meio do caminho.
            if(true)
                throw new SQLException();
            stmt.executeUpdate(sql3);
            conn.commit();                              //Efetiva as alterações no banco.
            ConexaoFactory.fecharConexao(conn, stmt);

            System.out.println("INSERIDO COM SUCESSO!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            //conn.rollback(); //Volta o estado anterior, antes de fazer essa transaction, antes do comando conn.setAutoCommit(false);
            conn.rollback(savepoint);   //Volta a um savepoint
            conn.commit();
        }
        
    }

    public static void atualizar(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("ERRO AO ATUALIZAR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "UPDATE `agencia`.`comprador` SET `nome` = '" + comprador.getNome() + "', `cpf` = '" + comprador.getCpf() + "' WHERE (`id_comprador` = '3');";

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.fecharConexao(conn, stmt);

            System.out.println("ATUALIZADO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void atualizarPreparedStetament(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("ERRO AO ATUALIZAR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "UPDATE `agencia`.`comprador` SET `nome` = ?, `cpf` = ? WHERE `id_comprador` = ?";

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, comprador.getNome());               //Nome
            ps.setString(2, comprador.getCpf());                //CPF
            ps.setInt(3, comprador.getId());                    //ID
            ps.executeUpdate();
            ConexaoFactory.fecharConexao(conn, ps);

            System.out.println("ATUALIZADO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void atualizarRowSet(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("ERRO AO ATUALIZAR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        //String sql = "UPDATE `agencia`.`comprador` SET `nome` = ?, `cpf` = ? WHERE `id_comprador` = ?";
        String sql = "SELECT * FROM COMPRADOR WHERE ID_COMPRADOR = ?";
        
        JdbcRowSet jrs = ConexaoFactory.abrirConexaoRowSet();
        jrs.addRowSetListener(new MeuRowSetListener());
        try {
            jrs.setCommand(sql);
            jrs.setInt(1, comprador.getId());
            jrs.execute();
            jrs.next();
            jrs.updateString("nome", comprador.getNome());
            jrs.updateRow();
            ConexaoFactory.fecharConexao(jrs);

            System.out.println("ATUALIZADO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void atualizarRowSetCached(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("ERRO AO ATUALIZAR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "SELECT * FROM COMPRADOR WHERE ID_COMPRADOR = ?";
        
        CachedRowSet crs = ConexaoFactory.abrirConexaoRowSetCached();
        try {
            crs.setCommand(sql);
            crs.setInt(1, comprador.getId());
            crs.execute();
            crs.next();
            crs.updateString("nome", comprador.getNome());
            crs.updateRow();
            crs.acceptChanges();

            System.out.println("ATUALIZADO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void deletar(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("ERRO AO EXCLUIR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id_comprador` = '" + comprador.getId() + "'";

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConexaoFactory.fecharConexao(conn, stmt);

            System.out.println("EXCLUIDO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Comprador> selecionarTodos() {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador";
        List<Comprador> compradorList = new ArrayList<>();

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);      //cria um obj ResultSet
            while (rs.next()) {                         //retorna cada linha no banco de dados
                //Abaixo, usamos o get(de acordo com o tipo de dado) para recuperar o dado e passamos no construtor da classe Comprador.
                compradorList.add(new Comprador(rs.getInt("id_comprador"), rs.getString("nome"), rs.getString("cpf")));
                //System.out.println(""
                //+ rs.getInt("id_comprador") + " - "
                //+ rs.getString("nome") + " - "
                //+ rs.getString("cpf"));
            }
            ConexaoFactory.fecharConexao(conn, stmt, rs);   //fecha a Connection, o Statement e o ResultSet
            return compradorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> selecionarPorNomeContem(String chave) {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador WHERE nome LIKE '%" + chave + "%'";
        List<Comprador> compradorList = new ArrayList<>();

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id_comprador"), rs.getString("nome"), rs.getString("cpf")));
            }
            ConexaoFactory.fecharConexao(conn, stmt, rs);
            return compradorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> selecionarPorNomeContemPreparedStatement(String chave) {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";     //Para o PreparedStatement, usar o carcter coringa no lugar da String
        List<Comprador> compradorList = new ArrayList<>();

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);    //Usando o PreparedStatement
            ps.setString(1, "%" + chave + "%");     //Vamos executar um setString passando o caracter coringa no 1par e o valor no 2par
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id_comprador"), rs.getString("nome"), rs.getString("cpf")));
            }
            ConexaoFactory.fecharConexao(conn, ps, rs);
            return compradorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Usando CallableStatement para procedures do BD.
    public static List<Comprador> selecionarPorNomeContemCallableStatement(String chave) {

        String sql = "CALL `agencia`.`SP_GetComrpadoresPorNome`( ? );";
        List<Comprador> compradorList = new ArrayList<>();

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, "%" + chave + "%");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id_comprador"), rs.getString("nome"), rs.getString("cpf")));
            }
            ConexaoFactory.fecharConexao(conn, cs, rs);
            return compradorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Método utilizando RowSet
    public static List<Comprador> selecionarPorNomeRowSet(String chave) {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";
        List<Comprador> compradorList = new ArrayList<>();

        JdbcRowSet jrs = ConexaoFactory.abrirConexaoRowSet();
        jrs.addRowSetListener(new MeuRowSetListener());
        try {
            jrs.setCommand(sql);
            jrs.setString(1, "%" + chave + "%");
            jrs.execute();
            while (jrs.next()) {
                compradorList.add(new Comprador(jrs.getInt("id_comprador"), jrs.getString("nome"), jrs.getString("cpf")));
            }
            ConexaoFactory.fecharConexao(jrs);
            return compradorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void selecionarMetaDados() {
        String sql = "SELECT * FROM agencia.comprador";
        Connection conn = ConexaoFactory.abrirConexao();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //Recuperar Meta Dados
            ResultSetMetaData rsmd = rs.getMetaData();      //cria obj ResultSetMetaData
            rs.next();                                      //vamos pegar apenas o 1º registro
            int qtdColunas = rsmd.getColumnCount();         //recupera a quantidade de colunas
            System.out.println("Quantidade de colunas tabela: " + qtdColunas);
            for (int i = 1; i <= qtdColunas; i++) {
                System.out.println("Tabela: " + rsmd.getTableName(i));                  //nome tabela
                System.out.println("Nome Coluna: " + rsmd.getColumnName(i));            //nome coluna
                System.out.println("Tamano Coluna: " + rsmd.getColumnDisplaySize(i));   //tamanho coluna
            }
            ConexaoFactory.fecharConexao(conn, stmt, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void checarDriverStatus() {

        //TYPE_FORWARD_ONLY - É quando o ResultSet só faz a busca de cima para baixo.
        //CONCUR_READ_ONLY  - Se é possivel alterar ou atualizar o registro apenas com o ResultSet(sem o sql)
        //CONCUR_UPDATABLE  - Se é possivel alterar ou atualizar o registro apenas com o ResultSet(sem o sql)
        //TYPE_SCROLL_INSENSITIVE - Ver explicação video aula 146
        //TYPE_SCROLL_SENSITIVE - ver explicação video aula 146
        Connection conn = ConexaoFactory.abrirConexao();
        try {

            DatabaseMetaData dbmd = conn.getMetaData();     //vamos pegar o MetaData diretamente a partir da conexão.

            if (dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {   //verificar se o driver suporta
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Também suporta TYPE_FORWARD_ONLY");
                }
            }
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {   //verificar se o driver suporta
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Também suporta TYPE_FORWARD_ONLY");
                }
            }
            if (dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {   //verificar se o driver suporta
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if (dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("Também suporta TYPE_FORWARD_ONLY");
                }
            }
            ConexaoFactory.fecharConexao(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void testeTypeScroll() {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador";

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            //Deve funcionar sem, mas é recomendavel passar para o Statement o suporte TYPE_SCROLL_INSENSITIVE e CONCUR_UPDATABLE. 
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);

            //Movendo o cursor - Navegando entre as linhas da tabela...
            System.out.println("Retornou para 1º linha    : " + rs.first() + " -> " + rs.getString("nome") + " - " + "Linha: " + rs.getRow());
            System.out.println("Retornou para última linha: " + rs.last() + " -> " + rs.getString("nome") + " - " + "Linha: " + rs.getRow());
            System.out.println("Vai para a linha informada: " + rs.absolute(5) + " -> " + rs.getString("nome"));

            //O relative vai mover baseado na linha em que esta... EX:           
            rs.absolute(2);     //Vamos para a linha 2 com o absolute...
            rs.relative(2);     //Avançamos duas linhas relativas a linha 2...
            rs.relative(-1);    //Volramos uma linha relativa a linha 4...
            System.out.println("Relative: " + rs.getString("nome")); //Deve imprimir a linha 4...

            System.out.println("Verifica se esta na 1º linha    : " + rs.isFirst());
            System.out.println("Verifica se esta na última linha: " + rs.isLast());

            //Como fazer um while inverso(da última para a primeira linha) usando o previous, que volta uma linha...
            System.out.println("Recuperando todas as linhas na ordem inversa com previous():");
            rs.last();      //Se usarmos o last, o while abaixo vai pular o último registro, pois o previous pega uma linha anterior.
            rs.afterLast(); //Resolvemos isso apontando para depois do último... Assim o While vai pegar todas as linhas...

            while (rs.previous()) {
                System.out.println(" -> " + rs.getString("nome"));
            }

            ConexaoFactory.fecharConexao(conn, stmt, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Alterando registros diretamente com o ResultSet
    public static void manipularDadosComResultSet() {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador";

        Connection conn = ConexaoFactory.abrirConexao();
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("-----Atualizando todos os nomes para LowerCase-----");
            while (rs.next()) {
                rs.updateString("nome", rs.getString("nome").toLowerCase());
                //rs.cancelRowUpdates();
                rs.updateRow();
            }
            rs.beforeFirst();
            System.out.println("Imprimindo dados alterados para LowerCase: ");
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }

            System.out.println("\n-----Atualizando apenas o primeiro registro para UpperCase-----");
            rs.first();
            rs.updateString("nome", rs.getString("nome").toUpperCase());
            rs.updateRow();
            rs.beforeFirst();
            System.out.println("Imprimindo dados com o primeiro registro em UpperCase: ");
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }

            //System.out.println("\n-----Inserindo um novo registro-----");
            //rs.moveToInsertRow();                       //cria um registro temporario no banco
            //System.out.println(rs.getString("nome"));   //deve imprimir null, apenas criamos registro temporario mas não há nada.
            //rs.updateString("nome", "Caio");            //atualiza o nome
            //rs.updateString("cpf", "899.899.899-99");   //atualiza o cpf
            //rs.insertRow();                             //insere a linha
            //System.out.println(rs.getString("nome") + " - Linha: " + rs.getRow());
            System.out.println("\n-----Deletando um registro-----");
            rs.absolute(8);
            rs.deleteRow();

            ConexaoFactory.fecharConexao(conn, stmt, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
