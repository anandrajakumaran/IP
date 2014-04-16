<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="singleColumn">

    <c:choose>
        <c:when test="${cart.numberOfItems > 1}">
            <b>  Cart has ${cart.numberOfItems} items </b>
        </c:when>
        <c:when test="${cart.numberOfItems == 1}">
            <b> Cart has ${cart.numberOfItems} Items.</b>
        </c:when>
        <c:otherwise>
            <b> Cart is Empty</b>
        </c:otherwise>
    </c:choose>

    <div id="actionBar">
        <c:if test="${!empty cart && cart.numberOfItems != 0}">
            
            
            <c:url var="url" value="viewCart">
                <c:param name="clear" value="true"/>
            </c:url>  
          <a href="<c:url value='${url}'/>" style="float:left">
             <img src="/shoppingCart/img/emptycart.png"  alt="Empty cart">
          </a>
        </c:if>
        <c:set var="value">
            <c:choose>
                <c:when test="${!empty selectedCategory}">
                    category
                </c:when>
                <c:otherwise>
                    index.jsp
                </c:otherwise>
            </c:choose>
        </c:set>

        <c:url var="url" value="${value}"/>
            <a href="<c:url value='${url}'/>" style="float:middle">
             <img src="/shoppingCart/img/continue.png"  alt="Continue Shopping">
          </a>

        <%-- checkout widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">
                <a href="<c:url value='checkout'/>" style="float:right">
             <img src="/shoppingCart/img/buy.png"  alt="Proceed to Payment">
          </a>
        </c:if>
    </div>

    <c:if test="${!empty cart && cart.numberOfItems != 0}">

      <h4 id="subtotal">Total: $
          <fmt:formatNumber value="${cart.subtotal}"/>
      </h4>

      <table id="cartTable">

        <tr class="header">
            <th>Product</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>

        <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

          <c:set var="product" value="${cartItem.product}"/>

          <tr class="white">
            <td>
                   <s:url id="image" action="showImage" var="imageUrl">
                        <s:param name="productId">${product.id}</s:param>
                   </s:url>
                <img src="<s:property value="#imageUrl"/>"
                       alt="${product.name}">
            </td>

            <td>${product.name}</td>

            <td>
                <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${cartItem.total}"/>
                <br>
                <span class="smallText">(
                    <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${product.price}"/>
                    / item )</span>
            </td>

            <td>
                <s:form action="updateCart" method="post">
                    <input type="hidden"
                           name="productId"
                           value="${product.id}">
                    <input type="text"
                           maxlength="2"
                           size="2"
                           value="${cartItem.quantity}"
                           name="quantity"
                           style="margin:5px">
                    <input type="submit"
                           value="updateCart">
                </s:form >
            </td>
          </tr>

        </c:forEach>

      </table>

    </c:if>
</div>