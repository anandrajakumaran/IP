/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.Category;
import hibernate.Customer;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Anand
 */
public class LoginDao implements LoginDaoInterface {
    
   private SessionFactory sessionFactory ;
    private Session session ;

   
    
   @Override
    public Customer findByIdAndPassword(String id, String password) {
   
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
    Customer customer = new Customer();
    try{
        tx = session.beginTransaction();
        customer = (Customer)session.createQuery("FROM Customer c WHERE c.id = :id and c.password = :password")
                .setParameter("id", id)
                .setParameter("password",password).uniqueResult();
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
        sessionFactory.close();
    }

    return customer;
    }

    @Override
    public Customer findById(String id) {

    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
    Customer customer = new Customer();
    try{
        tx = session.beginTransaction();
        customer = (Customer)session.createQuery("FROM Customer c WHERE c.id = :id")
                .setParameter("id", id).uniqueResult();
               
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
        sessionFactory.close();
    }

    return customer;    }

    @Override
    public List<Customer> findAll() {
         
       List<Customer> customerList = new ArrayList<Customer>();    
       sessionFactory    = new Configuration().configure().buildSessionFactory();
       session           = sessionFactory.openSession();
       Transaction tx = null;
       try{
           customerList = (List<Customer>)session.createQuery("FROM Customer").list();
       }catch(HibernateException e){
           e.printStackTrace();
       }finally{
            sessionFactory.close();
        }
            return customerList;
    }
    
}
