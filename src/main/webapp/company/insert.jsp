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
String client_company = request.getParameter("client_company");
String outsourcing_company = request.getParameter("outsourcing_company");

Company c = new Company(company_name, client_company, outsourcing_company);
Company_Control control = new Company_Control();
Boolean result = control.InsertCompany(c);

if(company_name==null || company_name.equals("")){
	out.println("<script>alert('필수란을 입력하시오');history.back();</script>");
}

if(result==false){
	out.println("<script>alert('실패');location.href='Company_UI.jsp';</script>");
}
else{
	out.println("<script>location.href='Company_UI.jsp'</script>");
}

%>
</body>
</html>