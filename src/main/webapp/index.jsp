<%@ page import="java.text.SimpleDateFormat" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import= "java.util.List" %>
<%@ page import="com.acorn.cafe.Ingredient.dao.IngredientDAO" %>
<%@ page import="com.acorn.cafe.Ingredient.dto.IngredientDTO" %>
<%@ page import="com.acorn.cafe.Ingredient.service.IngredientService" %>


<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp" />
    <script src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.min.css">
    <title>JSP - Hello World</title>
</head>
<body>
<%
    String ingredientUrl= "/WEB-INF/ingredient/ingredient.jsp";
    RequestDispatcher dis = null;
    dis = request.getRequestDispatcher(ingredientUrl);
    dis.forward(request,response);
%>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<a href="Ingredient.jsp">ingredient</a>
</body>
</html>