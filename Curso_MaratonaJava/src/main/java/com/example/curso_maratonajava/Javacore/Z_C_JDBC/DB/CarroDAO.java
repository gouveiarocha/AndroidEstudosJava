package com.example.curso_maratonajava.Javacore.Z_C_JDBC.DB;


import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Carro;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Classes.Comprador;
import com.example.curso_maratonajava.Javacore.Z_C_JDBC.Conexao.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    
    public static void salvar(Carro carro) {

        String sql = "INSERT INTO `agencia`.`carro` (`placa`, `nome`, comprador_id) VALUES (?, ?, ?);";

        try (Connection conn = ConexaoFactory.abrirConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, carro.getComprador().getId());
            ps.executeUpdate();

            System.out.println("INSERIDO COM SUCESSO!!!" + "[" + carro.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void atualizar(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("ERRO AO ATUALIZAR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "UPDATE `agencia`.`carro` SET `placa` = ?, `nome` = ? WHERE `id_carro` = ?";

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getNome());
            ps.setInt(3, carro.getId());
            ps.executeUpdate();

            System.out.println("ATUALIZADO COM SUCESSO!!!" + "[" + carro.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void deletar(Carro carro) {
        if (carro == null || carro.getId() == null) {
            System.out.println("ERRO AO EXCLUIR, O REGISTRO NÃO POSSUI ID");
            return;
        }

        String sql = "DELETE FROM `agencia`.`carro` WHERE `id_carro` = ?";

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, carro.getId());
            ps.executeUpdate();

            System.out.println("EXCLUIDO COM SUCESSO!!!" + "[" + carro.toString() + "]");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Carro> selecionarPorNomeContem(String chave) {

        String sql = "SELECT id_carro, placa, nome, comprador_id FROM agencia.carro WHERE nome LIKE ?";
        List<Carro> carroList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + chave + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comprador c = CompradorDAO.selecionarPorId(rs.getInt("comprador_id"));
                carroList.add(new Carro(rs.getInt("id_carro"), rs.getString("placa"), rs.getString("nome"), c));
            }
            ConexaoFactory.fecharConexao(conn, ps, rs);
            return carroList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Carro> selecionarTodos() {

        String sql = "SELECT id_carro, placa, nome, comprador_id FROM agencia.carro";
        List<Carro> carroList = new ArrayList<>();

        try (Connection conn = ConexaoFactory.abrirConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comprador c = CompradorDAO.selecionarPorId(rs.getInt("comprador_id"));
                carroList.add(new Carro(rs.getInt("id_carro"), rs.getString("placa"), rs.getString("nome"), c));
            }
            return carroList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
