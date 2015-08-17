<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
	 	<meta charset=”UTF-8”>
		<link href="<%=request.getContextPath()%>/resources/spring.ico" rel="icon" type="image/x-icon"/>
		<link href="<%=request.getContextPath()%>/resources/css/template.css" rel="stylesheet"/>
		<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet"/>
		<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.3.min.js"></script>
	</head>
	<body>
		<div id="horizontalmenu" align="left">
			<ul>
				<li>
					<a href="${pageContext.request.contextPath}/inicial" onclick="teste()" id="asdf">Arquivo</a>
					<ul>
						<li>
							<a href="${pageContext.request.contextPath}/inicial">Menu Principal</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/ok">Ok</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/hardreset">Hard Reset</a>
						</li>
						<li>
							<a href="#">Sair</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/usuario">Usuario</a>
					<ul>
						<li>
							<a href="${pageContext.request.contextPath}/usuario/search">Buscar</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/usuario/create">Cadastrar</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/usuario/update">Alterar</a>
						</li>
						<li>
							<a href="#">Excluir</a>
						</li>
							<li>
							<a href="#">-</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#">Teste 1</a>
					<ul>
						<li>
							<a href="#">Teste 1.1</a>
						</li>
						<li>
							<a href="#">Teste 1.2</a>
						</li>
						<li>
							<a href="#">Teste 1.3</a>
						</li>
						<li>
							<a href="#">Teste 1.4</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#">Teste 2</a>
					<ul>
						<li>
							<a href="#">Teste 2.1</a>
						</li>
						<li>
							<a href="#">Teste 2.2</a>
						</li>
						<li>
							<a href="#">Teste 2.3</a>
						</li>
						<li>
							<a href="#">Teste 2.4</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/teste/ajax">Testes</a>
					<ul>
						<li>
							<a href="${pageContext.request.contextPath}/teste/ajax">AJAX</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<jsp:doBody/>
	</body>
</html>