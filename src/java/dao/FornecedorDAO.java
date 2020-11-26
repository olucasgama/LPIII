/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Fornecedor;

public class FornecedorDAO {

    private static FornecedorDAO instancia = new FornecedorDAO();

    public static FornecedorDAO getInstancia() {
        return instancia;
    }

    private FornecedorDAO() {

    }

    public Fornecedor save(Fornecedor fornecedor) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (fornecedor.getIdFornecedor() == null) {
                em.persist(fornecedor);
            } else {
                em.merge(fornecedor);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public List<Fornecedor> findAllFornecedors() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Fornecedor> fornecedors = null;
        try {
            fornecedors = em.createQuery("from Fornecedor f").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return fornecedors;
    }

    public Fornecedor findFornecedor(Integer idFornecedor) {
        EntityManager em = new ConexaoFactory().getConexao();
        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, idFornecedor);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public Fornecedor remove(Integer idFornecedor) {
        EntityManager em = new ConexaoFactory().getConexao();
        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, idFornecedor);
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return fornecedor;
    }

}
