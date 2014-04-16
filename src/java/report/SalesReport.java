
package report;

import hibernate.Customer;
import hibernate.CustomerOrder;
import hibernate.Product;
import hibernate.ProductOrder;
import java.math.BigDecimal;
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
public class SalesReport {
    	public HSSFSheet customerReport( CustomerOrder customerOrder, Customer customer,  List<ProductOrder> orderedProducts, List<Product> products,HSSFWorkbook workBook,HttpServletRequest request) {
	      
		/** Gettting Local For Displaying in Different Lanagauge */
		/** Create a New Sheet */
		HSSFSheet newInventorySheet = workBook.createSheet("Reciept");

		try {		
			HSSFRow hssfRow;
			HSSFCell cell;			
			/** Style for Cell Data */
			HSSFCellStyle cellStyle = applyStyle(workBook);
			
			/** Style for HEader */
			HSSFCellStyle headerStyle = workBook.createCellStyle();
                        HSSFCellStyle titleStyle = workBook.createCellStyle();
                        
                        HSSFFont titleFont = workBook.createFont();
			HSSFFont headerfont = workBook.createFont();
			
			/** Setting font background and foreground color */
			headerStyle.setFillForegroundColor(HSSFColor.TEAL.index);
			headerStyle.setFillBackgroundColor(HSSFColor.WHITE.index);		
			headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);		
			
			headerfont.setColor(HSSFColor.WHITE.index);			
			headerfont.setFontHeightInPoints((short)14);			
			headerStyle.setFont(headerfont);			
			
                        titleFont.setColor(HSSFColor.BLACK.index);			
			titleFont.setFontHeightInPoints((short)28);	
                        titleFont.setBoldweight((short)28);
			titleStyle.setFont(titleFont);
                                
			hssfRow = newInventorySheet.createRow((short)0);	
			
			/** Vertical Id */
			cell = hssfRow.createCell(0);				
			cell.setCellValue("Sale Reciept");
			cell.setCellStyle(titleStyle);
			
			 hssfRow = newInventorySheet.createRow((short)(1));
                        
                        cell = hssfRow.createCell(1);				
			cell.setCellValue("Confirmation Number");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(2);			
                        cell.setCellValue(customerOrder.getConfirmationNumber());
                        cell.setCellStyle(cellStyle);	
            
                        
                       hssfRow = newInventorySheet.createRow((short)(2));
                        
                        cell = hssfRow.createCell(1);				
			cell.setCellValue("Name");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(2);			
                        cell.setCellValue(customer.getName());
                        cell.setCellStyle(cellStyle);	
                        
                        hssfRow = newInventorySheet.createRow((short)(3));
                        
                        cell = hssfRow.createCell(1);				
			cell.setCellValue("Phone");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(2);			
                        cell.setCellValue(customer.getPhone());
                        cell.setCellStyle(cellStyle);	
                        
                        hssfRow = newInventorySheet.createRow((short)(4));
                        
                        cell = hssfRow.createCell(1);				
			cell.setCellValue("Address");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(2);			
                        cell.setCellValue(customer.getAddress());
                        cell.setCellStyle(cellStyle);	
                        
                        hssfRow = newInventorySheet.createRow((short)(5));
                        
                        cell = hssfRow.createCell(1);				
			cell.setCellValue("Mode");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(2);			
                        cell.setCellValue(customerOrder.getModePayment());
                        cell.setCellStyle(cellStyle);	
                        
                        hssfRow = newInventorySheet.createRow((short)(7));
                        
                        cell = hssfRow.createCell(1);				
			cell.setCellValue("Product");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(2);				
			cell.setCellValue("Quantity");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(3);				
			cell.setCellValue("Price");
			cell.setCellStyle(headerStyle);
                        

                         int j = 8;                       
                        for(int i = 0;i < orderedProducts.size();i++){
                           
                        hssfRow = newInventorySheet.createRow((short)(j));
                        j++;
                            
                        cell = hssfRow.createCell(1);			
                        cell.setCellValue(products.get(i).getName());
                        cell.setCellStyle(cellStyle);
                        
                        cell = hssfRow.createCell(2);			
                        cell.setCellValue(orderedProducts.get(i).getQuantity());
                        cell.setCellStyle(cellStyle);
                        
                        cell = hssfRow.createCell(3);			
                        cell.setCellValue(products.get(i).getPrice().shortValue() * orderedProducts.get(i).getQuantity() );
                        cell.setCellStyle(cellStyle);
                        }
                        
                       hssfRow = newInventorySheet.createRow((short)(j));
                       
                        cell = hssfRow.createCell(2);				
			cell.setCellValue("Total");
			cell.setCellStyle(headerStyle);
                        
                        cell = hssfRow.createCell(3);			
                        cell.setCellValue( customerOrder.getAmount().toPlainString());
                        cell.setCellStyle(cellStyle);

		     for(int i=0;i<67;i++)
		     {
		    	 newInventorySheet.autoSizeColumn((short)i);
		     }
		} catch (Exception e) {
			System.out.println("Exception occurs while generating Recipet Export : "+e.getMessage());
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
        font.setFontHeightInPoints((short)14);		    
	    
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