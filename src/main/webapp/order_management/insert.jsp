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
String order_name = request.getParameter("order_name");
String company_name = request.getParameter("company_name");
String part_name = request.getParameter("part_name");
int quantity = Integer.parseInt(request.getParameter("quantity"));
int order_price = Integer.parseInt(request.getParameter("order_price"));
String exp_date = request.getParameter("exp_date");
String end_date = request.getParameter("end_date");
String note = request.getParameter("note");
if(note == null || note.equals("")){
	note = "";
}



if(order_name==null || order_name.equals("") || part_name==null || part_name.equals("") || quantity==0){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}

Order o = new Order(order_name,company_name,part_name,quantity,order_price,exp_date,end_date,note);
Order_Control control = new Order_Control();
Boolean result = control.InsertOrder(o);

if(result==false){
	out.println("<script>alert('실패');location.href='Order_Management_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Order_Management_UI.jsp'</script>");
}

%>
</body>
</html>