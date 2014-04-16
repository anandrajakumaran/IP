/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import hibernate.Customer;
import hibernate.CustomerOrder;
import hibernate.Product;
import hibernate.ProductOrder;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import report.SalesReport;

/**e
 *
 * @author Anand
 */
public class CustomerReciptAction extends ActionSupport {
    
    public String customerRecipt() throws IOException{
    
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();

    HttpSession session = request.getSession();
    CustomerOrder customerOrder = (CustomerOrder)request.getSession().getAttribute("orderRecordMap");
        Customer customer = (Customer)request.getSession().getAttribute("customerMap");
        List<ProductOrder> orderedProducts = (List<ProductOrder>)request.getSession().getAttribute("orderedProductsMap");
        List<Product> products =(List<Product>)request.getSession().getAttribute("productsMap");
        
                HSSFWorkbook workBook = new HSSFWorkbook();
                SalesReport salesReport = new SalesReport();
                /** Date Time Format for Time Stamp */
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm");
                String dateFormat = simpleDateFormat.format(new Date());
                /**File Name for XLS File */
                String fileName= "Recipt_"+dateFormat;

              salesReport.customerReport(customerOrder,customer,orderedProducts,products, workBook, request);
                response.setContentType("application/vnd.ms-excel");
                /** Change attachment into inline, inorder to open the excel file in Readonly mode */
                response.setHeader("Content-disposition", "inline;filename="+fileName+".xls");

                workBook.write(response.getOutputStream());
                response.getOutputStream().close();
        return  SUCCESS;
        }
      
    
}
