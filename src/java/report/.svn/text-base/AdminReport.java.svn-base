
package report;

import hibernate.Customer;
import hibernate.CustomerOrder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author Anand
 */
public class AdminReport {
    	public HSSFSheet customerExport(List<Customer> customerList,HSSFWorkbook workBook,HttpServletRequest request) {
	      
		/** Gettting Local For Displaying in Different Lanagauge */
		/** Create a New Sheet */
		HSSFSheet newInventorySheet = workBook.createSheet("Customers");

		try {		
			HSSFRow hssfRow;
			HSSFCell cell;			
			/** Style for Cell Data */
			HSSFCellStyle cellStyle = applyStyle(workBook);
			
			/** Style for HEader */
			HSSFCellStyle headerStyle = workBook.createCellStyle();
			HSSFFont headerfont = workBook.createFont();
			
			/** Setting font background and foreground color */
			headerStyle.setFillForegroundColor(HSSFColor.TEAL.index);
			headerStyle.setFillBackgroundColor(HSSFColor.WHITE.index);		
			headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);		
			
			headerfont.setColor(HSSFColor.WHITE.index);			
			headerfont.setFontHeightInPoints((short)10);			
			headerStyle.setFont(headerfont);			
			
			hssfRow = newInventorySheet.createRow((short)0);	
			
			/** Vertical Id */
			cell = hssfRow.createCell(0);				
			cell.setCellValue("ID");
			cell.setCellStyle(headerStyle);
			
			/** Domain Id */
			cell = hssfRow.createCell(1);				
			cell.setCellValue("Name");
			cell.setCellStyle(headerStyle);
			
			/** Sub Domain Id */
                        cell = hssfRow.createCell(2);			
			cell.setCellValue("Email");
			cell.setCellStyle(headerStyle);
			
			/** Application Name */
			cell = hssfRow.createCell(3);			
			cell.setCellValue("Phone");
			cell.setCellStyle(headerStyle);
			
			/** project Version */
			cell = hssfRow.createCell(4);			
			cell.setCellValue("Address");
			cell.setCellStyle(headerStyle);
			
                        
			
		     for(int i = 0;i < customerList.size();i++) {
		    	
		    	 
		    	 /** Create a New Row */
		    	 hssfRow = newInventorySheet.createRow((short)(i+1));
		    	  	
		    	  	/**  */
		    		cell = hssfRow.createCell(0);			
					cell.setCellValue(customerList.get(i).getId());
					cell.setCellStyle(cellStyle);
					
		    	  	/**  */
		    		cell = hssfRow.createCell(1);			
					cell.setCellValue(customerList.get(i).getName());
					cell.setCellStyle(cellStyle);
					
					/**  */
					cell = hssfRow.createCell(2);			
					cell.setCellValue(customerList.get(i).getEmail());
					cell.setCellStyle(cellStyle);
					
					/**  */
					cell = hssfRow.createCell(3);			
					cell.setCellValue(customerList.get(i).getPhone());
					cell.setCellStyle(cellStyle);
					
					/** */
					cell = hssfRow.createCell(4);			
					cell.setCellValue(customerList.get(i).getAddress());
					cell.setCellStyle(cellStyle);			
					
		     }

		     for(int i=0;i<67;i++)
		     {
		    	 newInventorySheet.autoSizeColumn((short)i);
		     }
		} catch (Exception e) {
			System.out.println("Exception occurs while generating Inventory Export : "+e.getMessage());
		}
		return newInventorySheet;
        }
   
        
        public HSSFSheet orderExport(List<CustomerOrder> orderList,HSSFWorkbook workBook,HttpServletRequest request) {
	      
		/** Gettting Local For Displaying in Different Lanagauge */
		/** Create a New Sheet */
		HSSFSheet newInventorySheet = workBook.createSheet("Orders");

		try {		
			HSSFRow hssfRow;
			HSSFCell cell;			
			/** Style for Cell Data */
			HSSFCellStyle cellStyle = applyStyle(workBook);
			
			/** Style for HEader */
			HSSFCellStyle headerStyle = workBook.createCellStyle();
			HSSFFont headerfont = workBook.createFont();
			
			/** Setting font background and foreground color */
			headerStyle.setFillForegroundColor(HSSFColor.TEAL.index);
			headerStyle.setFillBackgroundColor(HSSFColor.WHITE.index);		
			headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);		
			
			headerfont.setColor(HSSFColor.WHITE.index);			
			headerfont.setFontHeightInPoints((short)10);			
			headerStyle.setFont(headerfont);			
			
			hssfRow = newInventorySheet.createRow((short)0);	
			
			
			cell = hssfRow.createCell(0);				
			cell.setCellValue("Order ID");
			cell.setCellStyle(headerStyle);
			
			
			cell = hssfRow.createCell(1);				
			cell.setCellValue("Customer Id");
			cell.setCellStyle(headerStyle);
			
			
                        cell = hssfRow.createCell(2);			
			cell.setCellValue("Amount");
			cell.setCellStyle(headerStyle);
			
			
			cell = hssfRow.createCell(3);			
			cell.setCellValue("Date Created");
			cell.setCellStyle(headerStyle);
			
			
			cell = hssfRow.createCell(4);			
			cell.setCellValue("Mode");
			cell.setCellStyle(headerStyle);
			
                        
			cell = hssfRow.createCell(5);			
			cell.setCellValue("Confirmattion Number");
			cell.setCellStyle(headerStyle);
			 
		     for(int i = 0;i < orderList.size();i++) {
		    	
		    	 /** Create a New Row */
		    	 hssfRow = newInventorySheet.createRow((short)(i+1));
		    	  	
		    	  	/**  */
		    		cell = hssfRow.createCell(0);			
					cell.setCellValue(orderList.get(i).getId());
					cell.setCellStyle(cellStyle);
					
		    	  	/**  */
		cell = hssfRow.createCell(1);			
					cell.setCellValue(orderList.get(i).getCustomer().getId());
				    	cell.setCellStyle(cellStyle);
					
					/**  */
					cell = hssfRow.createCell(2);			
					cell.setCellValue( orderList.get(i).getAmount().toPlainString());
					cell.setCellStyle(cellStyle);
                                        
                                        
					/**  */
					cell = hssfRow.createCell(3);			
					cell.setCellValue(orderList.get(i).getDateCreated());
					cell.setCellStyle(cellStyle);
					
					/**  */
					cell = hssfRow.createCell(4);			
					cell.setCellValue(orderList.get(i).getModePayment());
					cell.setCellStyle(cellStyle);
					
					/** */
					cell = hssfRow.createCell(5);			
					cell.setCellValue(orderList.get(i).getConfirmationNumber());
					cell.setCellStyle(cellStyle);			
					
		     }

		     for(int i=0;i<67;i++)
		     {
		    	 newInventorySheet.autoSizeColumn((short)i);
		     }
		} catch (Exception e) {
			System.out.println("Exception occurs while generating Inventory Export : "+e.getMessage());
		}
		return newInventorySheet;
        }
     private HSSFCellStyle applyStyle (HSSFWorkbook workBook) {
        /** Create Cell style */
        HSSFCellStyle cellStyle = workBook.createCellStyle();
        /** Create Cell Font */ 
        HSSFFont font = workBook.createFont();
        /** Set Cell Color, font name and font height */
        font.setColor(HSSFColor.BLACK.index);
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short)10);		    
	    
	    /** set Background and cell alignment */
        cellStyle.setFont(font);
        cellStyle.setFillBackgroundColor(HSSFColor.WHITE.index);
        cellStyle.setAlignment((short) 1);

        /** Set Cell Border */
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

            return cellStyle;
	}       
}