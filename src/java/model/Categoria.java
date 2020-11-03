/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;
    private String descricao;

    public Categoria(Integer idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static Categoria obterCategoria (int idCategoria) throws SQLException, ClassNotFoundException{
        return CategoriaDAO.getInstancia().findCategoria(idCategoria);
    }
    
    public static List<Categoria> obterCategorias() throws ClassNotFoundException, SQLException{
        return CategoriaDAO.getInstancia().findAllCategorias();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CategoriaDAO.getInstancia().save(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        CategoriaDAO.getInstancia().remove(idCategoria);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        CategoriaDAO.getInstancia().save(this);
    }
}
