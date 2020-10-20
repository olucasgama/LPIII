/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;
import javax.persistence.EntityManager;

public class ClienteDAO {

    private static ClienteDAO instancia = new ClienteDAO();

    public static ClienteDAO getInstancia() {
        return instancia;
    }

    private ClienteDAO() {

    }

    public Cliente save(Cliente cliente) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (cliente.getIdCliente() == null) {
                em.persist(cliente);
            } else {
                em.merge(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return cliente;
    }

    public List<Cliente> findAllClientes() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Cliente> clientes = null;
        try {
            clientes = em.createQuery("from Cliente c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return clientes;
    }

    public Cliente findCliente(Integer idCliente) {
        EntityManager em = new ConexaoFactory().getConexao();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, idCliente);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return cliente;
    }

    public Cliente remove(Integer idCliente) {
        EntityManager em = new ConexaoFactory().getConexao();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, idCliente);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return cliente;
    }
}
