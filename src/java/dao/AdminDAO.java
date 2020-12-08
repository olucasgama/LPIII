/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Admin;

public class AdminDAO {

    private static AdminDAO instancia = new AdminDAO();

    public static AdminDAO getInstancia() {
        return instancia;
    }

    private AdminDAO() {

    }

    public Admin save(Admin admin) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (/*admin.getIdAdmin()*/ admin.getIdUsuario() == null) {
                em.persist(admin);
            } else {
                em.merge(admin);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return admin;
    }

    public List<Admin> findAllAdmins() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Admin> admins = null;
        try {
            admins = em.createQuery("from Admin c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return admins;
    }

    public Admin findAdmin(Integer idAdmin) {
        EntityManager em = new ConexaoFactory().getConexao();
        Admin admin = null;
        try {
            admin = em.find(Admin.class, idAdmin);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return admin;
    }

    public Admin remove(Integer idAdmin) {
        EntityManager em = new ConexaoFactory().getConexao();
        Admin admin = null;
        try {
            admin = em.find(Admin.class, idAdmin);
            em.getTransaction().begin();
            em.remove(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return admin;
    }

}
