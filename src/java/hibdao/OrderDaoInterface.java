/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import java.util.Map;
import shoppingCart.ShoppingCart;

/**
 *
 * @author Anand
 */
public interface OrderDaoInterface {
    public int placeOrder(String id,String name, String email, String phone,String mode, String address, String cardNumber, ShoppingCart cart);
    public Map getOrderDetails(int orderId) ;

}
