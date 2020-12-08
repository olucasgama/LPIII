/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.OrdemServico;
import javax.persistence.EntityManager;
import model.ItemOrdem;

public class OrdemServicoDAO {

    private static OrdemServicoDAO instancia = new OrdemServicoDAO();

    public static OrdemServicoDAO getInstancia() {
        return instancia;
    }
    
    private OrdemServicoDAO(){
        
    }

    public OrdemServico save(OrdemServico ordemServico) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (ordemServico.getIdOrdemSrv() == null) {
                em.persist(ordemServico);
            } else {
                em.merge(ordemServico);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return ordemServico;
    }

    public List<OrdemServico> findAllOrdemServicos() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<OrdemServico> ordensServico = null;
        try {
            ordensServico = em.createQuery("from OrdemServico os").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return ordensServico;
    }

    public OrdemServico findOrdemServico(Integer idOrdemSrv) {
        EntityManager em = new ConexaoFactory().getConexao();
        OrdemServico ordemServico = null;
        try {
            ordemServico = em.find(OrdemServico.class, idOrdemSrv);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return ordemServico;
    }

    public OrdemServico remove(Integer idOrdemSrv) {
        EntityManager em = new ConexaoFactory().getConexao();
        OrdemServico ordemServico = null;
        try {
            ordemServico = em.find(OrdemServico.class, idOrdemSrv);
            em.getTransaction().begin();
            em.remove(ordemServico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return ordemServico;
    }
    
    public ItemOrdem removeItem(Integer idOrdemSrv) {
        EntityManager em = new ConexaoFactory().getConexao();
        ItemOrdem itemOrdem = null;
        try {
            itemOrdem = em.find(ItemOrdem.class, idOrdemSrv);
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
