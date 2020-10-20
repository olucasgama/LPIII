/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Endereco;

public class EnderecoDAO {

    private static EnderecoDAO instancia = new EnderecoDAO();

    public static EnderecoDAO getInstancia() {
        return instancia;
    }

    private EnderecoDAO() {

    }

    public Endereco save(Endereco endereco) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (endereco.getIdEndereco() == null) {
                em.persist(endereco);
            } else {
                em.merge(endereco);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return endereco;
    }

    public List<Endereco> findAllEnderecos() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Endereco> enderecos = null;
        try {
            enderecos = em.createQuery("from Endereco e").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return enderecos;
    }

    public Endereco findEndereco(Integer idEndereco) {
        EntityManager em = new ConexaoFactory().getConexao();
        Endereco endereco = null;
        try {
            endereco = em.find(Endereco.class, idEndereco);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return endereco;
    }

    public Endereco remove(Integer idEndereco) {
        EntityManager em = new ConexaoFactory().getConexao();
        Endereco endereco = null;
        try {
            endereco = em.find(Endereco.class, idEndereco);
            em.getTransaction().begin();
            em.remove(endereco);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return endereco;
    }
}
