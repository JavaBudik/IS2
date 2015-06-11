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
		<title>��������</title>
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
				<a href="compat.htm"><strong>��������</strong> </a>
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
						������� ��������
					</h2>
										
					<div class="entry">		
					<center>
					<table border=1 class="tableHoriz">	
					<c:forEach items="${compat}" var="compat">
					           <tr>								    
									<td class="simple">
										<a href="getStorage.htm?str=${compat.storageId}"><c:out
									value="${compat.storageName}" /></a>
									</td>
									<td class="simple">
										<a href="getPZ.htm?str=${compat.pzId}"><c:out
									value="${compat.pzName}" /></a>
									</td>
									<td class="simple">
										<c:out value="${compat.compatibility}" />
									</td>
								</tr>						
							<br />
					</c:forEach>														
					</table>
					</center>										
				</div>
				</div>				
			</div>			
		</div>
	</body>
</html>