/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import java.util.List;
import model.PerdaDevolucao;

public class PerdaDevolucaoDAO {

    private static PerdaDevolucaoDAO instancia = new PerdaDevolucaoDAO();

    public static PerdaDevolucaoDAO getInstancia() {
        return instancia;
    }
    
    private PerdaDevolucaoDAO(){
        
    }

    public PerdaDevolucao save(PerdaDevolucao perdaDevolucao) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (perdaDevolucao.getIdPerdaDevolucao() == null) {
                em.persist(perdaDevolucao);
            } else {
                em.merge(perdaDevolucao);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return perdaDevolucao;
    }

    public List<PerdaDevolucao> findAllPerdaDevolucoes() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<PerdaDevolucao> perdaDevolucoes = null;
        try {
            perdaDevolucoes = em.createQuery("from perdaDevolucao p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return perdaDevolucoes;
    }

    public PerdaDevolucao findPerdaDevolucao(Integer idPerdaDevolucao) {
        EntityManager em = new ConexaoFactory().getConexao();
        PerdaDevolucao perdaDevolucao = null;
        try {
            perdaDevolucao = em.find(PerdaDevolucao.class, idPerdaDevolucao);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return perdaDevolucao;
    }

    public PerdaDevolucao remove(Integer idPerdaDevolucao) {
        EntityManager em = new ConexaoFactory().getConexao();
        PerdaDevolucao perdaDevolucao = null;
        try {
            perdaDevolucao = em.find(PerdaDevolucao.class, idPerdaDevolucao);
            em.getTransaction().begin();
            em.remove(perdaDevolucao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return perdaDevolucao;
    }
}
