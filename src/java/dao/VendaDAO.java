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
import model.Venda;

public class VendaDAO {

    public static ArrayList<Venda> obterVendas() throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        ArrayList<Venda> vendas = new java.util.ArrayList<Venda>();
        Venda venda = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from venda");

            while (rs.next()) {
                venda = instanciarVenda(rs);
                vendas.add(venda);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return vendas;
    }

    public static Venda obterVenda(int idVenda) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        Venda venda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from venda where idVenda=" + idVenda);
            rs.first();
            venda = instanciarVenda(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return venda;
    }

    private static Venda instanciarVenda(ResultSet rs) throws SQLException {
        Venda venda = new Venda(rs.getInt("idVenda"),
                rs.getString("dataVenda"),
                rs.getFloat("subTotal"),
                rs.getInt("codBarra"),
                rs.getFloat("valorDesconto"),
                rs.getString("situacao"),
                null,
                null,
                null);
        venda.setIdUsuario(rs.getInt("idUsuario"));
        venda.setIdFormaPgto(rs.getInt("idFormaPgto"));
        venda.setIdCliente(rs.getInt("idCliente"));
        return venda;
    }

    public static void gravar(Venda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into venda (idVenda, dataVenda, subTotal, codBarra,"
                    + "valorDesconto, situacao, idCliente, idUsuario, idFormaPgto)"
                    + "values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, venda.getIdVenda());
            comando.setString(2, venda.getDataVenda());
            comando.setFloat(3, venda.getSubTotal());
            comando.setInt(4, venda.getCodBarra());
            comando.setFloat(5, venda.getValorDesconto());
            comando.setString(6, venda.getSituacao());
            if (venda.getCliente() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, venda.getCliente().getIdCliente());
            }
            if (venda.getUsuario() == null) {
                comando.setNull(8, Types.INTEGER);
            } else {
                comando.setInt(8, venda.getUsuario().getIdUsuario());
            }
            if (venda.getFormaPagamento() == null) {
                comando.setNull(9, Types.INTEGER);
            } else {
                comando.setInt(9, venda.getFormaPagamento().getIdFormaPgto());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Venda venda) throws ClassNotFoundException,
            SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from perdaDevolucao where idVenda = "
                    + venda.getIdVenda();
            comando.execute(stringSQL);
            
        } finally {
            fecharConexao(conexao, comando);
        }
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from itensVenda where idVenda = " + 
                    venda.getIdVenda();
            comando.execute(stringSQL);
            
        } finally {
            fecharConexao(conexao, comando);
        }
        
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from venda where idVenda = "
                    + venda.getIdVenda();
            comando.execute(stringSQL);
            
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Venda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update venda set "
                    + "dataVenda = '" + venda.getDataVenda() + "',"
                    + "subtotal = " + venda.getSubTotal() + ","
                    + "codBarra = " + venda.getCodBarra() + ","
                    + "valorDesconto = " + venda.getValorDesconto() + ","
                    + "situacao = '" + venda.getSituacao() + "',"
                    + "idCliente = ";
            if (venda.getCliente() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + venda.getCliente().getIdCliente();
            }

            stringSQL = stringSQL + ", idUsuario = ";
            if (venda.getUsuario() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + venda.getUsuario().getIdUsuario();
            }

            stringSQL = stringSQL + ", idFormaPgto = ";
            if (venda.getFormaPagamento() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + venda.getFormaPagamento().getIdFormaPgto();
            }

            stringSQL = stringSQL + " where idVenda = " + venda.getIdVenda();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
