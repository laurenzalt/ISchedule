package at.fhj.ischedulefx.Dao;

import at.fhj.ischedulefx.DatabaseConnection;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import at.fhj.ischedulefx.Entity.User;

public class UserDao {
    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = DatabaseConnection.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
