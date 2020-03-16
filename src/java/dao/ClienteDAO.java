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
import model.Cliente;

public class ClienteDAO {
    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException{
        
        Connection conexao =null;
        Statement comando = null;
        List<Cliente> clientes = new java.util.ArrayList<Cliente>();
        Cliente cliente = null;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente");
            
            while (rs.next()){
                cliente = instanciarCliente(rs);
                clientes.add(cliente);
            }
            }finally{
                    fecharConexao(conexao, comando);
                    
                    }
            return clientes;
        }
     public static Cliente obterCliente(int idCliente) throws SQLException, ClassNotFoundException{
     
            Connection conexao = null;
            Statement comando = null;
            Cliente cliente = null;
            try{
                conexao = BD.getConexao();
                comando = conexao.createStatement();
                ResultSet rs = comando.executeQuery("select * from cliente where idCliente = " + idCliente);
                rs.first();
                cliente = instanciarCliente(rs);
            } finally{
                fecharConexao(conexao, comando);
            }
            return cliente;
    }


    private static Cliente instanciarCliente(ResultSet rs) throws SQLException {
       Cliente cliente = new Cliente (rs.getInt("idCliente"),
       rs.getString("cnpj"),
       rs.getString("razaoSocial"),
       rs.getString("inscricaoEstadual"),
       rs.getString("nome"),
       rs.getString("cpf"),
       rs.getString("rg"),
       rs.getString("telefone"),
       rs.getString("celular"),
       rs.getString("email"),
       rs.getString("dataNascimento"),
       rs.getString("estadoCivil"),
       rs.getString("sexo"),
       rs.getInt("numero"),
       rs.getString("complemento"),
       null);        
       cliente.setIdEndereco(rs.getInt("idEndereco"));     
       return cliente;
    }
    
    public static void gravar(Cliente cliente) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
            "insert into cliente (idCliente, cnpj, razaoSocial, "
                    + "inscricaoEstadual, nome, cpf, rg, telefone, celular, "
                    + "email, dataNascimento, estadoCivil, sexo, numero, "
                    + "complemento, idEndereco) values "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, cliente.getIdCliente());
            comando.setString(2, cliente.getCnpj());
            comando.setString(3, cliente.getRazaoSocial());
            comando.setString(4, cliente.getInscricaoEstadual());
            comando.setString(5, cliente.getNome());
            comando.setString(6, cliente.getCpf());
            comando.setString(7, cliente.getRg());
            comando.setString(8, cliente.getTelefone());
            comando.setString(9, cliente.getCelular());
            comando.setString(10, cliente.getEmail());
            comando.setString(11, cliente.getDataNascimento());
            comando.setString(12, cliente.getEstadoCivil());
            comando.setString(13, cliente.getSexo());
            comando.setInt(14, cliente.getNumero());
            comando.setString(15, cliente.getComplemento());
            
            if(cliente.getEndereco()==null){
                comando.setNull(16, Types.INTEGER);
            }else{
                comando.setInt(16, cliente.getEndereco().getIdEndereco());
            }
            comando.executeUpdate();
            }finally{
            fecharConexao(conexao, comando);
        }
    }
    public static void excluir(Cliente cliente) throws ClassNotFoundException, 
            SQLException{
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from cliente where idCliente = " 
                    + cliente.getIdCliente();
            comando.execute(stringSQL);
        }finally {
            fecharConexao(conexao, comando);            
        }
    }
    
    public static void alterar(Cliente cliente) throws ClassNotFoundException, SQLException{
        
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update cliente set "
                    + "cnpj ='" + cliente.getCnpj() + "',"
                    + "razaoSocial='" + cliente.getRazaoSocial() + "',"
                    + "inscricaoEstadual='" + cliente.getInscricaoEstadual() + "'," 
                    + "nome='" + cliente.getNome() + "',"
                    + "cpf='" + cliente.getCpf() + "',"
                    + "rg='" + cliente.getRg() + "',"
                    + "telefone='" + cliente.getTelefone() + "',"
                    + "celular='" + cliente.getCelular() + "',"
                    + "email='" + cliente.getEmail() + "',"
                    + "dataNascimento='" + cliente.getDataNascimento() + "',"
                    + "estadoCivil='" + cliente.getEstadoCivil() + "',"
                    + "sexo='" + cliente.getSexo() + "', " 
                    + "numero='" + cliente.getNumero() +"',"
                    + "complemento='" + cliente.getComplemento() +"',"
                    + "idEndereco = ";
                    
                    if(cliente.getEndereco() == null){
                        stringSQL = stringSQL + null;
                    } else {
                        stringSQL = stringSQL + cliente.getEndereco().getIdEndereco();
                    }
                    stringSQL = stringSQL + " where idCliente = " + cliente.getIdCliente();
                    comando.execute(stringSQL);
        }finally{
            fecharConexao(conexao, comando);
        }
    }
}
