<%@ page language="java" contentType="text/html; charset=Windows-1251"
    pageEncoding="Windows-1251"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register page</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<div id="header">
	<hr/><table border=0><tr><td>
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>������� ���������� ��������� ����������</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
   <div id="page">
		
		<div id="content">
			<div class="post">
				<h2 class="title">���� �����, �������������</h2>
				<div class="entry">
					<p>������� ����, �� ���� �� ������ ��������������.</p>	
				    
				    �� ������ ���������� ��:<br>
				    
				    <form:form commandName="regForm">
				    <table>
				    <tr>
				        <td>���������� � ���������� �������: </td>
				        <td><form:radiobutton path="role" value="LowUser"/><br></td>
				    </tr>
				    <tr>
				        <td>���������� � ����������� �������: </td>
				        <td><form:radiobutton path="role" value="PowerUser"/><br></td>
				    </tr>
				    <tr>
				        <td>�����������: </td>
				        <td><form:radiobutton path="role" value="Administrator"/><br></td>
				    </tr>				    
				    
				    <tr>
				        <td>
							<input type="submit" name="back" value="<< �����������"/>	
						</td>
				        <td>
				        <input type="submit" value="��� >>"/>
				        </td>
				    </tr>
				    </table>
				    </form:form>
				   	
				</div>
			</div>
		</div>
	</div>	
</div>
</body>
</html>