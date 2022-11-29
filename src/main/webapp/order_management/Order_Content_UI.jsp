<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Order" %>
<%@ page import="order_control.Order_Information" %>
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
String order_number = request.getParameter("selectedTable");

Order_Information control = new Order_Information();
Order o = control.getOrderInformation(order_number);

boolean insertbutton = false;
boolean deletebutton = false;
boolean updatebutton = false;
boolean completebutton = false;
boolean complete = false;
if(order_number.equals("0")){
	insertbutton=true;
}
else{
	deletebutton = true;
	updatebutton = true;
	completebutton = true;
}
if(!o.getEnd_date().equals("")){
	complete = true;
	completebutton = false;
}
%>

<div class="card">
	<div class="card-header"
		style="font-size: 20px; background-color: white;"></div>
	<div class="card-body">
		<form>
			<div class="row">
				<div class="col-6">
					<label>수주명<span class="text-danger">*</span></label>
				</div>
				<div class="col-6">
					<label>기업명<span class="text-danger">*</span></label>
				</div>
				<div class="col-6">
					<input type="text" class="form-control" value="<%=o.getOrder_name() %>" name="order_name" <%=complete ? "readonly" : "" %>>
				</div>
				<div class="col-6">
					<select class="form-select" name="company_name" id="company_name">
					</select>
				</div>
				
				
				
				<div class="col-6">
					<label>부품명<span class="text-danger">*</span></label>
				</div>
				<div class="col-3">
					<label>수량<span class="text-danger">*</span></label>
				</div>
				<div class="col-3">
					<label>가격</label>
				</div>
				<div class="col-6">
					<input type="text" class="form-control" value="<%=o.getPart_name() %>" name="part_name" <%=complete ? "readonly" : "" %>>
				</div>
				<div class="col-3">
					<input type="text" class="form-control" value="<%=o.getQuantity() %>" name="quantity" <%=complete ? "readonly" : "" %>>
				</div>
				<div class="col-3">
					<input type="text" class="form-control" value="<%=o.getOrder_price() %>" name="order_price" <%=complete ? "readonly" : "" %>>
				</div>
				
				
				<div class="col-6">
					<label>수주일</label>
				</div>
				<div class="col-6">
					<label>납기예정일</label>
				</div>
				<div class="col-6">
					<input type="date" class="form-control" value="<%=o.getOrder_date() %>" name="order_date" readonly>
				</div>
				<div class="col-6">
					<input type="date" class="form-control" value="<%=o.getExp_date() %>" name="exp_date" <%=complete ? "readonly" : "" %>>
				</div>
				
				<div class="col-6">
					<label>납기일</label>
				</div>
				<div class="col-6">
				</div>
				<div class="col-6">
					<input type="date" class="form-control" value="<%=o.getEnd_date() %>" name="end_date" readonly>
				</div>
				<div class="col-6">
				</div>
				
				<div class="col-12">
					<label>비고<label>
				</div>
				<div class="col-12">
					<p>
						<textarea class="form-control" rows="5" name="note" id="note"><%=o.getNote() %></textarea>
					</p>
				</div>
				
				<input type="text" style="display:none" name="order_number" value="<%=o.getOrder_number()%>"></input>
				<hr style="margin-top:10px; margin-bottom:10px;">
				
				<div class="col-12">
					<button id="deletebutton" style='<%=deletebutton?"":"display:none" %>' class="btn btn-danger float-right" type="submit" formaction="delete.jsp" formmethod="post">삭제</button>
					<button id="updatebutton" style='margin-right: 5px; <%=updatebutton?"":"display:none" %>' class="btn btn-info float-right" type="submit" formaction="update.jsp" formmethod="post">수정</button>
					<button id="completebutton" style='margin-right: 5px; <%=completebutton?"":"display:none" %>' class="btn btn-info float-right" type="submit" formaction="complete.jsp" formmethod="post">납기</button>
					<button id="insertbutton" style='<%=insertbutton?"":"display:none" %>' class="btn btn-info float-right" type="submit" formaction="insert.jsp" formmethod="post">등록</button>
				</div>
			</div>
		</form>
	</div>
</div>
<script>
$.ajax({
	type:"GET",
    url:"./company_ajax.jsp",
    data:{order_number:<%=order_number%>},
    dataType:"html",
    success:function(data){
        $('#company_name').html(data);
  }
});

</script>
</body>
</html>