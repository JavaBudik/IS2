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
		<title>���</title>
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
							<i>������� ���������� ��������� ����������</i>
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
		����
	</h2>
	<div class="content">
		<ul>
			<li>
				<a href="all_storage.htm"><strong>���</strong> </a>
				<br />
			<li>
				<a href="all_pz.htm"><strong>��������� ������������</strong> </a>
				<br />
			<li>
				<a href="compat.htm"><strong>���������</strong> </a>
				<br />
			</li>
			<li>
				<a href="search.htm"><strong>�����</strong> </a>
				<br />
			</li>				
			<li>
				<a href="logout.htm"><strong>�����</strong> </a>
				<br />
			</li>
		</ul>
	</div>	
</div>
			</div>
			<div id="content">
				<div class="post">
					<h2 class="title">
						������ ��� SSD-����� (����-������)
					</h2>					
					<div class="entry">					
						<c:forEach items="${ssd}" var="ssd">
							<a href="getStorage.htm?str=${ssd.idStorage}"><c:out
									value="${ssd.name}" />
							</a>
							<br />
						</c:forEach>
					</div>
					
					<h2 class="title">
						������ ��� �������� �����
					</h2>					
					<div class="entry">					
						<c:forEach items="${hdd}" var="hdd">
							<a href="getStorage.htm?str=${hdd.idStorage}"><c:out
									value="${hdd.name}" />
							</a>
							<br />
						</c:forEach>
					</div>
					
					<h2 class="title">
						������ ��� �������� ����
					</h2>					
					<div class="entry">					
						<c:forEach items="${odd}" var="odd">
							<a href="getStorage.htm?str=${odd.idStorage}"><c:out
									value="${odd.name}" />
							</a>
							<br />
						</c:forEach>
					</div>
					
					<h2 class="title">
						������ ��� ��������� ������
					</h2>					
					<div class="entry">					
						<c:forEach items="${mdd}" var="mdd">
							<a href="getStorage.htm?str=${mdd.idStorage}"><c:out
									value="${mdd.name}" />
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