/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author DealGuru
 */
public class RegisterDao implements RegisterDaoInterface{
     
   private SessionFactory sessionFactory ;
   private Session session ;
   
    @Override
    public int saveRegisteration(String name, String email, String phone, String username, String password, String address) {
        
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
    Customer customer = new Customer();
          try {
                tx = session.beginTransaction();
                tx.begin();
                    customer.setName(name);
                    customer.setEmail(email);
                    customer.setPhone(phone);
                    customer.setPassword(password);
                    customer.setAddress(address);
                    customer.setAdminFlag("Y");
                    customer.setId(username);
                    session.save(customer);
                    tx.commit();
        } catch (Exception e) {
            System.out.println("<=====Exception inside Register Dao =======>");
            tx.rollback();
            return 0;
           
        }finally{
              sessionFactory.close();
          }
        return 1;
    }
    
}
