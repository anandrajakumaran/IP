/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibdao;

/**
 *
 * @author DealGuru
 */
public interface RegisterDaoInterface {
    
         public int saveRegisteration(String name, String email, String phone,String username,String password,String address);

}
