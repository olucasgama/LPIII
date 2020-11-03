/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;

public class UsuarioDAO {

    private static UsuarioDAO instancia = new UsuarioDAO();

    public static UsuarioDAO getInstancia() {
        return instancia;
    }

    private UsuarioDAO() {

    }

    public Usuario save(Usuario usuario) {
        EntityManager em = new ConexaoFactory().getConexao();
        try {
            em.getTransaction().begin();
            if (usuario.getIdUsuario() == null) {
                em.persist(usuario);
            } else {
                em.merge(usuario);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return usuario;
    }

    public List<Usuario> findAllUsuarios() {
        EntityManager em = new ConexaoFactory().getConexao();
        List<Usuario> usuarios = null;
        try {
            usuarios = em.createQuery("from usuario c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return usuarios;
    }

    public Usuario findUsuario(Integer idUsuario) {
        EntityManager em = new ConexaoFactory().getConexao();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, idUsuario);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return usuario;
    }

    public Usuario remove(Integer idUsuario) {
        EntityManager em = new ConexaoFactory().getConexao();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, idUsuario);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        } finally {
            em.close();
        }
        return usuario;
    }

}
