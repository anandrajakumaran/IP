<%@ taglib prefix="s" uri="/struts-tags"%>

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

<c:if test="${!empty customerList}">

    <table id="adminTable" class="detailsTable" >

        <tr class="header">
            <th colspan="5">Customers
                
                <s:a action="viewCustomerReport" cssStyle="float:right">
                <img src="/shoppingCart/img/excel.png"  alt="Excel Export">
                </s:a>
            </th>
        </tr>

        <tr class="tableHeading">
            <td>Customer id</td>
            <td>Name</td>
            <td>Address</td>
            <td>Email</td>
            <td>Phone</td>
        </tr>

        <c:forEach var="customer" items="${customerList}" varStatus="iter">

            <tr class="${((iter.index % 2) == 1) ? 'lightBlue' : 'white'} tableRow" " >

                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
            </tr>

        </c:forEach>

    </table>

</c:if>

<%-- orderList is requested --%>
<c:if test="${!empty orderList}">

    <table id="adminTable" class="detailsTable">

        <tr class="header">
            <th colspan="6">Transaction
                <s:a action="viewOrdersReport" style="float:right">
                <img src="/shoppingCart/img/excel.png"  alt="Excel Export">
                </s:a>
           
            </th>      
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

                <td> <fmt:formatDate value="${order.dateCreated}"
                      type="both"
                      dateStyle="short"
                      timeStyle="short"/></td>
            </tr>

        </c:forEach>
    </table>

</c:if>
