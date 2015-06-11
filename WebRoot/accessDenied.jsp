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
<meta http-equiv="Content-Type" content="text/html; charset=Windows-1251">
<title>Доступ заборонено</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

<div id="header">
	<hr/><table border=0><tr><td>
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>Системи резервного копіювання інформації</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
	<div id="page">	
		<div id="content">
			<div class="post">
				<h2 class="title"></h2>
				<div class="entry">
					<h1>У доступі відмовлено! Ви не маєте достатньо прав!</h1>                              
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>