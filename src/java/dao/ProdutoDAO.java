/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import java.util.List;
import model.Produto;

public class ProdutoDAO {

    private static ProdutoDAO instancia = new ProdutoDAO();

    public static ProdutoDAO getInstancia() {
        return instancia;
    }
    
    private ProdutoDAO(){
        
    }

    public Produto save(Produto produto) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (produto.getIdProduto() == null) {
                em.persist(produto);
            } else {
                em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> findAllProdutos() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Produto> produtos = null;
        try {
            produtos = em.createQuery("from Produto p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return produtos;
    }

    public Produto findProduto(Integer idProduto) {
        EntityManager em = new ConexaoFactory().getConexao();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, idProduto);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return produto;
    }

    public Produto remove(Integer idProduto) {
        EntityManager em = new ConexaoFactory().getConexao();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, idProduto);
            em.getTransaction().begin();
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return produto;
    }
}
