<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Work"%>
<%@ page import="my_work_control.Work_Search"%>
<%@ page import="java.util.List" %>

<%
Work_Search control = new Work_Search();
List<Work> list;

list = control.getWorkList();

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
<label class="title" style="margin-left: 30px; margin-top: 10px;">나의 작업일보</label>

<div class="card">
	<div class="card-header">
		작업일보 등록/수정
	</div>
	<div class="card-body">
		<div class="form-inline" class="row">
			<div class="col-12" id="maindiv">
				<%
				for(Work w : list){
				%>
				<div>
					<form>
						<input type="text" style="display:none" name="work_number" value="<%=w.getWork_number() %>">
						<table class="table">
							<thead>
								<tr>
									<th>부품명</th>
									<th>설비</th>
									<th>수량</th>
									<th>시작시간</th>
									<th>종료시간</th>
									<th>불량</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<input type="text" class="form-control" name="part_name" value="<%=w.getPart_name() %>" readonly>
									</td>
									<td>
										<input type="text" class="form-control" name="facility_name" value="<%=w.getFacility_name() %>" readonly>
									</td>
									<td>
										<input type="text" class="form-control" name="quantity" value="<%=w.getQuantity() %>" readonly>
									</td>
									<td>
										<input type="datetime-local" class="form-control" name="start_time" value="<%=w.getStart_time() %>">
									</td>
									<td>
										<input type="datetime-local" class="form-control" name="end_time" value="<%=w.getEnd_time() %>">
									</td>
									<td>
										<input type="checkbox" name="faulty" <%=w.getFaulty().equals("Y")?"checked":"" %>>
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
					<th>설비<span class="text-danger">*</span></th>
					<th>수량<span class="text-danger">*</span></th>
					<th>시작시간</th>
					<th>종료시간</th>
					<th>불량</th>
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
						<select class="form-select" name="facility_name" id="facility_name">
							<option value="">--선택--</option>
						</select>
					</td>
					<td>
						<input type="text" class="form-control" name="quantity">
					</td>
					<td>
						<input type="datetime-local" class="form-control" name="start_time">
					</td>
					<td>
						<input type="datetime-local" class="form-control" name="end_time">
					</td>
					<td>
						<input type="checkbox" name="faulty">
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
    url:"./part_ajax.jsp",
    data:{},
    dataType:"html",
    success:function(data){
        $('#part_name').html(data);
  }
});

$.ajax({
	type:"GET",
    url:"./facility_ajax.jsp",
    data:{},
    dataType:"html",
    success:function(data){
        $('#facility_name').html(data);
  }
});
</script>
</body>
</html>