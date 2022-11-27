<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Worker" %>
<%@ page import="worker_control.Worker_Control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");

Worker_Control control = new Worker_Control();
Boolean result = control.DeleteWorker(id);

if(result==false){
	out.println("<script>alert('실패');history.back();</script>");
}
else{
	out.println("<script>location.href='Worker_Management_UI.jsp'</script>");
}
%>
</body>
</html>