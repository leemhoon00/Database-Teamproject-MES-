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

Part_Control control = new Part_Control();
Boolean result = control.DeletePart(part_name);

if(result==false){
	out.println("<script>alert('실패');location.href='Part_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Part_UI.jsp'</script>");
}
%>
</body>
</html>