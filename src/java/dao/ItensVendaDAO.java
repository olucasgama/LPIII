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
import model.ItemVenda;

public class ItensVendaDAO {

    public static ArrayList<ItemVenda> obterItensVendas()
            throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        ArrayList<ItemVenda> itensVendas = new java.util.ArrayList<ItemVenda>();
        ItemVenda itensVenda = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itensVenda "
                    + "join venda on itensVenda.idVenda = venda.idVenda");
            while (rs.next()) {
                itensVenda = instaciarItensVenda(rs);
                itensVendas.add(itensVenda);
            }
        } finally {
            fecharConexao(conexao, comando);

        }
        return itensVendas;

    }

    public static ArrayList<ItemVenda> obterItensVenda(int idVenda) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        ArrayList<ItemVenda> itensVendas = new java.util.ArrayList<ItemVenda>();
        ItemVenda itensVenda = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itensVenda "
                    + "join venda on itensVenda.idVenda = venda.idVenda "
                    + "where venda.idVenda = " + idVenda);
            while (rs.next()) {
                itensVenda = instaciarItensVenda(rs);
                itensVendas.add(itensVenda);
            }
        } finally {
            fecharConexao(conexao, comando);

        }
        return itensVendas;
    }

    public static ItemVenda obterItemVenda(int idItensVenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ItemVenda itemVenda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itensVenda where"
                    + " itensVenda.idItensVenda = " + idItensVenda);
            rs.first();
            itemVenda = instaciarItensVenda(rs);
        } finally {
            fecharConexao(conexao, comando);

        }
        return itemVenda;
    }

    private static ItemVenda instaciarItensVenda(ResultSet rs) throws SQLException {
        ItemVenda itensVenda = new ItemVenda(rs.getInt("idItensVenda"),
                rs.getInt("quantidade"),
                rs.getFloat("precoUnitario"),
                null,
                null);
        itensVenda.setIdVenda(rs.getInt("idVenda"));
        itensVenda.setIdProduto(rs.getInt("idProduto"));

        return itensVenda;
    }

    public static void gravar(ItemVenda itensVenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into itensVenda (idItensVenda, quantidade, precoUnitario,"
                    + "idVenda, idProduto)"
                    + "values (?,?,?,?,?)");
            comando.setInt(1, itensVenda.getIdItensVenda());
            comando.setInt(2, itensVenda.getQuantidade());
            comando.setFloat(3, itensVenda.getPrecoUnitario());

            if (itensVenda.getVenda() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, itensVenda.getVenda().getIdVenda());
            }
            if (itensVenda.getProduto() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, itensVenda.getProduto().getIdProduto());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(ItemVenda itensVenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from itensVenda where idItensVenda = "
                    + itensVenda.getIdItensVenda();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(ItemVenda itensVenda) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update itensVenda set "
                    + "precoUnitario = " + itensVenda.getPrecoUnitario() + ","
                    + "quantidade = " + itensVenda.getQuantidade() + ","
                    + "idProduto = ";
            if (itensVenda.getProduto() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + itensVenda.getProduto().getIdProduto();
            }
            stringSQL = stringSQL + " where idItensVenda = " + itensVenda.getIdItensVenda();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
