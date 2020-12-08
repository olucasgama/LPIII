/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Colaborador;

public class ColaboradorDAO {

    private static ColaboradorDAO instancia = new ColaboradorDAO();

    public static ColaboradorDAO getInstancia() {
        return instancia;
    }

    private ColaboradorDAO() {

    }

    public Colaborador save(Colaborador colaborador) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (/*colaborador.getIdColaborador()*/ colaborador.getIdUsuario() == null) {
                em.persist(colaborador);
            } else {
                em.merge(colaborador);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return colaborador;
    }

    public List<Colaborador> findAllColaboradors() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Colaborador> colaboradors = null;
        try {
            colaboradors = em.createQuery("from Colaborador c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return colaboradors;
    }

    public Colaborador findColaborador(Integer idColaborador) {
        EntityManager em = new ConexaoFactory().getConexao();
        Colaborador colaborador = null;
        try {
            colaborador = em.find(Colaborador.class, idColaborador);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return colaborador;
    }

    public Colaborador remove(Integer idColaborador) {
        EntityManager em = new ConexaoFactory().getConexao();
        Colaborador colaborador = null;
        try {
            colaborador = em.find(Colaborador.class, idColaborador);
            em.getTransaction().begin();
            em.remove(colaborador);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return colaborador;
    }

}
