<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>${title}</title>
	</head>
	<t:template>
		<form action="${redirect}">
			<br/>
			<output style="font-weight: bold">${mensagem}</output>
			<br/><br/>
			<button autofocus="autofocus">Retornar</button>
		</form>
	</t:template>
</html>