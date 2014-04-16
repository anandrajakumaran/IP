<script src="js/jquery.validate.js" type="text/javascript"></script>

<script type="text/javascript">

 
</script>


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
                  <a href="<c:url value='viewCustomers'/>" class="menuButton">
                    <span class="menuText">
                      View Customers
                    </span>
                </a>
  
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

<div id="singleColumn">

    <c:if test="${!empty orderFailureFlag}">
        <p class="error"><fmt:message key="orderFailureError"/></p>
    </c:if>

    <s:form action="saveProduct" method="post" enctype="multipart/form-data">
        <table id="registerTable" style="width: 19cm">
          <c:if test="${!empty validationErrorFlag}">
            <tr>
                <td colspan="2" style="text-align:left">
                    <span class="error smallText">See the errors below:

                      <c:if test="${!empty nameError}">
                        <br><span class="indent"></span>
                      </c:if>
                      <c:if test="${!empty emailError}">
                        <br><span class="indent">Email : Eg) alex@domain.com</span>
                      </c:if>
                      <c:if test="${!empty phoneError}">
                        <br><span class="indent">Phone: Eg)84388214</span>
                      </c:if>
                      <c:if test="${!empty addressError}">
                        <br><span class="indent">Address : eg)Bedok </span>
                      </c:if>
                      <c:if test="${!empty cityRegionError}">
                        <br><span class="indent"><fmt:message key="cityRegionError"/></span>
                      </c:if>
                      <c:if test="${!empty ccNumberError}">
                        <br><span class="indent"><fmt:message key="ccNumberError"/></span>
                      </c:if>

                    </span>
                </td>
            </tr>
          </c:if>
            <tr style="text-align: left">
                <td><label for="name">Name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="name"
                           name="name" required>
                </td>
            </tr>
               <tr>
                <td><label for="price">Price:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="price"
                           name="price"
                           required>
                </td>
            </tr>
       
            <tr>
                <td><label for="description">Description:</label></td>
                <td class="inputField">
                    <textarea id="desription" name="description" rows="3" cols="55" ></textarea>
                </td>
            </tr>
              <tr>
                <td><label for="detail">Detail:</label></td>
                <td class="inputField">
                    <textarea id="detail" name="detail" rows="3" cols="55"  required></textarea>
                </td>
            </tr>
             <tr>
                <td><label for="image">Image:</label></td>
                <td class="inputField">
                    <s:file 
                       
                           id="image"
                           name="image" />
                </td>
             </tr> 
             <tr>
                 
               <td><label for="category">Category:</label></td>
                <td  class="inputField">              
                    <% int i = 1; %>
                   <select name="category" id="category" required>
                    <c:forEach var="category" items="${categories}" varStatus="loop" >
                        <% i++; %>   
                            <option value="${loop.count}">${category.id}${category.name}</option>
                    </c:forEach>
                   </select>       
                 </td>              
            </tr>
            </table>
          <table id="registerTable" style="width: 19cm;text-align: center;padding-right: 9cm">
            <tr >
                <td >
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </s:form>
</div>