<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>   

<%
    
  if(session.getAttribute("user") == null)
    {
      response.sendRedirect("CustLogin.jsp");
    }
%>
<table style="border: none">
    <tr>
    <c:forEach var="category" items="${categories}">
             <s:url id="category" action="category" var="myurl">
                    <s:param name="categoryId">${category.id}</s:param>
            </s:url>

         
        <td>
        <div class="menuButton">
              <a href='<s:property value="#myurl"/>'>
                             <span class="menuText">${category.name}</span>
                </a>
        </div>
        </td>
    </c:forEach>
    </tr>
</table>

<div id="singleColumn" style="background-color: white">
<table  style="width:18cm;background-color: white">
    <B> <p style="font-size: larger">Welcome!!!</p></b>
     <B>   <p>Lot of offers in place shop soon</p></b>
        ShoppingCart is a leading destination for online shopping , offering some of the best prices and a<br>
         completely hassle-free experience with options of paying through Cash on Delivery, Debit Card<br> 
        Credit Card and Net Banking processed through secure and trusted gateways. <br>
        Now shop for your favorite books, apparel, footwear, lifestyle accessories, baby care products,<br>
         toys, posters, sports and fitness, mobile phones, laptops,cameras, movies, music and products <br>
        from a host of other categories available.Some of the top selling electronic brands<br>
         on the website are Samsung, HTC, Nokia,Dell, HP, Sony, Canon, Nikon, LG, Toshiba, Philips, <br>
         Braun, Bajaj and Morphy Richards.
</table>
</div>