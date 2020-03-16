/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import model.PerdaDevolucao;

public class PerdaDevolucaoDAO {

    public static List<PerdaDevolucao> obterPerdaDevolucoes() throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<PerdaDevolucao> perdas = new java.util.ArrayList<PerdaDevolucao>();
        PerdaDevolucao perdaDevolucao = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from perdaDevolucao");

            while (rs.next()) {
                perdaDevolucao = instanciarPerdaDevolucao(rs);
                perdas.add(perdaDevolucao);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return perdas;
    }

    public static PerdaDevolucao obterPerdaDevolucao(int idPerdaDevolucao) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        PerdaDevolucao perdaDevolucao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from "
                    + "perdaDevolucao where idPerdaDevolucao = "
                    + idPerdaDevolucao);
            rs.first();
            perdaDevolucao = instanciarPerdaDevolucao(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return perdaDevolucao;
    }

    private static PerdaDevolucao instanciarPerdaDevolucao(ResultSet rs) throws SQLException {
        PerdaDevolucao perdaDevolucao = new PerdaDevolucao(rs.getInt("idPerdaDevolucao"),
                rs.getString("tipo"),
                null,
                null);
        perdaDevolucao.setIdVenda(rs.getInt("idVenda"));
        perdaDevolucao.setIdProduto(rs.getInt("idProduto"));
        return perdaDevolucao;
    }

    public static void gravar(PerdaDevolucao perdaDevolucao) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into perdaDevolucao (idPerdaDevolucao, tipo, "
                    + "idVenda, idProduto) values (?,?,?,?)");
            comando.setInt(1, perdaDevolucao.getIdPerdaDevolucao());
            comando.setString(2, perdaDevolucao.getTipo());
            if (perdaDevolucao.getVenda() == null) {
                comando.setNull(3, Types.INTEGER);
            } else {
                comando.setInt(3, perdaDevolucao.getVenda().getIdVenda());
            }
            if (perdaDevolucao.getVenda() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, perdaDevolucao.getProduto().getIdProduto());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(PerdaDevolucao perdaDevolucao) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from perdaDevolucao where idPerdaDevolucao = "
                    + perdaDevolucao.getIdPerdaDevolucao();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(PerdaDevolucao perdaDevolucao) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update perdaDevolucao set "
                    + "tipo='" + perdaDevolucao.getTipo() + "',"
                    + "idVenda = ";
            if (perdaDevolucao.getVenda() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + perdaDevolucao.getVenda().getIdVenda();
            }
            stringSQL = stringSQL + " where idPerdaDevolucao = " + perdaDevolucao.getIdPerdaDevolucao();
            comando.execute(stringSQL);
            
            stringSQL = "update perdaDevolucao set "
                    + "idProduto = ";
            if (perdaDevolucao.getProduto() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + perdaDevolucao.getProduto().getIdProduto();
            }
            stringSQL = stringSQL + " where idPerdaDevolucao = " + perdaDevolucao.getIdPerdaDevolucao();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
