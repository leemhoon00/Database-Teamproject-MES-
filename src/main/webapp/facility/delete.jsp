<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Facility" %>
<%@ page import="facility_control.Facility_Control" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String facility_name = request.getParameter("facility_name");

Facility_Control control = new Facility_Control();
Boolean result = control.DeleteFacility(facility_name);

if(result==false){
	out.println("<script>alert('실패');history.back();</script>");
}
else{
	out.println("<script>location.href='Facility_UI.jsp'</script>");
}
%>
</body>
</html>