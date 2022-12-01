<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Outsourcing" %>
<%@ page import="outsourcing_control.Outsourcing_Control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String part_name = request.getParameter("part_name");
String company_name = request.getParameter("company_name");
String temp_quantity = request.getParameter("quantity");
String temp_price = request.getParameter("price");
String exp_date = request.getParameter("exp_date");
String start_date = request.getParameter("start_date");
String end_date = request.getParameter("end_date");
String worker = (String)session.getAttribute("id");

int quantity=0;
int price=0;

if(part_name==null || part_name.equals("") || company_name==null || company_name.equals("") || temp_quantity==null || temp_quantity.equals("") || temp_price==null || temp_price.equals("")){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}
else{
	quantity = Integer.parseInt(temp_quantity);
	price = Integer.parseInt(temp_price);
}

Outsourcing o = new Outsourcing(part_name, company_name, quantity, price, exp_date, start_date, end_date, worker);
Outsourcing_Control control = new Outsourcing_Control();

Boolean result = control.InsertOutsourcing(o);

if(result==false){
	out.println("<script>alert('실패');location.href='Outsourcing_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Outsourcing_UI.jsp'</script>");
}
%>
</body>
</html>