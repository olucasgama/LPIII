/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nome;
    private String email;
    private String senha;

    public Usuario(Integer idUsuario, String nome, String email, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Integer getIdUsuario() {
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

    /*
    public static Usuario obterUsuario(int idUsuario) throws SQLException, ClassNotFoundException {
        return UsuarioDAO.getInstancia().findUsuario(idUsuario);
    }

    public static List<Usuario> obterUsuarios() throws ClassNotFoundException, SQLException {
        return UsuarioDAO.getInstancia().findAllUsuarios();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        UsuarioDAO.getInstancia().save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        UsuarioDAO.getInstancia().remove(idUsuario);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        UsuarioDAO.getInstancia().save(this);
    }*/
}
