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
String part_name = request.getParameter("part_name");
String facility_name = request.getParameter("facility_name");
String temp_quantity = request.getParameter("quantity");
String start_time = request.getParameter("start_time");
String end_time = request.getParameter("end_time");
String faulty = request.getParameter("faulty");
String worker = (String)session.getAttribute("id");
int quantity=0;



if(faulty == null){
	faulty = "N";
}
else{
	faulty = "Y";
}

if(part_name==null || part_name.equals("") || facility_name==null || facility_name.equals("") || temp_quantity==null || temp_quantity.equals("")){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}
else{
	quantity = Integer.parseInt(temp_quantity);
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




Work w = new Work(part_name, facility_name, quantity, start_time, end_time, faulty, worker);
Work_Control control = new Work_Control();
Boolean result = control.InsertWork(w);

if(result==false){
	out.println("<script>alert('실패');location.href='My_Work_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='My_Work_UI.jsp'</script>");
}

%>
</body>
</html>