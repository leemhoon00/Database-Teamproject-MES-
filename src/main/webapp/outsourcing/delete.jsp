<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="outsourcing_control.Outsourcing_Control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
int outsourcing_number = Integer.parseInt(request.getParameter("outsourcing_number"));

Outsourcing_Control control = new Outsourcing_Control();
Boolean result = control.DeleteOutsourcing(outsourcing_number);

if(result==false){
	out.println("<script>alert('실패');location.href='Outsourcing_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Outsourcing_UI.jsp'</script>");
}
%>
</body>
</html>