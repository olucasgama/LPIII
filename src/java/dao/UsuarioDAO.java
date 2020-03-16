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
import model.Usuario;

public class UsuarioDAO {
    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Statement comando = null;
        List<Usuario> usuarios = new java.util.ArrayList<Usuario>();
        Usuario usuario = null;
        
        try{
            conexao= BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from usuario");
            
            while(rs.next()){
                usuario = instanciarUsuario(rs);
                usuarios.add(usuario);
            }
        }finally{
            fecharConexao(conexao, comando);
        }
        return usuarios;
    }
    
    public static Usuario obterUsuario(int idUsuario) throws SQLException, ClassNotFoundException{
     
            Connection conexao = null;
            Statement comando = null;
            Usuario usuario = null;
            try{
                conexao = BD.getConexao();
                comando = conexao.createStatement();
                ResultSet rs = comando.executeQuery("select * from usuario where idUsuario = " + idUsuario);
                rs.first();
                usuario = instanciarUsuario(rs);
            } finally{
                fecharConexao(conexao, comando);
            }
            return usuario;
    }

    private static Usuario instanciarUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario(rs.getInt("idUsuario"),
        rs.getString("nome"),
        rs.getString("email"),
        rs.getString("senha"));
        return usuario;
    }
    
    public static void gravar(Usuario usuario) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into usuario (idUsuario, nome, email, senha)"
                    + "values (?,?,?,?)");
            comando.setInt(1, usuario.getIdUsuario());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getSenha());
            comando.executeUpdate();
        }finally{
            fecharConexao(conexao, comando);
        }
    }
    public static void excluir(Usuario usuario) throws ClassNotFoundException, 
            SQLException {
        Connection conexao = null;
        Statement comando= null;
        String stringSQL;
        
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL =  "delete from usuario where idUsuario = " + 
                    usuario.getIdUsuario();
            comando.execute(stringSQL);
        }finally{
            fecharConexao(conexao, comando);
        }
    }
    public static void alterar(Usuario usuario) throws 
            ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "update usuario set "
                    + "nome ='" + usuario.getNome() + "',"
                    + "email='" + usuario.getEmail() + "',"
                    + "senha='" + usuario.getSenha() + "', ";
            
            stringSQL = stringSQL + " where idUsuario = " + usuario.getIdUsuario();
            comando.execute(stringSQL);
        }
        finally {
                fecharConexao(conexao, comando);
        }
    }
}
