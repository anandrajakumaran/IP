/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Anand
 */
public class ChartResult implements Result{

    @Override
    public void execute(ActionInvocation invocation) throws Exception {
 
        ImageAction action = (ImageAction) invocation.getAction();
HttpServletResponse response = ServletActionContext.getResponse();


		response.setContentType("image/png");

		OutputStream outputStream = response.getOutputStream();

		JFreeChart chart = action.getChart();
		int width = 500;
		int height = 350;
		ChartUtilities.writeChartAsPNG(outputStream, chart, width, height);    }
    
}
