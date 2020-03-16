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
import model.Fornecedor;

public class FornecedorDAO {
    public static List<Fornecedor> obterFornecedores() 
            throws ClassNotFoundException, SQLException{
        
        Connection conexao =null;
        Statement comando = null;
        List<Fornecedor> fornecedores = new java.util.ArrayList<Fornecedor>();
        Fornecedor fornecedor = null;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from fornecedor");
            
            while (rs.next()){
                fornecedor = instanciarFornecedor(rs);
                fornecedores.add(fornecedor);
            }
            }finally{
                    fecharConexao(conexao, comando);
                    
                    }
            return fornecedores;
    
}
     public static Fornecedor obterFornecedor(int idFornecedor) throws SQLException, ClassNotFoundException{
     
            Connection conexao = null;
            Statement comando = null;
            Fornecedor fornecedor = null;
            try{
                conexao = BD.getConexao();
                comando = conexao.createStatement();
                ResultSet rs = comando.executeQuery("select * from fornecedor where idFornecedor = " + idFornecedor);
                rs.first();
                fornecedor = instanciarFornecedor(rs);
            } finally{
                fecharConexao(conexao, comando);
            }
            return fornecedor;
    }


    private static Fornecedor instanciarFornecedor(ResultSet rs) throws SQLException {
        Fornecedor fornecedor = new Fornecedor(rs.getInt("idFornecedor"),
        rs.getString("nomeFantasia"),
        rs.getString("cnpj"),
        rs.getString("nomeRepresentante"),
        rs.getString("email"),
        rs.getString("telefone"),
        rs.getInt("numero"),
        rs.getString("complemento"),
        null);
        fornecedor.setIdEndereco(rs.getInt("idEndereco"));
        
        return fornecedor;
    }
    
    public static void gravar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into fornecedor "
                    + "(idFornecedor, nomeFantasia, cnpj, nomeRepresentante, "
                    + "email, telefone, numero, complemento, idEndereco) "
                    + "values (?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, fornecedor.getIdFornecedor());
            comando.setString(2, fornecedor.getNomeFantasia());
            comando.setString(3, fornecedor.getCnpj());
            comando.setString(4, fornecedor.getNomeRepresentante());
            comando.setString(5, fornecedor.getEmail());
            comando.setString(6, fornecedor.getTelefone());
            comando.setInt(7, fornecedor.getNumero());
            comando.setString(8, fornecedor.getComplemento());
            
            if(fornecedor.getEndereco() == null){
                comando.setNull(9, Types.INTEGER);
            }else{
                comando.setInt(9, fornecedor.getEndereco().getIdEndereco());
            }
            comando.executeUpdate();
        }
        finally{
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Fornecedor fornecedor) throws 
            ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from fornecedor where idFornecedor = " 
                    + fornecedor.getIdFornecedor();
            comando.execute(stringSQL);
        }finally {
            fecharConexao(conexao, comando);
                    
        }
    }
    
    public static void alterar(Fornecedor fornecedor) throws ClassNotFoundException, SQLException{
        
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update fornecedor set "
                    + "nomeFantasia='" + fornecedor.getNomeFantasia() +"',"
                    + "cnpj='" + fornecedor.getCnpj() +"',"
                    + "nomeRepresentante='" + fornecedor.getNomeRepresentante() +"',"
                    + "email='" + fornecedor.getEmail() +"',"
                    + "telefone='" + fornecedor.getTelefone() +"',"
                    + "numero='" + fornecedor.getNumero() +"',"
                    + "complemento='" + fornecedor.getComplemento() +"',"
                    + "idEndereco = ";
                    
                    if(fornecedor.getEndereco() == null){
                        stringSQL = stringSQL + null;
                    } else {
                        stringSQL = stringSQL + fornecedor.getEndereco().getIdEndereco();
                    } 
                    
                    stringSQL = stringSQL + " where idFornecedor = " + fornecedor.getIdFornecedor();
                    comando.execute(stringSQL);
        }finally{
            fecharConexao(conexao, comando);
        }
    }
}
