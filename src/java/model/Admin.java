/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AdminDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Admin extends Usuario{
    
    private Integer idAdmin;

    public Admin(Integer idAdmin, Integer idUsuario, String nome, String email, String senha) {
        super(idUsuario, nome, email, senha);
        this.idAdmin = idAdmin;
    }

    public Admin(Integer idUsuario, String nome, String email, String senha) {
        super(idUsuario, nome, email, senha);
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
   public static Admin obterAdmin(int idAdmin) throws SQLException, ClassNotFoundException {
        return AdminDAO.getInstancia().findAdmin(idAdmin);
    }

    public static List<Admin> obterAdmins() throws ClassNotFoundException, SQLException {
        return AdminDAO.getInstancia().findAllAdmins();
    }

    @Override
    public void gravar() throws SQLException, ClassNotFoundException {
        AdminDAO.getInstancia().save(this);
    }

    @Override
    public void excluir() throws ClassNotFoundException, SQLException {
        AdminDAO.getInstancia().remove(idAdmin);
    }

    @Override
    public void alterar() throws ClassNotFoundException, SQLException {
        AdminDAO.getInstancia().save(this);
    }
}
