<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="entity.Facility_Time"%>
<%@ page import="facility_control.Get_Working_Time"%>
<%@ page import="java.util.List" %>

<%
Get_Working_Time control = new Get_Working_Time();
List<Facility_Time> list;

list = control.getAllList();

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
<link rel="stylesheet" href="jh.css">
<title>Insert title here</title>

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 
</head>
<body>
<label class="title" style="margin-left: 30px; margin-top: 10px;">DashBoard</label>

<div class="card">
	<div class="card-header">
		설비별 실적가공 현황
	</div>
	<div class="card-body">
		<div class="form-inline">
			<div id="columnchart_material"></div>
		</div>
	</div>
</div>

<script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['설비', '가공시간(Hour)'],
          <%
          for(Facility_Time f : list){
          %>
          ['<%=f.getFacility_name()%>',<%=f.getWorking_time()/60 %>],
          <%}%>
        ]);

        var options = {
          chart: {
            title: '설비별 실적가공 현황',
            subtitle: '1 month ago ~ now',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
    
</body>
</html>