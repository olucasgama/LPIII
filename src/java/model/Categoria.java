/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;

public class Categoria {
    
    private int idCategoria;
    private String descricao;

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public int getIdCategoria() {
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
        return CategoriaDAO.obterCategoria(idCategoria);
    }
    
    public static List<Categoria> obterCategorias() throws ClassNotFoundException, SQLException{
        return CategoriaDAO.obterCategorias();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        CategoriaDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        CategoriaDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        CategoriaDAO.alterar(this);
    }
}
