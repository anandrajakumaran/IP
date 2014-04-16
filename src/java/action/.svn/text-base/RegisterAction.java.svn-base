/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hibdao.RegisterDao;
import java.util.Map;
import validate.Validator;

/**
 *
 * @author Anand
 */
public class RegisterAction extends ActionSupport {
    
    private String name; 
    private  String email; 
    private String phone; 
    private String username;
    private String address; 
    private String password;
    private String confirm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
    public String execute(){
        
     System.out.println("Register execute called");
     return SUCCESS;    
    }
    
    public String saveRegister(){
                               
        Map sessionMap = ActionContext.getContext().getSession();
        String mappingValue = "";
        Validator validator = new Validator();
        RegisterDao registerDao = new RegisterDao();
        boolean registerValidation = false;
         try{
        registerValidation = validator.validateRegisteration(name,email,phone,username,password,confirm,address,sessionMap);
        if(registerValidation == true)
        {
            sessionMap.put("validationErrorFlag", registerValidation);
            mappingValue = "error";
        }  else if( registerDao.saveRegisteration(name, email, phone,username, password, address) == 1) {

        mappingValue = "success";
        } else if(registerDao.saveRegisteration(name, email, phone,username, password, address) == 0){
                    mappingValue = "failure";
        }
         }catch(Exception e)
         {
              mappingValue = "failure";
             e.printStackTrace();
         }
        return mappingValue;
        
    }
}
