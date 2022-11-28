<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="company_control.Company_Select"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
Company_Select control = new Company_Select();

String order_number = request.getParameter("order_number");
if(!order_number.equals("0")){
	String company_name = control.get_Company_Name(order_number);
%>
<option value="<%=company_name%>"><%=company_name %></option>
<%
}
else{
	List<String> list = control.get_Client_Company();
	
%>
<option value="">--선택--</option>
<%
for(String s : list){
%>
<option value="<%=s%>"><%=s %></option>
<%
}
}

%>
</body>
</html>