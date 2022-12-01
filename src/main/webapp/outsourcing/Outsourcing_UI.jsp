<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Outsourcing"%>
<%@ page import="outsourcing_control.Outsourcing_Search"%>
<%@ page import="java.util.List" %>

<%
Outsourcing_Search control = new Outsourcing_Search();
List<Outsourcing> list;

list = control.getOutsourcingList();

%>
<!DOCTYPE html>
<html>
<head>
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
<label class="title" style="margin-left: 30px; margin-top: 10px;">외주 작업일보</label>

<div class="card">
	<div class="card-header">
		외주일보 등록/수정
	</div>
	<div class="card-body">
		<div class="form-inline" class="row">
			<div class="col-12" id="maindiv">
				<%
				for(Outsourcing o : list){
					if(o.getExp_date()!=null){
						o.setExp_date(o.getExp_date().substring(0,10));
					}
					if(o.getStart_date()!=null){
						o.setStart_date(o.getStart_date().substring(0,10));
					}
				%>
				<div>
					<form>
						<input type="text" style="display:none" name="outsourcing_number" value="<%=o.getOutsourcing_number() %>">
						<table class="table">
							<thead>
								<tr>
									<th>부품명</th>
									<th>외주사</th>
									<th>수량</th>
									<th>가격</th>
									<th>입고 예정일</th>
									<th>외주일자</th>
									<th>입고일자</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<input type="text" class="form-control" value="<%=o.getPart_name() %>" readonly>
									</td>
									<td>
										<input type="text" class="form-control" value="<%=o.getCompany_name() %>" readonly>
									</td>
									<td>
										<input type="text" class="form-control" value="<%=o.getQuantity() %>" readonly>
									</td>
									<td>
										<input type="text" class="form-control" value="<%=o.getPrice() %>" readonly>
									</td>
									<td>
										<input type="date" class="form-control" name="exp_date" value="<%=o.getExp_date() %>">
									</td>
									
									<td>
										<input type="date" class="form-control" name="start_date" value="<%=o.getStart_date() %>">
									</td>
									<td>
										<input type="date" class="form-control" name="end_date">
									</td>
									<td>
										<button class="btn btn-danger" type="submit" formaction="delete.jsp" formmethod="post">삭제</button>
									</td>
									<td>
										<button class="btn btn-info" type="submit" formaction="update.jsp" formmethod="post">수정</button>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
					
				<%} %>
			</div>
		</div>
		
		<div class="col-12 mb-3" style="border-bottom: 1px dashed #eee;"></div>
		<div>
			<button class="btn btn-info float-right" style="margin-right: 5px;" onclick="addbutton()">작업추가</button>
		</div>
	</div>
</div>

<script>
function addbutton(){
	var template = document.getElementById('template').cloneNode(true);
	template.style.display="";
	document.getElementById("maindiv").appendChild(template);
}

function deletebutton(element){
	element.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.remove();
}

</script>

<!-- 작업 추가 버튼을 눌렀을 때 생성되는  div의 원본 템플릿 -->
<div id="template" style="display:none">
	<form>
		<input type="text" style="display:none" name="work_number">
		<table class="table">
			<thead>
				<tr>
					<th>부품명<span class="text-danger">*</span></th>
					<th>외주사<span class="text-danger">*</span></th>
					<th>수량<span class="text-danger">*</span></th>
					<th>가격<span class="text-danger">*</span></th>
					<th>입고 예정일</th>
					<th>외주일자</th>
					<th>입고일자</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<select class="form-select" name="part_name" id="part_name">
							<option value="">--선택--</option>
						</select>
					</td>
					<td>
						<select class="form-select" name="company_name" id="company_name">
							<option value="">--선택--</option>
						</select>
					</td>
					<td>
						<input type="text" class="form-control" name="quantity">
					</td>
					<td>
						<input type="text" class="form-control" name="price">
					</td>
					<td>
						<input type="date" class="form-control" name="exp_date">
					</td>
					<td>
						<input type="date" class="form-control" name="start_date">
					</td>
					<td>
						<input type="date" class="form-control" name="end_date">
					</td>
					<td>
						<button class="btn btn-danger" onclick="deletebutton(this)">삭제</button>
					</td>
					<td>
						<button class="btn btn-info" type="submit" formaction="insert.jsp" formmethod="post">등록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>


<script>
$.ajax({
	type:"GET",
    url:"../my_work/part_ajax.jsp",
    data:{},
    dataType:"html",
    success:function(data){
        $('#part_name').html(data);
  }
});

$.ajax({
	type:"GET",
    url:"./company_ajax.jsp",
    data:{},
    dataType:"html",
    success:function(data){
        $('#company_name').html(data);
  }
});
</script>
</body>
</html>