/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Categoria;
import javax.persistence.EntityManager;

public class CategoriaDAO {

    private static CategoriaDAO instancia = new CategoriaDAO();

    public static CategoriaDAO getInstancia() {
        return instancia;
    }
    
    private CategoriaDAO(){
        
    }

    public Categoria save(Categoria categoria) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (categoria.getIdCategoria() == null) {
                em.persist(categoria);
            } else {
                em.merge(categoria);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return categoria;
    }

    public List<Categoria> findAllCategorias() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Categoria> categorias = null;
        try {
            categorias = em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return categorias;
    }

    public Categoria findCategoria(Integer idCategoria) {
        EntityManager em = new ConexaoFactory().getConexao();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, idCategoria);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return categoria;
    }

    public Categoria remove(Integer idCategoria) {
        EntityManager em = new ConexaoFactory().getConexao();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, idCategoria);
            em.getTransaction().begin();
            em.remove(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return categoria;
    }

}
