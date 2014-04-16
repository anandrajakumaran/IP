/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.CustomerOrder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Anand
 */
public class TransactionDao implements TransactionDaoInterface {
  private SessionFactory sessionFactory ;
    private Session session ;

    @Override
    public   CustomerOrder find(Object id) {
         sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
    CustomerOrder order = new CustomerOrder();
    try{
        tx = session.beginTransaction();
   
        order = (CustomerOrder)session.createQuery("FROM CustomerOrder c WHERE c.id = :id ")
                .setParameter("id", id.toString()).uniqueResult();
        session.refresh(order);
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
        sessionFactory.close();
    }

    return order;
     }

    @Override
    public CustomerOrder findByCustomer(Object customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CustomerOrder> findAll() {
        
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
     List<CustomerOrder> orderList  = new ArrayList<CustomerOrder>();
    try{
        tx = session.beginTransaction();
        orderList = (List<CustomerOrder>)session.createQuery(" FROM CustomerOrder c  ")
                .list();
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
        sessionFactory.close();
    }

    return orderList;
  
    }
 
       public List<CustomerOrder> findByDate(Date fromDate,Date toDate) {
        
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
     List<CustomerOrder> orderList  = new ArrayList<CustomerOrder>();
    try{
        tx = session.beginTransaction();
        orderList = (List<CustomerOrder>)session.createQuery(" FROM CustomerOrder c WHERE c.dateCreated between  :fromDate and :toDate")
                .setParameter("fromDate", fromDate).setParameter("toDate", toDate).list();
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
        sessionFactory.close();
    }

    return orderList;
  
    }
}
