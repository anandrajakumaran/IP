/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hibdao.ProductDao;
import hibernate.Product;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import shoppingCart.ShoppingCart;
import validate.Validator;

/**
 *
 * @author Anand
 */
public class CartAction extends ActionSupport   {

    private String productId;
    private ShoppingCart cart;
    private String clear;
    private String quantity;
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String addToCart() {
            Map sessionMap = ActionContext.getContext().getSession();

        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

         ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        ProductDao productDao = new ProductDao();
        if(cart == null){
            cart = new ShoppingCart();
           sessionMap.put("cart", cart);
           session.setAttribute("cart", cart);

        }
        
        Product product = productDao.getProduct(Integer.parseInt(productId));
        cart.addItem(product);
        return SUCCESS;
    }
    
    public String viewCart(){
         HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        if ((clear != null) && clear.equals("true")) {

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            cart.clear();
            }
      return SUCCESS;  
    }
    
    public String updateCart(){
        ProductDao productDao = new ProductDao();
          HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

         ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Validator validator = new Validator();
        boolean invalidEntry = validator.validateQuantity(productId, quantity);
        if (!invalidEntry) {

                Product product = productDao.getProduct(Integer.parseInt(productId));
                cart.update(product, quantity);
            }
        return SUCCESS;
    }
}
