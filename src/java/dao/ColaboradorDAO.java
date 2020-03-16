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
import model.Colaborador;
import model.Usuario;

public class ColaboradorDAO {

    public static List<Colaborador> obterColaboradores() throws ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        List<Colaborador> colaboradores = new java.util.ArrayList<Colaborador>();
        Colaborador colaborador = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from colaborador join "
                    + " usuario on colaborador.idUsuario=usuario.idUsuario"
                    + " join endereco on colaborador.idEndereco=endereco.idEndereco");

            while (rs.next()) {
                colaborador = instanciarColaborador(rs);
                colaboradores.add(colaborador);
            }
        } finally {
            fecharConexao(conexao, comando);

        }
        return colaboradores;
    }

    public static Colaborador obterColaborador(int idColaborador) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        Colaborador colaborador = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from colaborador join"
                    + " usuario on colaborador.idUsuario=usuario.idUsuario"
                    + " join endereco on colaborador.idEndereco=endereco.idEndereco "
                    + " where idColaborador = " + idColaborador);
            rs.first();
            colaborador = instanciarColaborador(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return colaborador;
    }

    private static Colaborador instanciarColaborador(ResultSet rs) throws SQLException {
        Colaborador colaborador = new Colaborador(rs.getInt("idColaborador"),
                rs.getString("cpf"),
                rs.getString("rg"),
                rs.getString("dataNascimento"),
                rs.getString("telefone"),
                rs.getString("celular"),
                rs.getString("estadoCivil"),
                rs.getString("sexo"),
                rs.getInt("numero"),
                rs.getString("complemento"),
                rs.getInt("idUsuario"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"),
                null);
        colaborador.setIdEndereco(rs.getInt("idEndereco"));
        return colaborador;
    }

    public static void gravar(Colaborador colaborador, Usuario usuario) throws ClassNotFoundException, SQLException {
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
                    "insert into colaborador (idColaborador, cpf, rg, dataNascimento, telefone,"
                    + " celular, estadoCivil, sexo, numero, complemento, "
                    + "idEndereco, idUsuario) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, colaborador.getIdColaborador());
            comando.setString(2, colaborador.getCpf());
            comando.setString(3, colaborador.getRg());
            comando.setString(4, colaborador.getDataNascimento());
            comando.setString(5, colaborador.getTelefone());
            comando.setString(6, colaborador.getCelular());
            comando.setString(7, colaborador.getEstadoCivil());
            comando.setString(8, colaborador.getSexo());
            comando.setInt(9, colaborador.getNumero());
            comando.setString(10, colaborador.getComplemento());
            if (colaborador.getEndereco() == null) {
                comando.setNull(11, Types.INTEGER);
            } else {
                comando.setInt(11, colaborador.getEndereco().getIdEndereco());
            }
            comando.setInt(12, colaborador.getIdUsuario());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static void excluir(Colaborador colaborador) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from colaborador where idColaborador = " + colaborador.getIdColaborador();
            comando.execute(stringSQL);
            stringSQL = "delete from usuario where idUsuario = " + colaborador.getIdUsuario();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Colaborador colaborador) throws
            ClassNotFoundException, SQLException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update colaborador set "
                    + "cpf ='" + colaborador.getCpf() + "',"
                    + "rg='" + colaborador.getRg() + "',"
                    + "dataNascimento='" + colaborador.getDataNascimento() + "',"
                    + "telefone='" + colaborador.getTelefone() + "',"
                    + "celular='" + colaborador.getCelular() + "',"
                    + "estadoCivil='" + colaborador.getEstadoCivil() + "',"
                    + "sexo='" + colaborador.getSexo() + "',"
                    + "numero='" + colaborador.getNumero() +"',"
                    + "complemento='" + colaborador.getComplemento() +"',"
                    + "idEndereco = ";

            if (colaborador.getEndereco() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + colaborador.getEndereco().getIdEndereco();
            }
            stringSQL = stringSQL + " where idColaborador = " + colaborador.getIdColaborador();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();

            stringSQL = "update usuario set "
                    + "nome ='" + colaborador.getNome() + "',"
                    + "email='" + colaborador.getEmail() + "',"
                    + "senha='" + colaborador.getSenha() + "' ";

            stringSQL = stringSQL + " where idUsuario = " + colaborador.getIdUsuario();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    }
