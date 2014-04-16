/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import hibdao.TransactionDao;
import hibernate.Customer;
import hibernate.CustomerOrder;
import java.awt.Color;
import java.io.File;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

/**
 *
 * @author Anand
 */
public class GraphAction extends ActionSupport{
    
    private Date fromdate;
    private Date todate;

    public Date getFromdarte() {
        return fromdate;
    }

    public void setFromdarte(Date fromdarte) {
        this.fromdate = fromdarte;
    }

    public Date getToDate() {
        return todate;
    }

    public void setToDate(Date toDate) {
        this.todate = toDate;
    }
    
    
    public String resend(){
        
        return SUCCESS;
    }
    public String execute() throws ParseException {


     
        List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
                
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        
       SimpleDateFormat formatter = new SimpleDateFormat("yy-mm-dd");
       System.out.println("<------------- kjsdajsdn------------>"+request.getParameter("fromdate"));
       System.out.println("<------------- kjsdajsdn------------>"+request.getParameter("todate"));
        fromdate = formatter.parse(request.getParameter("fromdate")); 
        todate=formatter.parse(request.getParameter("todate"));
        TransactionDao transactionDao = new TransactionDao();
    //    orderList = transactionDao.findByDate(fromdate, todate);
       orderList = transactionDao.findAll();
        session.setAttribute("orderList", orderList);
        int a = orderList.size();
//        System.out.println("Size--->"+a);
//        Number[] values = getValues(orderList);
//        System.out.println("final values are "+Arrays.toString(values));
//  
//        final Number[][] data = new Number[][]{values, {}};
//
//        final CategoryDataset dataset
//                = DatasetUtilities.createCategoryDataset("", "", data);
//
//        JFreeChart chart = null;
//        BarRenderer renderer3D = null;
//        CategoryPlot plot = null;
//
//        final CategoryAxis3D categoryAxis = new CategoryAxis3D("Month");
//        final ValueAxis valueAxis = new NumberAxis3D("Bookings");
//        renderer3D = new BarRenderer3D();
//
//        plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer3D);
//        plot.setOrientation(PlotOrientation.VERTICAL);
//        chart = new JFreeChart("Booking Details", JFreeChart.DEFAULT_TITLE_FONT,
//                plot, true);
//
//        chart.setBackgroundPaint(new Color(249, 231, 236));
//
//        try {
//            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
//
//            final File file1 = new File("D:\\3dbarchart.png");
//             OutputStream out = ServletActionContext.getResponse().getOutputStream();
//            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
//          
//             ChartUtilities.writeChartAsPNG(out, chart, 600, 400, info);
//             
//           out.close();
//            //returnString = "success"; 
//            
//        } catch (Exception e) {
//            System.out.println(e);
//           // returnString = "error";
//        }

        return SUCCESS;
    }
    
    public Number[] getValues(List<CustomerOrder> orderList) {
        
        Number[] a=new Integer[12];
        Arrays.fill(a, 0);
        
           for ( int i =0;i<orderList.size();i++)
        {
         Date d=orderList.get(i).getDateCreated();
         Calendar cal = Calendar.getInstance();
         cal.setTime(d);
         int month = cal.get(Calendar.MONTH);
            System.out.println("month is"+month+" "+a[month]);        
            System.out.println("value  is"+month+" "+a[month].intValue()); 
            a[month] = a[month].intValue()+1;
        }
           
        return a;
    }
    
    public String drawgraph(){
        
        
        List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
                
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        TransactionDao transactionDao = new TransactionDao();
      //  orderList = transactionDao.findByDate(fromdate, todate);
       orderList =  (List<CustomerOrder>)request.getSession().getAttribute("orderList");
        int a = orderList.size();
        System.out.println("Size--->"+a);
        Number[] values = getValues(orderList);
        System.out.println("final values are "+Arrays.toString(values));
  
        final Number[][] data = new Number[][]{values, {}};

        final CategoryDataset dataset
                = DatasetUtilities.createCategoryDataset("", "", data);

        JFreeChart chart = null;
        BarRenderer renderer3D = null;
        CategoryPlot plot = null;

        final CategoryAxis3D categoryAxis = new CategoryAxis3D("Month");
        final ValueAxis valueAxis = new NumberAxis3D("Number of Transactions");
        renderer3D = new BarRenderer3D();

        plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer3D);
        plot.setOrientation(PlotOrientation.VERTICAL);
        chart = new JFreeChart("Online Transactions", JFreeChart.DEFAULT_TITLE_FONT,
                plot, true);

        chart.setBackgroundPaint(new Color(152, 169, 236));

        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());

            final File file1 = new File("D:\\3dbarchart.png");
             OutputStream out = ServletActionContext.getResponse().getOutputStream();
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
          
             ChartUtilities.writeChartAsPNG(out, chart, 600, 400, info);
             
           out.close();
            //returnString = "success"; 
            
        } catch (Exception e) {
            System.out.println(e);
           // returnString = "error";
        }
        return SUCCESS;
    }
}
