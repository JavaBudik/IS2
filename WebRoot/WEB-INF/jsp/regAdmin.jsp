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
	<img src="images/logo.gif" height=140></td><td width=50%><h1 align=center><i>Ñèñòåìè ðåçåðâíîãî êîï³þâàííÿ ³íôîðìàö³¿</i></h1></td></tr></table>
	<hr/>
</div>
<div id="bg">
	<div id="page">		
                         <form:form>
								<table border=1 class="tableHoriz">
								<tr>                                        
										<td class="header">
										Ëîã³í
										</td>
										<td width="150">
										<form:input path="login"/>
										<form:errors path="login" />										
										</td>
										
								</tr>
                                 <tr>
                                 <td class="header">
										Ïàðîëü
										</td>
										<td width="150">
										<form:password path="password"/>
										<form:errors path="password" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Ïîâòîðíèé ïàðîëü
										</td>
										<td width="150">
										<form:password path="repassword"/>
										<form:errors path="repassword" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Ñåêðåòíå ïèòàííÿ
										</td>
										<td width="150">
										<form:input path="question"/>
										<form:errors path="question" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Ñåêðåòíà â³äïîâ³äü
										</td>
										<td width="150">
										<form:input path="answer"/>
										<form:errors path="answer" />										
										</td>
										
								</tr>
								
								<tr>
								<td class="header">
										Òåëåôîí
										</td>
										<td width="150">
										<form:input path="phone"/>
										<form:errors path="phone" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										²ìÿ
										</td>
										<td width="150">
										<form:input path="firstName"/>
										<form:errors path="firstName" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Ïî-áàòüêîâ³
										</td>
										<td width="150">
										<form:input path="middleName"/>
										<form:errors path="middleName" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Ïð³çâèùå
										</td>
										<td width="150">
										<form:input path="surname"/>
										<form:errors path="surname" />										
										</td>
										
								</tr>
								<tr>
								<td class="header">
										Àäðåñà
										</td>
										<td width="150">
										<form:input path="address"/>
										<form:errors path="address" />										
										</td>
										
								</tr>								
								<form:hidden path="role"/>
								</table>
								<tr>
								    <td>
									<input type="submit" name="back" value="<< Íàçàä"/>	
									</td>
									<td>
									<input type="submit" name="control" value="Çàðåºñòðóâàòèñÿ ÿê àäì³í"/>
									</td>
								</tr>									
						</form:form>
			</div>					
</div>
</body>
</html>