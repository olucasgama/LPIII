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
import java.util.ArrayList;
import java.util.List;
import model.OrdemServico;

public class OrdemServicoDAO {

    public static ArrayList<OrdemServico> obterOrdemServicos() throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        ArrayList<OrdemServico> ordemServicos = new java.util.ArrayList<OrdemServico>();
        OrdemServico ordemServico = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from ordemServico");

            while (rs.next()) {
                ordemServico = instanciarOrdemServico(rs);
                ordemServicos.add(ordemServico);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return ordemServicos;
    }

    public static OrdemServico obterOrdemServico(int idOrdemSrv) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        OrdemServico ordemServico = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from ordemServico where idOrdemSrv = " + idOrdemSrv);
            rs.first();
            ordemServico = instanciarOrdemServico(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return ordemServico;
    }

    private static OrdemServico instanciarOrdemServico(ResultSet rs) throws SQLException {
        OrdemServico ordemServico = new OrdemServico(rs.getInt("idOrdemSrv"),
                rs.getString("dataPedido"),
                rs.getString("situacao"),
                rs.getString("descricao"),
                rs.getInt("numOS"),
                null);
        ordemServico.setIdFornecedor(rs.getInt("idFornecedor"));

        return ordemServico;
    }

    public static void gravar(OrdemServico ordemServico) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into ordemServico (idOrdemSrv, dataPedido, situacao,"
                    + "descricao, numOS, idFornecedor)"
                    + "values (?,?,?,?,?,?)");
            comando.setInt(1, ordemServico.getIdOrdemSrv());
            comando.setString(2, ordemServico.getDataPedido());
            comando.setString(3, ordemServico.getSituacao());
            comando.setString(4, ordemServico.getDescricao());
            comando.setInt(5, ordemServico.getNumOS());
            if (ordemServico.getFornecedor() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, ordemServico.getFornecedor().getIdFornecedor());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(OrdemServico ordemServico) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from itensOrdem where idOrdemSrv = " + ordemServico.getIdOrdemSrv();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from ordemServico where idOrdemSrv = " + ordemServico.getIdOrdemSrv();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
        
    }

    public static void alterar(OrdemServico ordemServico) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update ordemServico set "
                    + "numOS = " + ordemServico.getNumOS() + ","
                    + "descricao = '" + ordemServico.getDescricao() + "',"
                    + "dataPedido = '" + ordemServico.getDataPedido() + "',"
                    + "situacao = '" + ordemServico.getSituacao() + "',"
                    + "idFornecedor = ";
            if (ordemServico.getFornecedor() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + ordemServico.getFornecedor().getIdFornecedor();
            }
            stringSQL = stringSQL + " where idOrdemSrv = " + ordemServico.getIdOrdemSrv();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
