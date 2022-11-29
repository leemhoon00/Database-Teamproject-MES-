<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="my_work_control.Ajax"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
Ajax control = new Ajax();

List<String> list = control.get_Part_List();

%>

<option value="">--선택--</option>
<%
for(String s : list){
%>
<option value="<%=s%>"><%=s %></option>
<%
}


%>
</body>
</html>