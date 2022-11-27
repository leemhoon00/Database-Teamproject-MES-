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
String status = request.getParameter("status");
int minute_cost;

if(request.getParameter("minute_cost") == null || request.getParameter("minute_cost").equals("")){
	minute_cost = 0;
}
else{
	minute_cost = Integer.parseInt(request.getParameter("minute_cost"));
}

if(facility_name==null || facility_name.equals("")){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}

Facility f = new Facility(facility_name, status, minute_cost);
Facility_Control control = new Facility_Control();
Boolean result = control.UpdateFacility(f);


if(result==false){
	out.println("<script>alert('실패');history.back();</script>");
}
else{
	out.println("<script>location.href='Facility_UI.jsp'</script>");
}

%>
</body>
</html>