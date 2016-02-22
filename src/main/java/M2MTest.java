import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class M2MTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("m2m-pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        M2MOwner owner = em.merge(new M2MOwner());
        em.flush();
        
        M2MInverse inverse = new M2MInverse();
        owner.getInverses().add(inverse);
        inverse.getOwners().add(owner);
        inverse = em.merge(inverse);
        //owner = em.merge(owner);
        em.flush();
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
