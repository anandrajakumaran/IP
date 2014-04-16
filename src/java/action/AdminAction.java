/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import hibdao.LoginDao;
import hibdao.ProductDao;
import hibdao.TransactionDao;
import hibernate.Customer;
import hibernate.CustomerOrder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import report.AdminReport;

/**
 *
 * @author Anand
 */
public class AdminAction extends ActionSupport implements  ServletRequestAware{
    private HttpServletRequest request;

    private String  name;
    private Float price;
    private String description;
    private String detail;
    private File image;
    private String category;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    @Override
    public String execute(){
        
        return SUCCESS;
    }
    
    public String viewCustomers(){
    LoginDao loginDao = new LoginDao();

    List<Customer> customerList = new ArrayList<Customer>();

    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();

    HttpSession session = request.getSession();
    
    customerList = loginDao.findAll();
    request.setAttribute("customerList", customerList);

        return SUCCESS;
        
    }
    
    public String viewCustomerReport() throws IOException{
         LoginDao loginDao = new LoginDao();

    List<Customer> customerList = new ArrayList<Customer>();

    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    customerList = loginDao.findAll();

    HttpSession session = request.getSession();
      HSSFWorkbook workBook = new HSSFWorkbook();
                AdminReport customerReport = new AdminReport();
                /** Date Time Format for Time Stamp */
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm");
                String dateFormat = simpleDateFormat.format(new Date());
                /**File Name for XLS File */
                String fileName= "Customer_"+dateFormat;

               // excelWriter.inventoryExport(lst, workBook, request);
                customerReport.customerExport(customerList, workBook, request);
                response.setContentType("application/vnd.ms-excel");
                /** Change attachment into inline, inorder to open the excel file in Readonly mode */
                response.setHeader("Content-disposition", "inline;filename="+fileName+".xls");

                workBook.write(response.getOutputStream());
                response.getOutputStream().close();
    
        return SUCCESS;
        
    }
    
    public String viewOrders(){
                    TransactionDao transactionDao = new TransactionDao();
List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
  CustomerOrder order;
   HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
            orderList = transactionDao.findAll();
                 request.setAttribute("orderList", orderList);   

        return SUCCESS;
    }
    
    
    public String viewOrdersReport() throws IOException{
        TransactionDao transactionDao = new TransactionDao();
        List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
        CustomerOrder order;
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        orderList = transactionDao.findAll();
         HSSFWorkbook workBook = new HSSFWorkbook();
                AdminReport customerReport = new AdminReport();
                /** Date Time Format for Time Stamp */
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm");
                String dateFormat = simpleDateFormat.format(new Date());
                /**File Name for XLS File */
                String fileName= "Order_"+dateFormat;

               // excelWriter.inventoryExport(lst, workBook, request);
                customerReport.orderExport(orderList, workBook, request);
                response.setContentType("application/vnd.ms-excel");
                /** Change attachment into inline, inorder to open the excel file in Readonly mode */
                response.setHeader("Content-disposition", "inline;filename="+fileName+".xls");

                workBook.write(response.getOutputStream());
                response.getOutputStream().close();

        return SUCCESS;
    }
    
    public String logout(){
            HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
     HttpSession session = request.getSession(true);
     session = request.getSession();
     session.invalidate();   // terminate session
        return SUCCESS;
    }
    
    public String addProduct(){
        
        return SUCCESS;
    }
    
    public String saveProduct() throws IOException, ServletException, FileUploadException{
        
          ProductDao productDao = new ProductDao();
    HttpServletResponse response = ServletActionContext.getResponse();
        HttpSession session = request.getSession(true);
          
String sellerId= session.getAttribute("user").toString();

System.out.println("THE SELLER ID IS "+sellerId);
             byte[] bytes = new byte[1024*1024]; // some maximum size
             InputStream filecontent = new FileInputStream(image);
                                         int byteSize = filecontent.read(bytes);
                                         int i =   productDao.saveProduct(name,price,description,detail,category,bytes,sellerId);
   
            
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }
}
