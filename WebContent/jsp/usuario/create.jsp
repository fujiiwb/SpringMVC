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
			<sf:form id="formUsuarioCreate" method="POST" action="${pageContext.request.contextPath}/usuario/create/do" class="panel">
				<div align="center" class="header">
					Adicionar Usuário
				</div>
				<div id="divMessage">
				<output id="message">${message}</output>
				</div>
				<table class="sem_borda" style="width: 99%">
					<tr>
						<td class="col-50 pos-1">Usuário:</td>
						<td class="col-50 pos-1">Senha:</td>
					</tr>
					<tr>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="16" id="username" name="username" value="${usuario.username}"/></td>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="128" name="senha" value="${usuario.senha}"/></td>
					</tr>
					<tr>
						<td class="col-50 pos-1">Nome:</td>
						<td class="col-50 pos-1">Sobrenome:</td>
					</tr>
					<tr>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="128" name="nome" value="${usuario.nome}"/></td>
						<td class="col-50 pos-7"><input class="col-99" type="text" maxlength="128" name="sobrenome" value="${usuario.sobrenome}"/></td>
					</tr>
				</table>
				<br/>
				<input type="submit" value="Adicionar">
				<%-- <textarea name="descricao" rows="5" cols="100" /> --%>
			</sf:form>
		</div>

		<script type="text/javascript">
			$(document).ready(function(){
				$('#formUsuarioCreate').submit(function(event){
					var userJson = {
							"nome" : $('#nome').val(),
							"sobrenome" : $('#sobrenome').val(),
							"username" : $('#username').val(),
							"senha" : $('#senha').val()
					}

					$.ajax({
						url: $("#formUsuarioCreate").attr("action"),
						type: $("#formUsuarioCreate").attr("method"),
						data: JSON.stringify(userJson),

						beforeSend:function(xhr) {
							xhr.setRequestHeader("Accept", "application/json;charset=utf-8");
							xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
						},
						success:function(result,status,xhr) {
							alert(xhr.responseText);
// 							document.getElementById("message").innerHTML = "Usuario criado com sucesso!";
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