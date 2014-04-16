/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

import hibernate.Product;
import java.util.Collection;

/**
 *
 * @author Anand
 */
public interface ProductDaoInterface {
        
        public Product getProduct(int productId);
       public Collection<Product> getProducts(String productKeyword);
       public int saveProduct(String name,float price,String description,String detail,String category,byte[] bytes,String sellerId);
}
