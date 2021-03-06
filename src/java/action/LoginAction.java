/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hibdao.LoginDao;
import hibernate.Customer;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Anand
 */
public class LoginAction extends ActionSupport {
    private String userName = "";
    private String password = "";
    private Customer customer;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
       public String execute() {
      
        System.out.println("Logn execute called");
        return SUCCESS;
    }
    
       public String getLoginUser() {
           
         String mapValue = "success";  
         LoginDao loginDao = new LoginDao();
                     HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
     HttpSession session = request.getSession(true);
     session = request.getSession();
   
		try {
                        customer=loginDao.findByIdAndPassword(userName, password);
                         if(customer != null)
                    {
                       // HttpSession session = request.getSession(true);
                       Map sessionMap = ActionContext.getContext().getSession();
                        session.setAttribute("custName",customer.getName());
                        session.setAttribute("user", customer.getId());
                        session.setAttribute("Cust", customer);
                        if("Y".equals(customer.getAdminFlag()))
                            {

                                session.setAttribute("adminAcc", "yes");
                            }
    //                        Map session = ActionContext.getContext().getSession();
    //                        session.put("user",user);
                    }
                }catch (Exception e) {
                    mapValue = "error";
			e.printStackTrace();
		}
		return mapValue;
	}
}
