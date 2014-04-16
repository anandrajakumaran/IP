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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Anand
 */
public class CategoryDao implements CategoryDaoInterface {
    
       private SessionFactory sessionFactory ;
    private Session session ;
    
        @Override
        public List<Category> fetchCategories(){
            
       List<Category> categoryList = new ArrayList<Category>();    
       sessionFactory    = new Configuration().configure().buildSessionFactory();
       session           = sessionFactory.openSession();
       Transaction tx = null;
       try{
           categoryList = (List<Category>)session.createQuery("FROM Category").list();
       }catch(HibernateException e){
           e.printStackTrace();
       }finally{
            session.close();
        }
            return categoryList;
        }

    @Override
    public Category getCategoryId(Short categoryId) {
        
    Category category = new Category();
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
    
    try{
        tx = session.beginTransaction();
        category = (Category)session.createQuery("FROM Category c WHERE c.id = :id")
                .setParameter("id", categoryId).uniqueResult();
               
    }
    catch(HibernateException e){
        e.printStackTrace();
    }finally{
       sessionFactory.close();
    }

    return category;   
    }    

}
