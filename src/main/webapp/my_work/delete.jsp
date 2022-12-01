<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="my_work_control.Work_Control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
int work_number = Integer.parseInt(request.getParameter("work_number"));

Work_Control control = new Work_Control();
Boolean result = control.DeleteWork(work_number);

if(result==false){
	out.println("<script>alert('실패');location.href='My_Work_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='My_Work_UI.jsp'</script>");
}
%>
</body>
</html>