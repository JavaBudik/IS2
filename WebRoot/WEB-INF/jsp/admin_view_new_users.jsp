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
		<title>������� �������������</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />		
	</head>
	<body>		
		<div id="header">
			<hr />
			<table>
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
				<a href="admin_view_new_users.htm"><strong>��� �����������</strong> </a>
				<br />
			<li>
				<a href="admin_view_users.htm"><strong>�� �����������</strong> </a>
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
			<center>
				<div class="post">					
					<h2 class="title">					
						�� ��� �����������
					</h2>
					<div class="entry">
						<form method="post" action="confirm_users.htm">
							<h3>
								�������������
							</h3>

							<table border=1 class="tableHoriz">
								<tr class="header">
									<td>
										����
									</td>
									<td>
										���
									</td>
									<td>
										�������
									</td>
									<td>
										�������
									</td>
									<td>
										Check
									</td>
								</tr>
								<c:forEach items="${users.admins}" var="user">
									<tr>
										<td>
											<c:out value="${user.login}" />
										</td>
										<td>
											<c:out value="${user.adminsName}" />
										</td>
										<td>
											<c:out value="${user.adminsSurname}" />
										</td>										
										<td>
											<c:out value="${user.phone}" />
										</td>
										<td class="form">
											<input type="checkbox" name="checkedAdmins"
												value="${user.id}" onChange="Disab(this.name)" />
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td>
										<input id="btn1" name="control" type="submit" value="Confirm" />
									</td>
									<td>
										<input id="btn2" name="control" type="submit" value="Delete" />
									</td>
								</tr>
							</table>
						</form>
						<br />
						<form method="post" action="confirm_users.htm">
							<h3>
								Power �����������
							</h3>

							<table border=1 class="tableHoriz">
								<tr class="header">
									<td>
										����
									</td>	
									<td>
										���
									</td>								
									<td>
										̳���
									</td>									
									<td>
										�������
									</td>
									<td>
										Check
									</td>
								</tr>
								<c:forEach items="${users.powerUser}" var="user">
									<tr>
										<td>
											<c:out value="${user.login}" />
										</td>
										<td>
											<c:out value="${user.importerName}" />
										</td>	
										<td>
											<c:out value="${user.importerCity}" />
										</td>										
										<td>
											<c:out value="${user.phone}" />
										</td>
										<td class="form">
											<input id="ch_2" type="checkbox" name="checkedImporters"
												value="${user.id}" />
										</td>
									</tr>
								</c:forEach>
								<tr>									
									<td>
										<input id="btn3" name="control" type="submit" value="Confirm" />
									</td>
									<td>
										<input id="btn4" name="control" type="submit" value="Delete" />
									</td>
								</tr>
							</table>
						</form>
						<br />						
					</div>
					</center>
				</div>
			</div>			

	</body>
</html>