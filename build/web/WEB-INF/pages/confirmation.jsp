<%@ taglib prefix="s" uri="/struts-tags"%>


<div id="singleColumn" >   
    <div class="summaryColumn" >

         <p id="confirmationMessage">
        <strong>Order has been Placed Successfully</strong>
        <br>
            <strong>A Confirmation email has been sent to your registered email id</strong>
         <br>        
            Confirmation Number
        <strong>${orderRecordMap.confirmationNumber}</strong>
        <br>
    </p>
            
        <table id="registerTable" >
            <tr class="header">
                <th colspan="3">Purchase Summary</th>
            </tr>

            <tr class="tableHeading">
                <td>Product</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quantity</td>
                <td>Price</td>
            </tr>

            <c:forEach var="orderedProductMap" items="${orderedProductsMap}" varStatus="iter">

                <tr class="${((iter.index % 2) != 0) ? 'lightBlue' : 'white'}">
                    <td>
                       ${productsMap[iter.index].name}
                    </td>
                    <td class="quantityColumn">
                        ${orderedProductMap.quantity}
                    </td>
                    <td class="confirmationPriceColumn">
                        <fmt:formatNumber type="currency" currencySymbol="&dollar; "
                                          value="${productsMap[iter.index].price * orderedProductMap.quantity}"/>
                    </td>
                </tr>

            </c:forEach>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="2" id="totalCellLeft"><strong>Total:</strong></td>
                <td id="totalCellRight">
                    <fmt:formatNumber type="currency"
                                      currencySymbol="&dollar; "
                                      value="${orderRecordMap.amount}"/></td>
            </tr>

            <tr class="lightBlue"><td colspan="3" style="padding: 0 20px"><hr></td></tr>

            <tr class="lightBlue">
                <td colspan="3" id="dateProcessedRow"><strong>Order Time:</strong>
                    <fmt:formatDate value="${orderRecordMap.dateCreated}"
                                    type="both"
                                    dateStyle="short"
                                    timeStyle="short"/></td>
            </tr>
        </table>

    </div>

    <div class="summaryColumn" >
                
                <td>
                 <s:a action="customerRecipt" style="float:right">
                   Click to download the reciept <img src="/shoppingCart/img/excel.png"  alt="Excel Export">
                </s:a>
                </td>
                
            </tr>
        </table>
    </div>
</div>