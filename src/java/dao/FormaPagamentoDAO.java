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
import java.util.List;
import model.FormaPagamento;

public class FormaPagamentoDAO {
    
    public static List<FormaPagamento> obterFormasPagamentos() throws ClassNotFoundException, SQLException{
        
        Connection conexao =null;
        Statement comando = null;
        List<FormaPagamento> formasPagamento = new java.util.ArrayList<FormaPagamento>();
        FormaPagamento formaPagamento = null;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from formaPagamento");
            
            while (rs.next()){
                formaPagamento = instaciarFormaPagamento(rs);
                formasPagamento.add(formaPagamento);
            }
            }finally{
                    fecharConexao(conexao, comando);
                    
                    }
            return formasPagamento;
    
}
     public static FormaPagamento obterFormaPagamento(int idFormaPgto) throws SQLException, ClassNotFoundException{
     
            Connection conexao = null;
            Statement comando = null;
            FormaPagamento formaPagamento = null;
            try{
                conexao = BD.getConexao();
                comando = conexao.createStatement();
                ResultSet rs = comando.executeQuery("select * from formaPagamento where idFormaPgto = " + idFormaPgto);
                rs.first();
                formaPagamento = instaciarFormaPagamento(rs);
            } finally{
                fecharConexao(conexao, comando);
            }
            return formaPagamento;
    }


    private static FormaPagamento instaciarFormaPagamento(ResultSet rs) throws SQLException {
        FormaPagamento pagamento = new FormaPagamento(rs.getInt("idFormaPgto"),
        rs.getString("nome"),
        rs.getInt("conta"),
        rs.getInt("agencia"),
        rs.getString("nomeBanco"),
        rs.getString("tipoConta"),
        rs.getInt("numMaxParcelas"),
        rs.getInt("intervaloParcelas"),
        rs.getDouble("taxaBanco"),
        rs.getDouble("taxaOperadora"),
        rs.getDouble("multaAtraso"),
        rs.getString("situacaoConfirmacao"));
        return pagamento;
    }
    
    public static void gravar(FormaPagamento formaPagamento) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into formaPagamento (idFormaPgto, nome, conta, "
                            + "agencia, nomeBanco, tipoConta, numMaxParcelas, "
                            + "intervaloParcelas, taxaBanco, taxaOperadora, "
                            + "multaAtraso, situacaoConfirmacao) values "
                            + "(?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, formaPagamento.getIdFormaPgto());
            comando.setString(2, formaPagamento.getNome());
            comando.setInt(3, formaPagamento.getConta());
            comando.setInt(4, formaPagamento.getAgencia());
            comando.setString(5, formaPagamento.getNomeBanco());
            comando.setString(6, formaPagamento.getTipoConta());
            comando.setInt(7, formaPagamento.getNumMaxParcelas());
            comando.setInt(8, formaPagamento.getIntervaloParcelas());
            comando.setDouble(9, formaPagamento.getTaxaBanco());
            comando.setDouble(10, formaPagamento.getTaxaOperadora());
            comando.setDouble(11, formaPagamento.getMultaAtraso());
            comando.setString(12, formaPagamento.getSituacaoConfirmacao());
            
            comando.executeUpdate();
        }
        finally{
            fecharConexao(conexao, comando);
        }
    }
    
        public static void excluir(FormaPagamento formaPagamento) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from formaPagamento where idFormaPgto = " +
                     formaPagamento.getIdFormaPgto();
            comando.execute(stringSQL);
        }finally{
            fecharConexao(conexao, comando);
        }
    }
        
        public static void alterar(FormaPagamento formaPagamento) throws ClassNotFoundException, SQLException{
            Connection conexao = null;
            Statement comando = null;
            String stringSQL;
            
            try{
                conexao = BD.getConexao();
                comando = conexao.createStatement();
                stringSQL = "update formaPagamento set " 
                        + "nome = '" + formaPagamento.getNome() + "',"
                        + "conta = '" + formaPagamento.getConta() + "',"
                        + "agencia = '" + formaPagamento.getAgencia() + "',"
                        + "nomeBanco = '" + formaPagamento.getNomeBanco() + "',"
                        + "tipoConta = '" + formaPagamento.getTipoConta() + "',"
                        + "numMaxParcelas = '" + formaPagamento.getNumMaxParcelas() + "',"
                        + "intervaloParcelas = '" + formaPagamento.getIntervaloParcelas() + "',"
                        + "taxaBanco = '" + formaPagamento.getTaxaBanco() + "',"
                        + "taxaOperadora = '" + formaPagamento.getTaxaOperadora() + "',"
                        + "multaAtraso = '" + formaPagamento.getMultaAtraso() + "',"
                        + "situacaoConfirmacao = '" + formaPagamento.getSituacaoConfirmacao() + "'";
                stringSQL = stringSQL + " where idFormaPgto = " + formaPagamento.getIdFormaPgto();
                comando.execute(stringSQL);
            }finally{
                fecharConexao(conexao, comando);
            }
        }
}
