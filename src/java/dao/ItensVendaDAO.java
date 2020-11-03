/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.ItemVenda;

public class ItensVendaDAO {

    private static ItensVendaDAO instancia = new ItensVendaDAO();

    public static ItensVendaDAO getInstancia() {
        return instancia;
    }

    public ItensVendaDAO() {

    }

    public ItemVenda save(ItemVenda itemVenda) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (itemVenda.getIdItensVenda() == null) {
                em.persist(itemVenda);
            } else {
                em.merge(itemVenda);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return itemVenda;
    }

    public List<ItemVenda> findAllItemVendas() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<ItemVenda> itensVenda = null;
        try {
            itensVenda = em.createQuery("from itensVenda i").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return itensVenda;
    }

    public ItemVenda findItemVenda(Integer idItemVenda) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemVenda itemVenda = null;
        try {
            itemVenda = em.find(ItemVenda.class, idItemVenda);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return itemVenda;
    }
    
    public ItemVenda findItensDaVenda(Integer idVenda) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemVenda itensDaVenda = null;
        try {
            itensDaVenda = em.find(ItemVenda.class, idVenda);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return itensDaVenda;
    }

    public ItemVenda remove(Integer idItemVenda) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemVenda itemVenda = null;
        try {
            itemVenda = em.find(ItemVenda.class, idItemVenda);
            em.getTransaction().begin();
            em.remove(itemVenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return itemVenda;
    }
}
