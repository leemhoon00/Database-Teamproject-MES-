<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Company" %>
<%@ page import="company_control.Company_Control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String company_name = request.getParameter("company_name");

Company_Control control = new Company_Control();
Boolean result = control.DeleteCompany(company_name);

if(result==false){
	out.println("<script>alert('실패');location.href='Company_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Company_UI.jsp'</script>");
}
%>
</body>
</html>