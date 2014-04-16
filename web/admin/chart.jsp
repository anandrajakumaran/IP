<%-- 
    Document   : chart
    Created on : Apr 11, 2014, 7:29:53 AM
    Author     : Anand
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>   

<!-- add styles -->
<link href="css/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css" />

<!-- add scripts -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script>
$(function(){
  $.datepicker.setDefaults(
    $.extend($.datepicker.regional[''])
   
  );
  $('#datepicker').datepicker({
       dateFormat: 'yy-dd-mm'
  });
  $('#datepicker1').datepicker({
       dateFormat: 'yy-dd-mm'
  });});
</script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

       <table style="border: none;padding-right: 7cm">
    <tr>
           <td>
                <a href="<c:url value='addProduct'/>" class="menuButton">
                    <span class="menuText">
                        Add Product
                    </span>
                </a>
          </td>   
        <td>
                <a href="<c:url value='viewOrders'/>" class="menuButton">
                    <span class="menuText">
                      View Transaction
                    </span>
                </a>
          <td>          
          <td>
                  <s:a action="viewCustomers" cssClass="menuButton">
                    <span class="menuText">
                      View Customers
                    </span>
                </s:a>
  
        </td>
           <td>
                  <s:a action="resend" cssClass="menuButton">
                    <span class="menuText">
                      View Chart
                    </span>
                </s:a>
  
        </td>
    
    
</tr>
    </table>
    
         <s:form action="graph" method="post" >
         From Date :  <input type="text" id="datepicker" name="fromdate" />
         To Date   :  <input type="text" id="datepicker1" name="todate"/>
             
                       <input type="submit"
                          
                               value="Show Graph">
         </s:form>

    </body>
</html>
