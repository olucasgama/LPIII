/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.FormaPagamento;

public class FormaPagamentoDAO {

    private static FormaPagamentoDAO instancia = new FormaPagamentoDAO();

    public static FormaPagamentoDAO getInstancia() {
        return instancia;
    }

    public FormaPagamentoDAO() {

    }

    
    public FormaPagamento save(FormaPagamento formaPagamento){
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (formaPagamento.getIdFormaPgto() == null) {
                em.persist(formaPagamento);
            } else {
                em.merge(formaPagamento);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return formaPagamento;
    }
    
    public List<FormaPagamento> findAllFormasPagamentos(){
        EntityManager em = new ConexaoFactory().getConexao();
        List<FormaPagamento> formasPagamentos = null;
        try {
            formasPagamentos = em.createQuery("from FormaPagamento f").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return formasPagamentos;
    }
    
    public FormaPagamento findFormaPagamento(Integer idFormaPagamento){
        EntityManager em = new ConexaoFactory().getConexao();
        FormaPagamento formaPagamento = null;
        try {
            formaPagamento = em.find(FormaPagamento.class, idFormaPagamento);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return formaPagamento;
    }
    
    public FormaPagamento remove(Integer idFormaPagamento){
        EntityManager em = new ConexaoFactory().getConexao();
        FormaPagamento formaPagamento = null;
        try {
            formaPagamento = em.find(FormaPagamento.class, idFormaPagamento);
            em.getTransaction().begin();
            em.remove(formaPagamento);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return formaPagamento;
    }
}
