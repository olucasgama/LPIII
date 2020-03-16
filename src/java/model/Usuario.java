/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int idUsuario, String nome, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
       public static Usuario obterUsuario (int idUsuario) throws SQLException, ClassNotFoundException{
        return UsuarioDAO.obterUsuario(idUsuario);
    }
    
    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException{
        return UsuarioDAO.obterUsuarios();
    }
    
    public void gravar() throws ClassNotFoundException, SQLException{
        UsuarioDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException {
        UsuarioDAO.excluir(this);
    }
    public void alterar() throws ClassNotFoundException, SQLException{
        UsuarioDAO.alterar(this);
    }
}
