<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.Worker" %>
<%@ page import="control.Worker_Search" %>

<%
String name = request.getParameter("name");

Worker_Search control = new Worker_Search();
List<Worker> list;

if(name == null || name.equals("")){
	list = control.getAllList();
}
else{
	list = control.getSearchedList(name);
}


int rowcount = list.size();
int lastpagenumber=1;
if(rowcount!=0){
	lastpagenumber = (rowcount-1)/10 + 1;
}
%>
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
<script>
var selectedTable='0';
</script>

<div class="row">
	<div class="col-6" style="margin-right: 0px;">
		<div class="card" style="margin-right: 0px;">
			<div class="card-header"
				style="font-size: 20px; background-color: white;">근무자 목록</div>
			<div class="card-body">
				<table id="mytable" class="table table-bordered" style="width: 100%;"
					role="grid">
					<thead>
						<tr>
							<th>이름</th>
							<th style="width:20%;">직위</th>
						</tr>
					</thead>
					<tbody style="border-top: none;">
						
						<%
						int count=0;
						int pagegroup=0;
						
						for(Worker w: list){ 
						count++;
						if(count % 10 == 1){
							pagegroup++;
						}
						
						%>
						
						<tr class="trs pagegroup<%=pagegroup%>" id="<%=w.getID() %>" onclick="TableClickEvent(this)">
							<td style="display:none"><%=w.getID() %></td>
							<td><%=w.getName() %></td>
							<td><%=w.getPosition() %></td>
						</tr>
						
						<%} %>
					</tbody>
				</table>
				<script>
				function TableClickEvent(element){
					var trs = document.querySelectorAll(".trs");
					
					if(selectedTable == '0'){
						selectedTable = element.children[0].innerHTML;
						element.style.backgroundColor="lightgray";
					}
					else if(selectedTable != element.children[0].innerHTML){
						document.getElementById(selectedTable).style.backgroundColor="white";
						element.style.backgroundColor="lightgray";
						
						selectedTable = element.children[0].innerHTML;
						
					}
					else{
						selectedTable = '0';
						element.style.backgroundColor="white";
					}
					
					$.ajax({
						type:"GET",
				        url:"./Worker_Content_UI.jsp",
				        data:{selectedTable : selectedTable},
				        dataType:"html",
				        success:function(data){
				            $("#Worker_Content_UI").html(data);
				      }
				   });
				}
				
				$.ajax({
					type:"GET",
			        url:"./Worker_Content_UI.jsp",
			        data:{selectedTable : '0'},
			        dataType:"html",
			        success:function(data){
			            $("#Worker_Content_UI").html(data);
			      }
			   });
				
				
				function setdisplay(groupnumber){
					var trs = document.querySelectorAll(".trs");
					for(var i=0; i<trs.length; i++){
						var item = trs.item(i);
						item.style.display="none";
					}
					
					trs = document.querySelectorAll(".pagegroup"+groupnumber);
					for(var i=0;i<trs.length; i++){
						var item = trs.item(i);
						item.style.display="";
					}
					
					var pages = document.querySelectorAll(".pages");
					for(var i=0; i<pages.length; i++){
						var item=pages.item(i);
						item.classList.remove('active');
					}
					
					document.getElementById("page"+groupnumber).className += ' active';
					
					if(groupnumber==1){
						document.getElementById("previous").className += ' disabled';
						document.getElementById("previous").style.pointerEvents="none";
					}
					else{
						document.getElementById("previous").classList.remove('disabled');
						document.getElementById("previous").style.pointerEvents="auto";
					}
					
					if(groupnumber==document.querySelector(".lastpage").children[0].innerHTML*1){
						document.getElementById("next").className += ' disabled';
						document.getElementById("next").style.pointerEvents="none";
					}
					else{
						document.getElementById("next").classList.remove('disabled');
						document.getElementById("next").style.pointerEvents="auto";
					}
				}
				function previousbutton(){
					setdisplay(document.querySelector(".active").children[0].innerHTML*1-1);
				}
				
				function nextbutton(){
					setdisplay(document.querySelector(".active").children[0].innerHTML*1+1);
				}
				</script>
				<ul class="pagination justify-content-end" id="pageul">
					<li class="page-item" id="previous" onclick="previousbutton()"><a class="page-link">Previous</a></li>
					
					<%
					int pagecount = ((rowcount-1)/10)+1;
					for(int i=0;i<pagecount;i++){
					%>
					<li class="page-item pages<%=(i+1)==pagecount?" lastpage":"" %>" id="page<%=i+1%>" onclick="setdisplay(<%=i+1%>)"><a class="page-link"><%=i+1%></a></li>
					<%
					}
					%>
					<li class="page-item" id="next" onclick="nextbutton()"><a class="page-link">Next</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<script>
	setdisplay(1);
	</script>
	<div class="col-6" id="Worker_Content_UI" style="margin-left:0px;">
	
	</div>
</div>
</body>
</html>