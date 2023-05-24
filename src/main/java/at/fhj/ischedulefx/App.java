package at.fhj.ischedulefx;

import at.fhj.ischedulefx.Dao.UserDao;
import at.fhj.ischedulefx.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user1 = new User("Laurenz", "123", "ADMIN", "laurenz@");
        userDao.saveUser(user1);

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("thePersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//
//        // Start a transaction
//        em.getTransaction().begin();
//
//        // Create a new User entity and persist it
//        User user = new User("User name", "email@example.com", "password", "Student");
//        em.persist(user);
//
//        // Commit the transaction, which will cause the user to be stored in the database
//        em.getTransaction().commit();
//
//        // Close the EntityManager and EntityManagerFactory when done
//        em.close();
//        emf.close();
    }
}
