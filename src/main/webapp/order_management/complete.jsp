<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Order" %>
<%@ page import="order_control.Order_Control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
int order_number = Integer.parseInt(request.getParameter("order_number"));

Order_Control control = new Order_Control();
Boolean result = control.CompleteOrder(order_number);

if(result==false){
	out.println("<script>alert('부품의 갯수가 부족합니다');location.href='Order_Management_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Order_Management_UI.jsp'</script>");
}
%>
</body>
</html>