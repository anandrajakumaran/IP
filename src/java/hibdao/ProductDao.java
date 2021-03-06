/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.Category;
import hibernate.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Anand
 */
public class ProductDao implements ProductDaoInterface{

    private SessionFactory sessionFactory ;
    private Session session ;
    
    @Override
    public Collection<Product> getProducts(String productKeyword) {
        
       Collection<Product> productList = new ArrayList<Product>();    
       
       sessionFactory    = new Configuration().configure().buildSessionFactory();
       session           = sessionFactory.openSession();
       Transaction tx = null;
       try{
           productList = (Collection<Product>)session.createQuery("SELECT p FROM Product p WHERE p.detail Like  :keyword").setParameter("keyword","%"+productKeyword+"%")
                   .list();
       }catch(HibernateException e){
           e.printStackTrace();
       }finally{
            sessionFactory.close();
        }
            return productList;
    }

    @Override
    public Product getProduct(int productId) {
        
     Product product = new Product();
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
    
    try{
        tx = session.beginTransaction();
        product = (Product)session.createQuery("FROM Product p WHERE p.id = :id")
                .setParameter("id", productId).uniqueResult();
                    session.close();
  
    }
    catch(HibernateException e){
        e.printStackTrace();
    }finally{
      sessionFactory.close();
    }
    
    return product;
    }
    
    @Override
  public int saveProduct(String name,float price,String description,String detail,String category,byte[] bytes, String sellerId){
        Product product = new Product();
        Category category1 = new Category();
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction  tx = session.beginTransaction();
    BigDecimal priceb = new BigDecimal(price);
    try{
        product.setName(name);
            product.setDescription(description);
            product.setPrice(priceb);
            product.setDetail(detail);
            category1.setId(Integer.parseInt(category));
                    //Integer.parseInt(category));
            product.setImage(bytes);
            product.setCategory(category1);
         product.setSellerId(sellerId);
       session.save(product);
       tx.commit();
  
    }
    catch(HibernateException e){
          tx.rollback();
        e.printStackTrace();
        return 0;
      
    }finally{
      sessionFactory.close();
    }
    
       return 1;

  }
}
