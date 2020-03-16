/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AdminDAO;
import java.sql.SQLException;
import java.util.List;

public class Admin extends Usuario{
    
    private int idAdmin;

    public Admin(int idAdmin, int idUsuario, String nome, String email, String senha) {
        super(idUsuario, nome, email, senha);
        this.idAdmin = idAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public static Admin obterAdmin (int idAdmin) throws SQLException, ClassNotFoundException{
        return AdminDAO.obterAdmin(idAdmin);
    }
    
    public static List<Admin> obterAdmins() throws ClassNotFoundException, SQLException{
        return AdminDAO.obterAdmins();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        AdminDAO.gravar(this, this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        AdminDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        AdminDAO.alterar(this);
    }
    
}
