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
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.Usuario;

public class AdminDAO {

    public static List<Admin> obterAdmins() throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<Admin> admins = new ArrayList<Admin>();
        Admin admin = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from admin join usuario"
                    + " on admin.idUsuario=usuario.idUsuario");

            while (rs.next()) {
                admin = instaciarAdmin(rs);
                admins.add(admin);
            }
        } finally {
            fecharConexao(conexao, comando);

        }
        return admins;
    }

    public static Admin obterAdmin(int idAdmin) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        Admin admin = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from admin join"
                    + " usuario on admin.idUsuario=usuario.idUsuario"
                    + " where idAdmin = " + idAdmin);
            rs.first();
            admin = instaciarAdmin(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return admin;
    }

    private static Admin instaciarAdmin(ResultSet rs) throws SQLException {

        Admin admin = new Admin(rs.getInt("idAdmin"),
                rs.getInt("idUsuario"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"));

        return admin;
    }

    public static void gravar(Admin admin, Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into usuario (idUsuario, nome, email, senha)"
                    + " values (?,?,?,?)");
            comando.setInt(1, usuario.getIdUsuario());
            comando.setString(2, usuario.getNome());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getSenha());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into admin (idAdmin, idUsuario) values (?,?)");
            comando.setInt(1, admin.getIdAdmin());
            comando.setInt(2, admin.getIdUsuario());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Admin admin)
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from admin where idAdmin = " + admin.getIdAdmin();
            comando.execute(stringSQL);
            stringSQL = "delete from usuario where idUsuario = " + admin.getIdUsuario();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Admin admin) throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;  
            try {
                conexao = BD.getConexao();
                comando = conexao.createStatement();

                stringSQL = "update usuario set "
                        + "nome ='" + admin.getNome() + "',"
                        + "email='" + admin.getEmail() + "',"
                        + "senha='" + admin.getSenha() + "' ";

                stringSQL = stringSQL + " where idUsuario = " + admin.getIdUsuario();
                comando.execute(stringSQL);
            } finally {
                fecharConexao(conexao, comando);
            }
        }
    }
