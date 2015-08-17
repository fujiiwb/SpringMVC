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
			<sf:form id="formUsuarioUpdate" method="POST" action="${pageContext.request.contextPath}/usuario/update/do" class="panel">
				<div align="center" class="header">
					Adicionar Usuário
				</div>
				<div id="divMessage">
				<output id="message">${message}</output>
				</div>
				<input class="hidden" type="hidden" id="id" name="id" value="${usuario.id}"/>
				<table class="sem_borda" style="width: 99%">
					<tr>
						<td class="col-50 pos-1">Usuário:</td>
						<td class="col-50 pos-1">Senha:</td>
					</tr>
					<tr>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="16" id="username" name="username" value="${usuario.username}" disabled="disabled"/></td>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="128" id="senha" name="senha" value="${usuario.senha}"/></td>
					</tr>
					<tr>
						<td class="col-50 pos-1">Nome:</td>
						<td class="col-50 pos-1">Sobrenome:</td>
					</tr>
					<tr>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="128" id="nome" name="nome" value="${usuario.nome}"/></td>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="128" id="sobrenome" name="sobrenome" value="${usuario.sobrenome}"/></td>
					</tr>
				</table>
				<br/>
				<input type="submit" value="Confirmar Alterações">
			</sf:form>
		</div>

		<script type="text/javascript">
			$(document).ready(function(){
				$('#formUsuarioUpdate').submit(function(event){
					var userJson = {
							"id" : Number($('#id').val()),
							"nome" : $('#nome').val(),
							"sobrenome" : $('#sobrenome').val(),
							"username" : $('#username').val(),
							"senha" : $('#senha').val()
					}

					$.ajax({
						url: $("#formUsuarioUpdate").attr("action"),
						type: $("#formUsuarioUpdate").attr("method"),
						data: JSON.stringify(userJson),

						beforeSend:function(xhr) {
							xhr.setRequestHeader("Accept", "application/json;charset=utf-8");
							xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
						},
						success:function(usuario) {
// 							document.getElementById("message").innerHTML = "Usuario editado com sucesso!";
							alert(usuario.responsetext);
						},
						error:function(jqXHR, textStatus, errorThrown) {
							var respContent="";
							respContent += "<span class='error'>Ocorreu um erro no processamento da requisição:";
							respContent += "<br/>Error Thrown: " + errorThrown;
							respContent += "<br/>Text Status: " + textStatus;
							respContent += "<br/>jqXHR: " + jqXHR;
							respContent += "<br/>JSON: " + JSON.stringify(userJson) + "</span>";
							$("#divMessage").html(respContent);
						}
					});
					event.preventDefault();
				});
			});
		</script>
	</t:template>
</html>