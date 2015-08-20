<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<t:template username="[INPUT USERNAME]">
		<div align="center">
			<header>
				Usuários Cadastrados
			</header>
			<table>
				<thead>
					<tr>
						<td>Nome</td>
						<td>Sobrenome</td>
						<td>Username</td>
						<td>Senha</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td>${usuario.nome}</td>
							<td>${usuario.sobrenome}</td>
							<td>${usuario.username}</td>
							<td>${usuario.senha}</td>
							<td>
								<form action="${pageContext.request.contextPath}/usuario/update" method="post">
									<input name="id" type="hidden" value="${usuario.id}">
									<input type="image" class="icon pos-5" src="${pageContext.request.contextPath}/resources/img/pencil.png">
								</form>
							</td>
							<td>
								<form action="${pageContext.request.contextPath}/usuario/desativa" method="post">
									<input name="id" type="hidden" value="${usuario.id}">
									<input type="image" class="icon pos-5" src="${pageContext.request.contextPath}/resources/img/gear.png">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<script type="text/javascript">
			
		</script>
	</t:template>
</html>