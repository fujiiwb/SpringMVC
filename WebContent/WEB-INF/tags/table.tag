<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="list" required="true" type="java.util.List"%>

<html>
	<body>
		<table class="panel">
			<thead id="tableHeader">
				<tr id="tableHeaderTR">
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="object" varStatus="iterator">
					<c:set var="listObject" value="${object}" scope="session"/>
					<c:set var="iterator" value="${iterator}" scope="session"/>
					<tr>
						<jsp:doBody/>
					</tr>
					<c:remove var="listObject"/>
					<c:remove var="iterator"/>
				</c:forEach>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</body>
</html>