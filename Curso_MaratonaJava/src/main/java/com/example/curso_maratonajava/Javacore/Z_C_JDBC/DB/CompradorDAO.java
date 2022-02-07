package com.example.curso_maratonajava.Javacore.Z_C_JDBC.DB;

import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Comprador;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompradorDAO {

    public static void salvar(Comprador comprador) {

        String sql = "INSERT INTO `agencia`.`comprador` (`nome`, `cpf`) VALUES (?, ?);";

        try (Connection conn = ConexaoFactory.abrirConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, comprador.getNome());
            ps.setString(2, comprador.getCpf());
            ps.executeUpdate();

            System.out.println("INSERIDO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void atualizar(Comprador comprador) {
        if (comprador == null || comprador.getId() == null) {
            System.out.println("ERRO AO ATUALIZAR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "UPDATE `agencia`.`comprador` SET `nome` = ?, `cpf` = ? WHERE `id_comprador` = ?";

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, comprador.getNome());
            ps.setString(2, comprador.getCpf());
            ps.setInt(3, comprador.getId());
            ps.executeUpdate();

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

        String sql = "DELETE FROM `agencia`.`comprador` WHERE `id_comprador` = ?";

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, comprador.getId());
            ps.executeUpdate();

            System.out.println("EXCLUIDO COM SUCESSO!!!" + "[" + comprador.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Comprador> selecionarPorNomeContem(String chave) {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador WHERE nome LIKE ?";
        List<Comprador> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + chave + "%");
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
    
    public static Comprador selecionarPorId(Integer id) {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador WHERE id_comprador=?";
        Comprador comprador = null;

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comprador = new Comprador(rs.getInt("id_comprador"), rs.getString("nome"), rs.getString("cpf"));
            }
            ConexaoFactory.fecharConexao(conn, ps, rs);
            return comprador;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Comprador> selecionarTodos() {

        String sql = "SELECT id_comprador, nome, cpf FROM agencia.comprador";
        List<Comprador> compradorList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                compradorList.add(new Comprador(rs.getInt("id_comprador"), rs.getString("nome"), rs.getString("cpf")));
            }
            return compradorList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
