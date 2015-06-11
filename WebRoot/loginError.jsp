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
<title>Authorization page</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

<div id="header">
	<hr/><table border=0><tr><td>
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>Ñèñòåìè ðåçåðâíîãî êîï³þâàííÿ ³íôîðìàö³¿</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
	<div id="page">
		<div id="sidebar">
			<div id="useful-links" class="box">
				<h2 class="title">Àâòîðèçàö³ÿ</h2>
				<div class="content">
                  <form method="POST" action="j_spring_security_check" />
                 Ëîã³í: <input type="text" name="j_username"><br>
                 Ïàðîëü: <input type="password" name="j_password"><br>
                 <input type="submit" value="Óâ³éòè"></form>
                        
			                    
                        <p>
                        <a href="register.htm">çàðåºñòðóâàòèñÿ?</a>	
                        </p>		
				</div>
			</div>
		</div>		
		<div id="content">
			<div class="post">
				<h2 class="title">Ëàñêàâî ïðîñèìî!</h2>
				<div class="entry">
					<h1>Íåïðàâèëüíèé ëîã³í/ïàðîëü àáî îáë³êîâèé çàïèñ çàáëîêîâàíèé</h1>
                              
				</div>
			</div>
		</div>

	</div>
</div>
</body>
</html>
