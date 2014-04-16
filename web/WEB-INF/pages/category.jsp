<%@ taglib prefix="s" uri="/struts-tags"%>

<% pageContext.setAttribute("javax.servlet.jsp.jstl.fmt.fallbackLocale.page", java.util.Locale.US); %>

<%
          if(session.getAttribute("user") == null)
            {
              response.sendRedirect("CustLogin.jsp");
            }
        %>
        


    <table style="border: none;padding-right: 7cm">
    <tr>
    <c:forEach var="category" items="${categories}">
        <td>
            
        <c:choose>
            <c:when test="${category.name == selectedCategory.name}">
                <div class="menuButton" id="selectedMenu">
                    <span class="menuText">
                      ${category.name}
                    </span>
                </div>
            </c:when>
            <c:otherwise>
             <s:url id="category" action="category" var="myurl">
                    <s:param name="categoryId">${category.id}</s:param>
            </s:url>
             <a href='<s:property value="#myurl"/>' class="menuButton">
                             <span class="menuText">${category.name}</span>
                </a>
            </c:otherwise>
        </c:choose>
        </td>
    </c:forEach>
</tr>
    </table>
<div id ="main" >

    <table id="" style="background-color: white;border-style: double;border-color: black">
    <tr>
        <c:forEach var="product" items="${categoryProducts}" varStatus="loop">
            <c:if test="${not loop.first and loop.index % 3 == 0}">
                </tr><tr>
            </c:if>
            <td width="20%">
                   <s:url id="viewProduct" action="viewProduct" var="viewProductUrl">
                        <s:param name="productId">${product.id}</s:param>
                   </s:url>
                <a href="<s:property value="#viewProductUrl"/>" style="">
                   <s:url id="image" action="showImage" var="imageUrl">
                        <s:param name="productId">${product.id}</s:param>
                   </s:url>
           
                <img src="<s:property value="#imageUrl"/>"
                         alt="${product.name}">    
                     <br>
                 <c:out value="${loop.count}"/> 
                           ${product.name} $
                          <fmt:formatNumber value="${product.price}"/>
                                          
                    <br>
                    </a>
                    <s:form action="addToCart" method="post" >

                        <input type="hidden"
                               name="productId"
                               value="${product.id}" />
                
                      <input type="submit"
                               value="addToCart">
                    </s:form>
                </td>
        </c:forEach>
    </tr>
</table>
</div>