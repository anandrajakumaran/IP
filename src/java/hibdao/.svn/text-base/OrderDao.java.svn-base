/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.Customer;
import hibernate.CustomerOrder;
import hibernate.ProductOrder;
import hibdao.TransactionDao;
import hibernate.Product;
import hibernate.ProductOrderId;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import shoppingCart.ShoppingCart;
import shoppingCart.ShoppingCartItem;

/**
 *
 * @author Anand
 */
public class OrderDao implements OrderDaoInterface {
private SessionFactory sessionFactory ;
    private Session session ;
    @Override
    public int placeOrder(String id, String name, String email, String phone, String mode, String address, String cardNumber, ShoppingCart cart) {    System.out.println("Address--->"+address);
        try {
          Customer customer = addCustomer(id,name, email, phone, address);

        CustomerOrder order = addOrder(customer,cardNumber,mode, cart);
        System.out.println("order Confirmations--->"+order.getConfirmationNumber());
        addOrderedItems(order, cart);
        return Integer.parseInt(order.getId().toString());
        } catch (Exception e) {
          e.printStackTrace();
            return 0;
        }
        

    }

    private Customer addCustomer(String id,String name, String email, String phone, String address) {
        
        System.out.println("Inisde Add customer ---->"+address);
        Customer customer = new Customer();
         customer.setId(id);
        customer.setAdminFlag(address);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setPassword(phone);
        customer.setAddress(address);
          sessionFactory    = new Configuration().configure().buildSessionFactory();
       session           = sessionFactory.openSession();
       Transaction tx = null;
        try{
                   session.createQuery("UPDATE Customer c SET c.email = :email,c.phone = :phone,c.address = :address "
                + " WHERE c.id = :id").setParameter("email", email).setParameter("phone", phone).setParameter("address", address)
                .setParameter("id", id).executeUpdate();
  
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessionFactory.close();
        }
        return customer;
    }
      private CustomerOrder addOrder(Customer customer, String cardNumber,String mode,ShoppingCart cart) {

        // set up customer order
        CustomerOrder order = new CustomerOrder();
          sessionFactory    = new Configuration().configure().buildSessionFactory();
       session           = sessionFactory.openSession();
               Random random = new Random();
       Transaction tx = null;
        try{
         tx = session.beginTransaction();
        tx.begin();
        order.setCustomer(customer);
        order.setId(Integer.toString(random.nextInt(99)));
        order.setAmount(BigDecimal.valueOf(cart.getTotal()));
        order.setCardNumber(cardNumber);
        order.setModePayment(mode);
        // create confirmation number
        int i = random.nextInt(999999999);
        order.setConfirmationNumber(i);
        System.out.println("----------->"+i);
        
        session.save(order);
        tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessionFactory.close();
        }
        return order;
    }
    
        private void addOrderedItems(CustomerOrder order, ShoppingCart cart) {
            
           sessionFactory    = new Configuration().configure().buildSessionFactory();
       session           = sessionFactory.openSession();
       Transaction tx = null;
      session.flush();
System.out.println(order.getId());
        List<ShoppingCartItem> items = cart.getItems();
        try{
                           

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {
             tx = session.beginTransaction();
                            tx.begin();
            int productId = scItem.getProduct().getId();

            // set up primary key object
            ProductOrderId orderedProductPK = new ProductOrderId();
            orderedProductPK.setCustomerOrderId(order.getId().toString());
            orderedProductPK.setProductId(productId);

            // create ordered item using PK object
            ProductOrder orderedItem = new ProductOrder(orderedProductPK);

            // set quantity
            orderedItem.setQuantity(scItem.getQuantity());

            session.save(orderedItem);
            tx.commit();
        }
        }catch(Exception e){
                e.printStackTrace();
                }finally{
            sessionFactory.close();
        }
    }

    @Override
    public Map getOrderDetails(int orderId) {
   Map orderMap = new HashMap();
            
   TransactionDao transactionDao = new TransactionDao();
   ProductDao productDao = new ProductDao();
        // get order
        CustomerOrder order = transactionDao.find(orderId);

        // get customer
        Customer customer = order.getCustomer();


        // get all ordered products
        List<ProductOrder> orderedProducts = findByOrderId(orderId);
        System.out.println("Oder ID------->"+orderId);
        // get product details for ordered items
        List<Product> products = new ArrayList<Product>();

        for (ProductOrder op : orderedProducts) {

            Product p = (Product) productDao.getProduct(op.getId().getProductId());
            products.add(p);
        }

        // add each item to orderMap
        orderMap.put("orderRecord", order);
        orderMap.put("customer", customer);
        orderMap.put("orderedProducts", orderedProducts);
        orderMap.put("products", products);

        return orderMap;   
    }
    
     public List<ProductOrder> findByOrderId(Object id) {
             sessionFactory    = new Configuration().configure().buildSessionFactory();
    session       = sessionFactory.openSession();
    Transaction tx = null;
     List<ProductOrder> order  = new ArrayList<ProductOrder>();
    try{
        tx = session.beginTransaction();
        order = (List<ProductOrder>)session.createQuery("FROM ProductOrder o WHERE o.id.customerOrderId = :customerOrderId ")
                .setParameter("customerOrderId", id.toString()).list();
    }
    catch(Exception e){
        e.printStackTrace();
    }finally{
        sessionFactory.close();
    }
    return order;
     }
    
}
