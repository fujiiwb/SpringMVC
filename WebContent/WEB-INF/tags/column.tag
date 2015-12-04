<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="headerText" required="true"%>
<html>
	<head>
		<script type="text/javascript">
			function createHeader(header){
				var tableHeader = document.getElementById("tableHeaderTR");
				var tableHeaderHTML = tableHeader.innerHTML;
// 				console.log(header + ': ' + (tableHeaderHTML.indexOf('id="' + header + '"') <= -1));
				if (tableHeaderHTML.indexOf('id="' + header + '"') <= -1) {
					tableHeaderHTML += '<th id="' + header + '">' + header + '</th>';
					tableHeader.innerHTML = tableHeaderHTML;
				}
			}
		</script>
	</head>
	<body>
		<td headers="${headerText}">
			<script type="text/javascript">createHeader('${headerText}')</script>
			<jsp:doBody/>
		</td>
	</body>
</html>