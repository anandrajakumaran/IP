/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hibdao.CategoryDao;
import hibdao.LoginDao;
import hibdao.OrderDao;
import hibdao.ProductDao;
import hibernate.Category;
import hibernate.Customer;
import hibernate.CustomerOrder;
import hibernate.Product;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import shoppingCart.ShoppingCart;


/**
 *
 * @author Anand
 */
public class ShoppingAction extends ActionSupport{
    private SessionFactory sessionFactory ;
    private org.hibernate.Session hibsession ;
    
    private List<Category> fetchCategories;
    private Category category;
    private Product product;
    private Customer customer;
    private Customer seller;
    private String categoryId;
    private String productId;
    private String search;
    public List<Category> getFetchCategories() {
        return fetchCategories;
    }

    public void setFetchCategories(List<Category> fetchCategories) {
        this.fetchCategories = fetchCategories;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setSeller(Customer seller) {
        this.seller = seller;
    }
    
     public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getHibsession() {
        return hibsession;
    }

    public void setHibsession(Session hibsession) {
        this.hibsession = hibsession;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public String execute(){
        CategoryDao categoryDao = new CategoryDao();
        Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("categories", categoryDao.fetchCategories());
        return "success";
    }

   
    
        public String showCategoryProducts(){
                Collection<hibernate.Product> categoryProducts;
  
        if (categoryId != null) {
                
         Category category = new Category();
    sessionFactory    = new Configuration().configure().buildSessionFactory();
    hibsession       = sessionFactory.openSession();
    Transaction tx = null;
                           Map session = ActionContext.getContext().getSession();

    try{
        tx = hibsession.beginTransaction();
        category = (Category)hibsession.createQuery("FROM Category c WHERE c.id = :id")
                .setParameter("id", Integer.parseInt(categoryId)).uniqueResult();
                              session.put("selectedCategory", category);
                categoryProducts = category.getProducts();
               session.put("categoryProducts", categoryProducts);

    }
    catch(HibernateException e){
        e.printStackTrace();
    }finally{
       
    }
       }
    return SUCCESS;

 }
        
       public String viewProduct()
      {
            System.out.println("THIS METHOD IS CALLED");
          ProductDao productDao = new ProductDao();
          LoginDao loginDao = new LoginDao();
            System.out.println("PRODUCT ID IS"+productId);
          Product product = productDao.getProduct(Integer.parseInt(productId));
           seller = (Customer)loginDao.findById(product.getSellerId());
             Map sessionMap = ActionContext.getContext().getSession();
        sessionMap.put("productDetails", product);
     
          System.out.println("SELLER IS"+seller.getAddress());
        sessionMap.put("seller", seller);
        return SUCCESS;
            
        }
       
     public String searchProduct(){
        Collection<Product> searchProducts;

        ProductDao productDao = new ProductDao();
         HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        if(search != null){
                searchProducts = productDao.getProducts(search);    
                session.setAttribute("searchProducts", searchProducts);
                System.out.println("categoryProducts-->"+searchProducts.size());
            }
         
         return SUCCESS;
     }
     
   public String checkout(){
    LoginDao loginDao = new LoginDao();
    HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
         customer =  loginDao.findById( (String) session.getAttribute("user"));

              if(customer != null)
                {
               session.setAttribute("customer", customer);
        }   
         
        
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

            // calculate total
            cart.calculateTotal("0");
         return SUCCESS;
     }
   
   public String purchase(){
         HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
            LoginDao loginDao = new LoginDao();

        String mapValue = "success";
                 customer =  loginDao.findById( (String) session.getAttribute("user"));

         ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
         
         if (cart != null) {
             
                OrderDao orderDao = new OrderDao();
                String userId = customer.getId();
                String name = customer.getName();
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String mode = request.getParameter("dropdown");
                String cardNumber = request.getParameter("creditcard");
                System.out.println("Indied Customer Report");
             
                System.out.println("Inside Oreder Placement-->");
                   int orderId = orderDao.placeOrder(userId,name, email, phone, mode,address,cardNumber, cart);
                   System.out.println("Order ID---"+orderId);
                    if (orderId != 0) {
                        System.out.println("OrderId--->"+orderId);
                       
                        cart = null;

                        // get order details
                        Map orderMap = orderDao.getOrderDetails(orderId);
                        
                          CustomerOrder order = (CustomerOrder)orderMap.get("orderRecord");
                        // place order details in request scope
                        request.getSession().setAttribute("customerMap", orderMap.get("customer"));
                        request.getSession().setAttribute("productsMap", orderMap.get("products"));
                        request.getSession().setAttribute("orderRecordMap", orderMap.get("orderRecord"));
                        request.getSession().setAttribute("orderedProductsMap", orderMap.get("orderedProducts"));
                        
                      request.getSession().removeAttribute("cart");
                      
         
		try {
                Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		javax.mail.Session mailSession = null;
                mailSession = javax.mail.Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("shoppingcartreply@gmail.com","shoppingpassword");
				}
			});
 
 
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("shoppingcartreply@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Shopping Cart Confirmation : "+order.getConfirmationNumber());
			message.setText("Dear" + name + "\n" + 
					" This is to confirm your order in Shopping card " + "\n" 
                                        + "Confirmation Number :" + order.getConfirmationNumber() + "\n" + 
                                          "Amount :" +order.getAmount() +  "\n" + 
                                          "Mode :" +order.getModePayment() );
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
   }
   }else {
                    mapValue = "failure";
                    request.setAttribute("orderFailureFlag", true);
                    }
                 return mapValue;

}
}