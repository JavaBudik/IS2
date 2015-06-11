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
		<title>Носії</title>
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
						Інформація про носій <c:out value="${storage.name}"></c:out>
					</h2>					
					<div class="entry">		
					<center>			
					<table border=1 class="tableHoriz">					
								<tr>								    
									<td class="header">
										Назва
									</td>
									<td class="simple">
										<c:out value="${storage.name}"></c:out>
									</td>
									<th rowspan=7><img src="${storage.photo}" /></th>
								</tr>
								<tr>
									<td class="header">
										Виробник
									</td>
									<td class="simple">
										<c:out value="${storage.manufacturer}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="header">
										Тип
									</td>
									<td class="simple">
										<c:out value="${storage.type}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="header">
										Ліцензія
									</td>
									<td class="simple">
										<c:out value="${storage.license}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="header">
										Ємність, Гб
									</td>
									<td class="simple">
										<c:out value="${storage.capacity}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="header">
										MTBF, год
									</td>
									<td class="simple">
										<c:out value="${storage.mtbf}"></c:out>
									</td>
								</tr>
								<tr>
									<td class="header">
										Ціна, грн
									</td>
									<td class="simple">
										<c:out value="${storage.price}"></c:out>
									</td>
								</tr>	
								
								
															
							</table>
					</center>
					<center>
					<div id="sidebar2">
				         <div class="post">
								
					
					</center>
					</div>
					</div>
				</div>
			</div>			
		</div>
	</body>
</html>