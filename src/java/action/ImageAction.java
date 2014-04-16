/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionSupport;
import hibdao.ProductDao;
import hibernate.Product;
import java.io.BufferedOutputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
  import  java.awt.*;
import java.awt.image.RenderedImage;
 import  java.io.*;
 import  org.jfree.chart.*;
 import  org.jfree.chart.axis.*;
 import org.jfree.chart.entity.*;
 import  org.jfree.chart.labels.*;
 import  org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
 import org.jfree.chart.urls.* ;
 import org.jfree.data.category.*;
 import org.jfree.data.general.*;


/**
 *
 * @author Anand
 */
public class ImageAction extends ActionSupport implements ServletRequestAware {
     private String productId;
     private HttpServletRequest request;
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    	public String execute() {
		return SUCCESS;
	}
    public byte[] getCustomImageInBytes() throws IOException {
        ProductDao productDao = new ProductDao();
            HttpServletResponse response = ServletActionContext.getResponse();

           
     //ServletOutputStream sos = response.getOutputStream();
            //response.setContentType("image/png");
            

            Product product = productDao.getProduct(Integer.parseInt(productId));
             byte[] imgBytes = product.getImage();
            System.out.println(" imgBytes "+imgBytes);
            if (imgBytes != null) {
                    // Prepare streams.
            BufferedOutputStream output = null;
            // Init servlet response.
//            response.reset();
//            response.setBufferSize(10240);
//            response.setContentType("image/png");
//            response.setContentLength(imgBytes.length);
//            response.setHeader("Content-Disposition", "inline; filename=\"sss\"");
            try {
            // Open streams.
              //  output = new BufferedOutputStream(response.getOutputStream(), 10240);

                // Write file contents to response.
            //output.write(imgBytes);
            } finally {
                // Gently close streams.
             if (output != null) {
                try {
                       output.close();
                } catch (IOException e) {
                 e.printStackTrace();
               }
              }               
             }
            } 
               // sos.close(); 
                return imgBytes;
    }


    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }
 
    public JFreeChart getChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Ford", 23.3);
		dataset.setValue("Chevy", 32.4);
		dataset.setValue("Yugo", 44.2);

		boolean legend = true;
		boolean tooltips = false;
		boolean urls = false;

		JFreeChart chart = (JFreeChart)ChartFactory.createPieChart("Cars", dataset, legend, tooltips, urls);

		chart.setBorderPaint(Color.GREEN);
		chart.setBorderStroke(new BasicStroke(5.0f));
		chart.setBorderVisible(true);

		return chart;
	}
}
