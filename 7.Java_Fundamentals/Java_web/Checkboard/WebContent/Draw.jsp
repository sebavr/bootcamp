<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="assets/css/style.css">
        <title>Checkboard2</title>
    </head>
<body>
    <!-- Obtenemos el valor del parámetro name -->
    <% int alto = Integer.parseInt(request.getParameter("heigth"));
    	int ancho = Integer.parseInt(request.getParameter("width"));
    
    %>
    <!-- Mostramos el valor que obtuvimos -->
    <h1><%="Checkboard: "+ancho+"w"+" X  "+alto+"h" %></h1>
   
<% //http://localhost:14418/Checkerboard/Draw.jsp?width=3&heigth=3 %>

<div class="divTable blueTable">
<div class="divTableBody">

<%for(int i=0;i<ancho;i++){%>
<div class="divTableRow">
<% for(int j=0;j<alto;j++){ %>
<% int par = ((i+j)%2)+1; %>
<div class=divTableCell<%=par %>> &nbsp;</div>
<% 	} %>
</div>
<% 	} %>

</div>
</div>

 	



</body>
</html>