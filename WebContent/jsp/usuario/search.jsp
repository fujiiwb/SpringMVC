<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<t:template>
		<div align="center">
			<div align="center" class="header">
				Buscar Usuário
			</div>
			<div id="divMessage">
				<output id="message">${message}</output>
			</div>
			<sf:form id="formUsuarioSearch" method="POST" action="${pageContext.request.contextPath}/usuario/search/do">
				<input type="text" name="busca" id="busca">
				<input type="submit" value="Buscar">
			<output>${usuarios}</output>
			</sf:form>
			<br/>
			<table id="datatable">
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>Username</th>
					<th>Senha</th>
				</tr>
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
			</table>
		</div>

		<script type="text/javascript">
			$(document).ready(function(){
				$('#formUsuarioSearch').submit(function(event){
					var buscaJson = $('#busca').val();

					$.ajax({
						url: $("#formUsuarioSearch").attr("action"),
						type: $("#formUsuarioSearch").attr("method"),
						data: JSON.stringify(buscaJson),

						beforeSend:function(xhr) {
							xhr.setRequestHeader("Accept", "application/json;charset=utf-8");
							xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
						},
						success:function(usuarios) {
// 							document.getElementById("message").innerHTML = "Usuario criado com sucesso! " + usuarios[0].nome;
// 							$("#datatable").html(usuarios);
						},
						error:function(jqXHR, textStatus, errorThrown) {
							var respContent="";
							respContent += "<span class='error'>Ocorreu um erro no processamento da requisição:";
							respContent += "<br/>Error Thrown: " + errorThrown;
							respContent += "<br/>Text Status: " + textStatus;
							respContent += "<br/>jqXHR: " + jqXHR;
							respContent += "<br/>JSON: " + JSON.stringify(buscaJson) + "</span>";
							$("#divMessage").html(respContent);
						}
					});
					event.preventDefault();
				});
			});
		</script>
	</t:template>
</html>