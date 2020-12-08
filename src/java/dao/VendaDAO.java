/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.ItemVenda;
import model.Venda;

public class VendaDAO {

    private static VendaDAO instancia = new VendaDAO();

    public static VendaDAO getInstancia() {
        return instancia;
    }

    private VendaDAO() {

    }
    
    public Venda save(Venda venda){
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (venda.getIdVenda() == null) {
                em.persist(venda);
            } else {
                em.merge(venda);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return venda;
    }
    
    public List<Venda> findAllVendas(){
        EntityManager em = new ConexaoFactory().getConexao();
        List<Venda> vendas = null;
        try {
            vendas = em.createQuery("from Venda v").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return vendas;
    }
    
    public Venda findVenda(Integer idVenda){
        EntityManager em = new ConexaoFactory().getConexao();
        Venda venda = null;
        try {
            venda = em.find(Venda.class, idVenda);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return venda;
    }
    
    public Venda remove(Integer idVenda) {
        EntityManager em = new ConexaoFactory().getConexao();
        Venda venda = null;
        try {
            venda = em.find(Venda.class, idVenda);
            em.getTransaction().begin();
            em.remove(venda);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return venda;
    }
    
    public ItemVenda removeItem (Integer idVenda) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemVenda itemVenda = null;
        try {
            itemVenda = em.find(ItemVenda.class, idVenda);
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
