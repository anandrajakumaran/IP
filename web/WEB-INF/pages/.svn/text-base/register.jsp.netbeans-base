<script src="js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
<%@ taglib prefix="s" uri="/struts-tags"%>

    $(document).ready(function(){
        $("#registerForm").validate({
            rules: {
                name: "required",
                email: {
                    required: true,
                    email: true
                },
                phone: {
                    required: true,
                    number: true,
                    minlength: 8
                },
                username:{
                    required: true
                },
                
                address:{
                    required: true
                }
            }
        });
    });
</script>


<%-- HTML markup starts below --%>

<div id="singleColumn">

    <c:if test="${!empty orderFailureFlag}">
        <p class="error">Registeration failed</p>
    </c:if>

        <s:form action="saveRegister" method="post" name="registerForm" id="registerForm">
        <table id="registerTable" style="width:18cm">
          <c:if test="${!empty validationErrorFlag}">
            <tr>
                <td colspan="2" style="text-align:left">
                    <span class="error smallText">Registration Failed:

                      <c:if test="${!empty nameError}">
                        <br><span class="indent"></span>
                      </c:if>
                      <c:if test="${!empty emailError}">
                        <br><span class="indent">Email : Eg)mojo@domain.com</span>
                      </c:if>
                      <c:if test="${!empty phoneError}">
                        <br><span class="indent">Phone: Eg)84388214</span>
                      </c:if>
                      <c:if test="${!empty addressError}">
                        <br><span class="indent">Address : eg)Bedok </span>
                      </c:if>
                    </span>
                </td>
            </tr>
          </c:if>
            <tr>
                <td><label for="name">Name:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="name"
                           name="name"
                           value="${param.name}">
                </td>
                
                <td><label for="email">E-Mail:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="email"
                           name="email"
                           value="${param.email}">
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
                           value="${param.phone}">
                </td>
                
                <td><label for="username">UserName:</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="16"
                           id="username"
                           name="username"
                           value="${param.username}">
                </td>
            </tr>
             <tr>
                <td><label for="password">Password:</label></td>
                <td class="inputField">
                    <input type="password"
                           size="31"
                           maxlength="16"
                           id="password"
                           name="password"
                           value="${param.password}">
                </td>
                 <td><label for="confirm">Confirm:</label></td>
                <td class="inputField">
                    <input type="password"
                           size="31"
                           maxlength="16"
                           id="confirm"
                           name="confirm"
                           value="${param.confirm}">
                </td>
            </tr>

            <tr>
                <td><label for="address">Address</label></td>
                <td class="inputField">
                    <input type="text"
                           size="31"
                           maxlength="45"
                           id="address"
                           name="address"
                           value="${param.address}">

          
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="saveRegister">
                </td>
            </tr>
        </table>
    </s:form>
</div>