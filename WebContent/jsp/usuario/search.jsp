<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="x"   tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="t"   tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="s"   uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
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
			</sf:form>
			<br/>
			<input name="usuariosInput" id="usuariosList" type="hidden" value="${usuarios}">
			<table id="datatable">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Sobrenome</th>
						<th>Username</th>
						<th>Senha</th>
					</tr>
				</thead>
				<tbody id="datatable-body">
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
			$(document).ready(function(){
				$('#formUsuarioSearch').submit(function(event){
					var buscaJson = $('#busca').val();
					var htmlTable = "";

					$.ajax({
					    url: $("#formUsuarioSearch").attr("action"),
						type: $("#formUsuarioSearch").attr("method"),
						data: JSON.stringify(buscaJson),

						beforeSend:function(xhr) {
							xhr.setRequestHeader("Accept", "application/json;charset=utf-8");
							xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
						},
						success:function(result,status,xhr) {
							var a = JSON.parse(xhr.responseText);
							a.forEach(function(object,index,list) {
								htmlTable += "<tr>";
								htmlTable += "    <td>" + object.nome + "</td>";
								htmlTable += "    <td>" + object.sobrenome + "</td>";
								htmlTable += "    <td>" + object.username + "</td>";
								htmlTable += "    <td>" + object.senha + "</td>";
								htmlTable += "    <td>";
								htmlTable += '        <form action="${pageContext.request.contextPath}/usuario/update" method="post">';
								htmlTable += '            <input name="id" type="hidden" value="' + object.id + '">';
								htmlTable += '            <input type="image" class="icon pos-5" src="${pageContext.request.contextPath}/resources/img/pencil.png">';
								htmlTable += '        </form>';
								htmlTable += "    </td>";
								htmlTable += "    <td>";
								htmlTable += '        <form action="${pageContext.request.contextPath}/usuario/desativa" method="post">';
								htmlTable += '            <input name="id" type="hidden" value="' + object.id + '">';
								htmlTable += '            <input type="image" class="icon pos-5" src="${pageContext.request.contextPath}/resources/img/gear.png">';
								htmlTable += '        </form>';
								htmlTable += "    </td>";
								htmlTable += "</tr>";
							});
						},
						error:function(jqXHR, status, errorThrown) {
							var respContent="";
							respContent += "<span class='error'>Ocorreu um erro no processamento da requisição:";
							respContent += "<br/>Error Thrown: " + errorThrown;
							respContent += "<br/>Status: " + status;
							respContent += "<br/>jqXHR: " + jqXHR;
							respContent += "<br/>JSON: " + JSON.stringify(buscaJson) + "</span>";
							$("#divMessage").html(respContent);
						},
						complete:function(jqXHR,status) {
							document.getElementById('datatable-body').innerHTML = htmlTable;
// 							console.log("complete(status): " + status.responseText);
// 							console.log("complete(jqXHR): " + jqXHR.responseText);
						}
					}).done(function(result,status,xhr){
// 							console.log("done(result): " + result.responseText);
// 							console.log("done(status): " + status.responseText);
// 							console.log("done(xhr): " + xhr.responseText);
					});
					event.preventDefault();
				});
			});
		</script>
	</t:template>
</html>