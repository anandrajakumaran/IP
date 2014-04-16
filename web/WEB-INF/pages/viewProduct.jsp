<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Insert title here</title>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <script src="http://maps.google.com/maps?file=api&amp;amp;amp;amp;amp;v=2&amp;amp;amp;amp;amp;sensor=false&amp;amp;amp;amp;amp;key=ABQIAAAAzr2EBOXUKnm_jVnk0OJI7xSosDVG8KKPE1-m51RBrvYughuyMxQ-i1QfUnH94QxWIa6N4U6MouMmBA"
            type="text/javascript"></script>
        <script type="text/javascript">

           $(document).ready(function (){
               
                $("#map_table").hide();
               
               $("#getmap").click(function () {
                   
                    if ($("#getmap").attr("value") == "Show Location of Product") {
                $("#getmap").attr('value', 'Hide Location of Product');
                 $("#map_table").show();
             }
             else
             {
                 $("#getmap").attr('value', 'Show Location of Product');
                 $("#map_table").hide();
                 return;
             }
                  
                var latitude=0;
               var longitude=0;
                var geocoder = new google.maps.Geocoder();
                var address = document.getElementById("address").value;

                geocoder.geocode({'address': address}, function(results, status) {

                    if (status == google.maps.GeocoderStatus.OK) {
                         latitude = results[0].geometry.location.lat();
                        longitude = results[0].geometry.location.lng();
                         
            var map = new GMap2(document.getElementById("map_canvas"));

 
                    map.setCenter(new GLatLng(latitude, longitude), 13);
                    map.openInfoWindow(map.getCenter(),
                            document.createTextNode(address));
                    }
                });
                
               
                 
        
               });
               
           });

        

        </script>
    </head>
    <body>
        
        <%
          if(session.getAttribute("user") == null)
            {
              response.sendRedirect("CustLogin.jsp");
            }
        %>

    <table style="border: none;">
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
                <a href="<c:url value='category?${category.id}'/>" class="menuButton">
                    <span class="menuText">
                       ${category.name}
                    </span>
                </a>
            </c:otherwise>
        </c:choose>
        </td>
    </c:forEach>
</tr>
    </table>

<br><br>
<div id ="main" >
    <a href="<c:url value='category?${category.id}'/>" > Back </a>
  <table style="background-color: white;border-style: double;border-color: black;width: 21cm">
   <tr>
    <td width="158" height="80"><p> 
                 <s:url id="image2" action="showImage" var="imageUrl2">
                        <s:param name="productId">${productDetails.id}</s:param>
                   </s:url>     
      <img src=" <s:property value="#imageUrl2"/>" alt="${productDetails.name}"> </p>
         <h2 style="color: black">${productDetails.name}</h2> 
                  <form action="<c:url value='addToCart'/>" method="post">
                       
                        <input type="submit"
                             
                               value="AddToCart">
                    </form>
    </td>   
    <td width="568" valign="top">
        <p>${productDetails.detail}</p>
    </td>
  </tr>
  </table>

          <input type="hidden"
                               name="productId"
                               value="${productDetails.id}" />
      <input type="hidden" value="${seller.address}" id="address" />
      <input type="submit" id ="getmap" value="Show Location of Product" />
      
 
      <table id="map_table"><tr><td>
   <div id="map_canvas" style="width: 790px; height: 400px"></div> 
              </td></tr></table>
 
</div>
    </body>
</html>