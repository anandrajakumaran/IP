 <table style="border: none;padding-right: 7cm">
    <tr>
        <td>
                <a href="<c:url value='viewOrders'/>" class="menuButton">
                    <span class="menuText">
                      View Orders
                    </span>
                </a>
          <td>          
          <td>
                  <a href="<c:url value='viewCustomers'/>" class="menuButton">
                    <span class="menuText">
                      View Customers
                    </span>
                </a>
  
        </td>
            <td>
                <a href="<c:url value='addProduct'/>" class="menuButton">
                    <span class="menuText">
                        Add Product
                    </span>
                </a>
          <td>       
</tr>
    </table>
<!--<div id="adminMenu" class="alignLeft">
    <p><a href="<c:url value='viewCustomers'/>">view all customers</a></p>

    <p><a href="<c:url value='viewOrders'/>">view all orders</a></p>

    <p><a href="<c:url value='logout'/>">log out</a></p>
</div>-->

<%-- customerList is requested --%>
<c:if test="${!empty customerList}">

    <table id="adminTable" class="detailsTable" >

        <tr class="header">
            <th colspan="4">customers</th>
            <td>
                
                  <a href="<c:url value='viewCustomers?report'/>" class="menuButton">
                    <span class="menuText">
                        Export
                    </span>
                </a>
            </td>
        </tr>

        <tr class="tableHeading">
            <td>customer id</td>
            <td>name</td>
            <td>email</td>
            <td>phone</td>
        </tr>

        <c:forEach var="customer" items="${customerList}" varStatus="iter">

            <tr class="${((iter.index % 2) == 1) ? 'lightBlue' : 'white'} tableRow"
                onclick="document.location.href='customerRecord?${customer.id}'">

              <%-- Below anchor tags are provided in case JavaScript is disabled --%>
                <td><a href="customerRecord?${customer.id}" class="noDecoration">${customer.id}</a></td>
                <td><a href="customerRecord?${customer.id}" class="noDecoration">${customer.name}</a></td>
                <td><a href="customerRecord?${customer.id}" class="noDecoration">${customer.email}</a></td>
                <td><a href="customerRecord?${customer.id}" class="noDecoration">${customer.phone}</a></td>
            </tr>

        </c:forEach>

    </table>

</c:if>

<%-- orderList is requested --%>
<c:if test="${!empty orderList}">

    <table id="adminTable" class="detailsTable">

        <tr class="header">
            <th colspan="4">orders</th>
        </tr>

        <tr class="tableHeading">
            <td>Order id</td>
            <td>Customer id</td>
            <td>Confirmation number</td>
            <td>Mode</td>
            <td>Amount</td>
            <td>Date created</td>
        </tr>

        <c:forEach var="order" items="${orderList}" varStatus="iter">

            <tr class="${((iter.index % 2) == 1) ? 'lightBlue' : 'white'} tableRow"
                onclick="document.location.href='orderRecord?${order.id}'">

              <%-- Below anchor tags are provided in case JavaScript is disabled --%>
                <td>${order.id}</a></td>
                <td>${order.customer.id}</a></td>
                <td>${order.confirmationNumber}</td>
                <td>${order.modePayment}</td>
                <td>
                        <fmt:formatNumber type="currency"
                                          currencySymbol="&dollar; "
                                          value="${order.amount}"/></a></td>

                <td><a href="orderRecord?${order.id}" class="noDecoration">
                        <fmt:formatDate value="${order.dateCreated}"
                                        type="both"
                                        dateStyle="short"
                                        timeStyle="short"/></a></td>
            </tr>

        </c:forEach>

    </table>

</c:if>