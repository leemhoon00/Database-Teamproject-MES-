<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Part" %>
<%@ page import="part_control.Part_Control" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String part_name = request.getParameter("part_name");
int price;
int quantity;
int safety_quantity;
if(request.getParameter("price") == null || request.getParameter("price").equals("")){
	price = 0;
}
else{
	price = Integer.parseInt(request.getParameter("price"));
}

if(request.getParameter("quantity") == null || request.getParameter("quantity").equals("")){
	quantity = 0;
}
else{
	quantity = Integer.parseInt(request.getParameter("quantity"));
}

if(request.getParameter("safety_quantity") == null || request.getParameter("safety_quantity").equals("")){
	safety_quantity = 0;
}
else{
	safety_quantity = Integer.parseInt(request.getParameter("safety_quantity"));
}

if(part_name==null || part_name.equals("")){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}

Part p = new Part(part_name, price, quantity, safety_quantity);
Part_Control control = new Part_Control();
Boolean result = control.InsertPart(p);

if(result==false){
	out.println("<script>alert('실패');location.href='Part_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Part_UI.jsp'</script>");
}

%>
</body>
</html>