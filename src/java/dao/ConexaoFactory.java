package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author lucas
 */
public class ConexaoFactory {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sgmc");
    
    public EntityManager getConexao() {
        return emf.createEntityManager();
    }
}
