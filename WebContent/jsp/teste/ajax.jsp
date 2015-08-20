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
			<sf:form id="formTeste" method="post" action="${pageContext.request.contextPath}/teste/ajax/do">
				<input id="aaaa" name="aaaa" type="text" value="Teste AAAA"/>
				<br/>
				<input id="bbbb" name="bbbb" type="text" value="Teste BBBB"/>
				<br/>
				<input type="submit" value="Teste">
				<br/>
				<div id="message"></div>
			</sf:form>
		</div>

		<script type="text/javascript">
			$(document).ready(function(){
				$('#formTeste').submit(function(event){
					var testeJson = {
							"aaaa" : $('#aaaa').val(),
							"bbbb" : $('#bbbb').val()
					}

					$.ajax({
					    'type': $("#formTeste").attr("method"),
					    'url': $("#formTeste").attr("action"),
					    'data': JSON.stringify(testeJson),

						beforeSend:function(xhr) {
							xhr.setRequestHeader("Accept", "application/json");
							xhr.setRequestHeader("Content-Type", "application/json");
						},
						success:function(result,status,jqXHR) {
// 							var respContent="<span class='success'>";
// 							respContent += "Teste editado:";
// 							respContent += "<br/>teste.aaaa: " + teste.aaaa;
// 							respContent += "<br/>teste.bbbb: " + teste.bbbb;
// 							respContent += "</span>";
// 							$("#message").html(respContent);
							console.log("success(result): " + result.responseText);
							console.log("success(status): " + status.responseText);
							console.log("success(jqXHR): " + jqXHR.responseText);
						},
						error:function(jqXHR,status,errorThrown) {
							console.log("error(jqXHR): " + jqXHR.responseText);
							console.log("error(status): " + status.responseText);
							console.log("error(errorThrown): " + errorThrown.responseText);
						},
						complete:function(jqXHR,status) {
							console.log("complete(status): " + status.responseText);
							console.log("complete(jqXHR): " + jqXHR.responseText);
						}
					});
					event.preventDefault();
				});
			});
		</script>
	</t:template>
</html>