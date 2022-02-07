package com.example.curso_maratonajava.Javacore.Z_C_JDBC.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConexaoFactory {

    //java.slq = Connection[comandos de conexão], Statement[comandos de alteração], ResultSet[comandos de recuperação]
    //DriverManager[driver de conexão]
    public static Connection abrirConexao() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false"; //A url traduz para o java o tipo de connector que será utilizado, neste caso, mysql
        String user = "root";
        String password = "root";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Conexão utilizando RowSet
    public static JdbcRowSet abrirConexaoRowSet() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false";
        String user = "root";
        String password = "root";
        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername(user);
            jdbcRowSet.setPassword(password);
            
            return jdbcRowSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Conexão utilizando RowSetCached
    public static CachedRowSet abrirConexaoRowSetCached() {
        String url = "jdbc:mysql://localhost:3306/agencia?useSSL=false&relaxAutoCommit=true";
        String user = "root";
        String password = "root";
        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setUrl(url);
            cachedRowSet.setUsername(user);
            cachedRowSet.setPassword(password);
            
            return cachedRowSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    //Meu teste de abrir conexão...
    public static Connection abrirConexaoFireBird() {
        //String url = "jdbc:firebirdsql://localhost:3050//opt/firebird/outrobd.fdb";
        String url = "jdbc:firebirdsql://localhost:3050/C:\\douglas\\MEUBD.fdb";
        String user = "SYSDBA";
        String password = "masterkey";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar...");
            ex.printStackTrace();
        }
        return null;
    }

    public static void fecharConexao(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void fecharConexao(RowSet jrs) {
        try {
            if (jrs != null) {
                jrs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void fecharConexao(Connection connection, Statement stmt) {
        fecharConexao(connection);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void fecharConexao(Connection connection, Statement stmt, ResultSet rs) {
        fecharConexao(connection, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
