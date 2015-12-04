<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="x"   tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="t"   tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="s"   uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<style type="text/css">
			spaceless, .spaceless {
	 			max-width: 1450px!important;
			}
			table {
				max-width: 800px!important;
			}
		</style>
	</head>
	<body>
		<t:template>
        	<h2>List of Cookies: ${cookie}</h2>
        	<table>
	            <c:forEach var="entry" items="${cookie}">
            		<tr>
	                	<td>${entry.key}</td>
                		<td>
	                    	<c:out value="${entry.value}"/>
	                	</td>
            		</tr>
            	</c:forEach>
        	</table>

        	<h2>List of Header Parameters: ${header}</h2>
        	<table>
	            <c:forEach var="entry" items="${header}">
            		<tr>
	                	<td>${entry.key}</td>
                		<td>
	                    	<c:out value="${entry.value}"/>
	                	</td>
            		</tr>
            	</c:forEach>
        	</table>

        	<h1>JSTL Examples</h1>
        	<h2>List of Application Context: ${applicationScope}</h2>
        	<table>
	            <c:forEach var="entry" items="${applicationScope}">
            		<tr>
	                	<td>${entry.key}</td>
                		<td>
	                    	<c:out value="${entry.value}"/>
	                	</td>
            		</tr>
            	</c:forEach>
        	</table>

        	<h2>List of Session Context: ${sessionScope}</h2>
        	<table>
	           	<c:forEach var="entry" items="${sessionScope}">
            		<tr>
	                	<td>${entry.key}</td>
                		<td>
	                    	<c:out value="${entry.value}"/>
                		</td>
            		</tr>
            	</c:forEach>
        	</table>

        	<h2>List of Page Context: ${pageScope}</h2>
        	<table>
	            <c:forEach var="entry" items="${pageScope}">
            		<tr>
	                	<td>${entry.key}</td>
                		<td>
	                    	<c:out value="${entry.value}"/>
	                	</td>
	            	</tr>
            	</c:forEach>
        	</table>

        	<h2>List of Request Context: ${requestSope}</h2>
        	<table>
	            <c:forEach var="entry" items="${requestSope}">
            		<tr>
	                	<td>${entry.key}</td>
                		<td>
		                    <c:out value="${entry.value}"/>
                		</td>
            		</tr>
            	</c:forEach>
        	</table>

        	<h2>List of Query Parameters: ${param}</h2>
        	<table>
	            <c:forEach var="entry" items="${param}">
            		<tr>
		                <td>${entry.key}</td>
                		<td>
		                    <c:out value="${entry.value}"/>
                		</td>
            		</tr>
            	</c:forEach>
        	</table>
		</t:template>
	</body>
</html>