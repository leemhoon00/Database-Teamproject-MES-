<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Company" %>
<%@ page import="company_control.Company_Information" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous">
    </script>
<link rel="stylesheet" href="../jh.css">
<title>Insert title here</title>
</head>
<body>
<%
String company_name = request.getParameter("selectedTable");

Company_Information control = new Company_Information();
Company c = control.getCompanyInformation(company_name);

boolean insertbutton = false;
boolean deletebutton = false;
boolean updatebutton = false;
if(company_name.equals("0")){
	insertbutton=true;
}
else{
	deletebutton = true;
	updatebutton = true;
}
%>

<div class="card">
	<div class="card-header"
		style="font-size: 20px; background-color: white;"></div>
	<div class="card-body">
		<form>
			<div class="row">
				<div class="col-6">
					<label>기업명<span class="text-danger">*</span></label>
				</div>
				<div class="col-3">
					<label>고객사</label>
				</div>
				<div class="col-3">
					<label>외주사</label>
				</div>
				
				<div class="col-6">
					<input type="text" class="form-control" value="<%=c.getCompany_name() %>" name="company_name" <%=deletebutton ? "readonly" : "" %>>
				</div>
				<div class="col-3">
					<select class="form-select" aria-label="Default select example" name="client_company">
						<option value="Y">Y</option>
						<option value="N" <%=c.getClient_company().equals("N") ? "selected" : "" %>>N</option>
					</select>
				</div>
				<div class="col-3">
					<select class="form-select" aria-label="Default select example" name="outsourcing_company">
						<option value="Y">Y</option>
						<option value="N" <%=c.getOutsourcing_company().equals("N") ? "selected" : "" %>>N</option>
					</select>
				</div>
				
				<hr style="margin-top:10px; margin-bottom:10px;">
				
				<div class="col-12">
					<button id="deletebutton" style='<%=deletebutton?"":"display:none" %>' class="btn btn-danger float-right" type="submit" formaction="delete.jsp" formmethod="post">삭제</button>
					<button id="updatebutton" style='margin-right: 5px; <%=updatebutton?"":"display:none" %>' class="btn btn-info float-right" type="submit" formaction="update.jsp" formmethod="post">수정</button>
					<button id="insertbutton" style='<%=insertbutton?"":"display:none" %>' class="btn btn-info float-right" type="submit" formaction="insert.jsp" formmethod="post">등록</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>