<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Worker" %>
<%@ page import="control.Worker_Control" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String position = request.getParameter("position");
String phone_number = request.getParameter("phone_number");

if(id==null || id.equals("") || pw==null || pw.equals("") || name==null || name.equals("")){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}


%>
</body>
</html>