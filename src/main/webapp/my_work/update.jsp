<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Work" %>
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
String start_time = request.getParameter("start_time");
String end_time = request.getParameter("end_time");
String faulty = request.getParameter("faulty");

if(faulty == null){
	faulty = "N";
}
else{
	faulty = "Y";
}

if(start_time==null || start_time.equals("")){
	
}
else{
	start_time = start_time.replace("T"," ")+":00";
}

if(end_time==null || end_time.equals("")){
	
}
else{
	end_time = end_time.replace("T"," ")+":00";
}

Work w = new Work(work_number, start_time, end_time, faulty);
Work_Control control = new Work_Control();
Boolean result = control.UpdateWork(w);

if(result==false){
	out.println("<script>alert('실패');location.href='My_Work_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='My_Work_UI.jsp'</script>");
}
%>
</body>
</html>