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
</head>
<body>
	<t:template>
		<x:table list="${usuarios}">
			<x:column headerText="Iterator">
				${iterator.index}
			</x:column>
			<x:column headerText="Nome">
				${listObject.nome}
			</x:column>
			<x:column headerText="Sobrenome">
 				${listObject.sobrenome}
			</x:column>
			<x:column headerText="Username">
 				${listObject.username}
			</x:column>
		</x:table>
	</t:template>
</body>
</html>