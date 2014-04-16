<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
    <style type="text/css">
#login-box {
	width:333px;
	height: 352px;
	padding: 58px 76px 0 76px;
	color: #black;
	font: 12px Arial, Helvetica, sans-serif;
	background: url(/shoppingCart/img/login-box-backg.png) no-repeat center;
}

#backgroundFill {
	width:800px;
	height:600px;
	padding: 58px 76px 0 76px;
	color: #black;
	font: 12px Arial, Helvetica, sans-serif;
	background: url(/shoppingCart/img/back.jpg) no-repeat left top;
}
#login-box img {
	border:none;
}

#login-box h2 {
	padding:0;
	margin:0;
	color: #black;
	font: bold 44px "Calibri", Arial;
}

#login-box-name {
	float: left;
	display:inline;
	width:80px;
        color: black;
	text-align: right;
	padding: 14px 8px 0 0;
	margin:0 0 7px 0;
        font: bold 14px "Calibri", Arial;
}

#login-box-field {
	float: left;
	display:inline;
	width:230px;
	margin:0;
	margin:0 0 7px 0;
}


.form-login  {
	width: 205px;
	padding: 8px 4px 6px 3px;
	border: 1px solid #0d2c52;
	background-color:#1e4f8a;
	font-size: 16px;
	color: #ebebeb;
}


.login-box-options  {
	clear:both;
	padding-left:87px;
	font-size: 11px;
}

.login-box-options a {
	color: #ebebeb;
	font-size: 11px;
}

</style>	
<head>
<title>Login</title>
</head>
<body>
       
    <div id="content" style="padding-left:10cm;" >
            <a href="/shoppingCart/">
                <img src="/shoppingCart/img/logo.png" id="logo" alt="Shopping Cart logo">
            </a>
            <a href="/shoppingCart/">
                <img src="/shoppingCart/img/logoText.png" id="logoText" alt="Shopping cart">
            </a>
    </div>
           
    <div style="padding: 40px 0 0 400px;">
        <div id="login-box">
            <s:form action="login" method="post">
                <H2>Login</H2>
            <br />
            <br />
            <table>
                <tr>
                 
                <div id="login-box-field" style="margin-top:20px;">
                    <!--<input type="text" name="username" class="form-login" title="Username" value="" size="30" maxlength="2048">-->
                <s:textfield name="userName" cssClass="form-login" label="User Name"/>
                <s:password name="password" cssClass="form-login" label="Password"/>
                <s:submit value="Login" align="center"/>
                
                </div>
                 
            </tr>
            <tr>
                <td >
                              <s:a  action="register">  Not Registered? Sign Up Here</s:a>
                </td>
            </tr>
               </table> 
                <!--<div id="login-box-name">Password:</div><div id="login-box-field">-->
                    <!--<td><input type="password" name="password" class="form-login" title="Password" value="" size="30" maxlength="2048"/></td>-->
                </div>
       
            <!--<input type="submit" name="btnSubmit" value="submit"--> 
                   <!--style="width: 60px; height: 30px; margin-left: 4cm"   /><br /> <br />-->
                   <div>
                    <br /> 
                   </div>
            </s:form>

                   


</div>

</div>

      

</body>
</html>