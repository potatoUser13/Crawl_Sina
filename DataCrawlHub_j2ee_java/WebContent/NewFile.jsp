<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="bean.Event,dao.EventDAO,java.util.*"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="js/jquery-slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type = "text/css" href="WebContent/app.css" > 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!-- 	
			<div class="firstpage">
				<div class="firstpage-bg" id="firstpagebg">	</div>
			</div>
	 -->
<title>WhaleHead</title>
<link rel="shortcut icon" href="picture/favicon.ico"></link>

<style type="text/css">
body {
	background-image: url("picture/background.jpg");
	margin: 0px;
	padding: 0px;
}
nav {
	width: 100%;
	height: 64px;
	position: relative;
	background-color: #FFF
	}
a{
	font-family: Microsoft YaHei, '宋体', Tahoma, Helvetica, Arial,
		"\5b8b\4f53", sans-serif;
	font-size:30px;
	 margin-left:20px
}

.name{
	font-size:20px;
	margin-left:100px
}

table{
  position: relative;

  top: 50px;
}

</style>

</head>
<body>

 
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="#" class="navbar-left"><img alt="Brand"style="max-height: 50px; max-width: 350px; margin-left: 0px;"src="picture/word.png">
				</a>
			</div>	
			<div id="navbar" class="nav navbar-nav">
				<ul class="nav nav-justified">
					<li class="active"><a href="#">  Home </a></li>
					<li><a href="#">About  </a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>
	




	
	
  
	<table width="500px" align="center" border="1" cellspacing="0">
  
		<tr class="table">
		    <td class = "name">排名</td>
		    <td class = "name">事件</td>
		    <td class = "name">热度</td>
		    <td class = "name">时间</td>
		</tr>
		
		<c:forEach items="${eventList}" var="event" varStatus="st">
	        <tr>
	            <td>${event.id}</td>
	            <td>${event.name}</td>
	            <td>${event.hot}</td>
	            <td>${event.time}</td>
	        </tr>
   		 </c:forEach>
	 	
	 	
	  
	</table>
	
	

	
</body>
</html>