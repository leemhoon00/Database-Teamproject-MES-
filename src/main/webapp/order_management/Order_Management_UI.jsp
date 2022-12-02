<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
<label class="title" style="margin-left: 30px; margin-top: 10px;">수주 관리</label>

<div class="card">
	<div class="card-body">
		<div class="form-inline">
			<div class="form-inline">
			<label>상태:</label>
			<select class="form-select search" onchange="select_change_event(this)">
				<option value="전체">전체</option>
				<option value="진행중">진행중</option>
				<option value="완료">완료</option>
			</select>
		</div>
		</div>
	</div>
</div>

<div id="Order_List_UI"></div>

<script>
$.ajax({
    type:"GET",
       url:"./Order_List_UI.jsp",
       data:{status : '전체'},
       dataType:"html",
       success:function(data){
           $("#Order_List_UI").html(data);
     }
  });
  
function select_change_event(element){
	var status = element.value;
	
	$.ajax({
	    type:"GET",
	       url:"./Order_List_UI.jsp",
	       data:{status : status},
	       dataType:"html",
	       success:function(data){
	           $("#Order_List_UI").html(data);
	     }
	  });
}
</script>

</body>
</html>