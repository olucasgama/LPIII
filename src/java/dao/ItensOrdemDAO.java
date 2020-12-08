/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.ItemOrdem;

public class ItensOrdemDAO {

    private static ItensOrdemDAO instancia = new ItensOrdemDAO();

    public static ItensOrdemDAO getInstancia() {
        return instancia;
    }

    private ItensOrdemDAO() {

    }

    public List<ItemOrdem> findAllItensOrdem(Integer idOrdemSrv) {
        EntityManager em = new ConexaoFactory().getConexao();
        List<ItemOrdem> itensOrdem = null;
        try {
            itensOrdem = em.createNativeQuery("SELECT io.* FROM itemordem io "
                    + "WHERE io.ordemservico_idordemsrv = " + idOrdemSrv, ItemOrdem.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return itensOrdem;
    }

    public List<ItemOrdem> findAllItemOrdems() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<ItemOrdem> itensOrdem = null;
        try {
            itensOrdem = em.createQuery("from ItemOrdem io").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return itensOrdem;
    }

    public ItemOrdem findItemOrdem(Integer idItemOrdem) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemOrdem itemOrdem = null;
        try {
            itemOrdem = em.find(ItemOrdem.class, idItemOrdem);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return itemOrdem;
    }

    public ItemOrdem save(ItemOrdem itemOrdem) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (itemOrdem.getIdItensOrdem() == null) {
                em.persist(itemOrdem);
            } else {
                em.merge(itemOrdem);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return itemOrdem;
    }

    public ItemOrdem remove(Integer idItemOrdem) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemOrdem itemOrdem = null;
        try {
            itemOrdem = em.find(ItemOrdem.class, idItemOrdem);
            em.getTransaction().begin();
            em.remove(itemOrdem);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return itemOrdem;
    }
}
