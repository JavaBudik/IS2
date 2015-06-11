<%@ page language="java" import="java.util.*" pageEncoding="Windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Програмне забезпечення</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="header">
			<hr />
			<table border=0>
				<tr>
					<td>
						<img src="images/logo.gif" height=140 />
					</td>
					<td width=50%>
						<h1>
							<i>Системи резервного копіювання інформації</i>
						</h1>
					</td>
				</tr>
			</table>
			<hr />
		</div>		
		<div id="page">
			<div id="sidebar">
				<div class="box">
	<h2 class="title">
		Меню
	</h2>
	<div class="content">
		<ul>
			<li>
				<a href="all_storage.htm"><strong>Носії</strong> </a>
				<br />
			<li>
				<a href="all_pz.htm"><strong>Програмне забезпечення</strong> </a>
				<br />
			<li>
				<a href="compat.htm"><strong>Сумісність</strong> </a>
				<br />
			</li>
			<li>
				<a href="search.htm"><strong>Пошук</strong> </a>
				<br />
			</li>				
			<li>
				<a href="logout.htm"><strong>Вийти</strong> </a>
				<br />
			</li>
		</ul>
	</div>	
</div>
			</div>
			<div id="content">
				<div class="post">
					<h2 class="title">
						Програмне забезпечення для великих мереж
					</h2>					
					<div class="entry">					
						<c:forEach items="${big}" var="big">
							<a href="getPZ.htm?str=${big.pzId}"><c:out
									value="${big.name}" />
							</a>
							<br />
						</c:forEach>
					</div>
					
					<h2 class="title">
						Програмне забезпечення для малих мереж
					</h2>					
					<div class="entry">					
						<c:forEach items="${small}" var="small">
							<a href="getPZ.htm?str=${small.pzId}"><c:out
									value="${small.name}" />
							</a>
							<br />
						</c:forEach>
					</div>
					
					<h2 class="title">
						Програмне забезпечення для одиночних систем
					</h2>					
					<div class="entry">					
						<c:forEach items="${one}" var="one">
							<a href="getPZ.htm?str=${one.pzId}"><c:out
									value="${one.name}" />
							</a>
							<br />
						</c:forEach>
					</div>				
					</center>
				</div>
			</div>			
		</div>
	</body>
</html>