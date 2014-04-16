<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="view" value="/checkout" scope="session"/>


<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery-1.4.2.js" type="text/javascript"></script>

<script type="text/javascript">
function mode()
{
 selectedMode = document.getElementById('dropdown');
 viewLabel = document.getElementById('card');
 viewText = document.getElementById('creditcard');
                    if ( selectedMode.value == 'Online')
                    {
                        viewText.style.display='block'
                        viewLabel.style.display='block'
                    }
                    else
                    {
                        viewText.style.display='none'
                        viewLabel.style.display='none'
                    }
}

    $(document).ready(function(){
        $("#checkoutForm").validate({
            rules: {
                name: "required",
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    required: true,
                    number: true,
                    minlength: 9
                },
                address: {
                    required: true
                },
                creditcard: {
                    required: true,
                    creditcard: true
                }
            }
        });
    });
</script>


<%-- HTML markup starts below --%>

<div id="singleColumn">

    <h2>Payment Gateway</h2>

    <p>Please enter the details for payment </p>

    <form id="checkoutForm" action="<c:url value='purchase'/>" method="post">
        <table id="CheckOutTable">
 
            <tr>
                <td><label for="name">Customer Name:</label></td>
                <td class="">
                    <input type="label" 
                           size="31"
                           maxlength="45"
                           id="name"
                           readonly="readonly"
                           name="name"
                           value="${customer.name}" disabled>
                </td>
            </tr>
       
             <tr>
                <td><label for="phone">Phone:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="phone"
                           name="phone"
                           value="${customer.phone}" >
                </td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td class="">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                            value="${customer.email}" >
                </td>
            </tr>

            <tr>
                <td><label for="address">Address:</label></td>
                <td class="inputField">
                    <input type="textarea"
                           size="31"
                           rows="2"
                           maxlength="45"
                           id="address"
                           name="address"
                           value="${customer.address}">

                    <br>
                    Mode of Payment
                    <select name="dropdown" id="dropdown" onchange="mode()"  >
                        <option value="Cash on delivery">Cash on delivery</option>
                        <option value="Online">Online</option>
                    </select>
                </td>
            </tr>
            
            <tr>
                <td><label for="creditcard" id="card" style="display:none;">Credit Card:</label></td>
                <td class="inputField">
                    <input type="text"
                               
                           style="display:none;"
                           size="31"
                           maxlength="19"
                           id="creditcard"
                           name="creditcard"
                           class="creditcard"
                           value="${param.creditcard}"
                          >
                </td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="submit" value="purchase">
                </td>
            </tr>
        </table>
    </form>

    <div id="infoBox">

        <table id="priceBox">
 
 
            <tr>
                <td >Total Price:</td>
                <td >
                    <B>    <fmt:formatNumber type="currency" currencySymbol="&dollar; " value="${cart.total}"/></B></td>
            </tr>
        </table>
             <img src="/shoppingCart/img/visa.png"  alt="Visa">
             <img src="/shoppingCart/img/mastercard.png"  alt="Master Card">
             <img src="/shoppingCart/img/paypal.png"  alt="Pay Pal" style="margin-left: 2cm">
 
    </div>
</div>