<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="x"   tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="t"   tagdir="/WEB-INF/tags/template"%>
<%@attribute name="username" required="false"%>
<html>
	<body>
		<div align="center" id="div-header">
			Project Development HTML 5
		</div>
		<div align="center" id="div-center">
			<t:menubar/>
			<table style="width: 99.9%; margin-top: 0px; border: none;" class="spaceless">
				<tr>
					<td class="spaceless" style="border: none;">
						<div align="center" id="div-left">
							<jsp:doBody/>
						</div>
					</td>
					<td id="div-right" class="no-margin no-padding pos-8">
						<div align="center" class="template-menu-header" id="menu-header">
							Server Time:<br/>
							<span id="servertime" style="white-space: pre-wrap;">servertime</span>
						</div>
						<div align="center" class="template-menu-header" id="menu-header">
							Resolution:
							<span id="browser" style="white-space: pre-wrap;">browser</span>
						</div>
						<div align="center" class="template-menu-header" id="menu-header">
							Client IP:
							<br/>
							Host: <%=request.getRemoteHost()%>
							<br/>
							Addr: <%=request.getRemoteAddr()%>
							<br/>
						</div>
						<div align="center" class="template-menu-header" id="menu-header">
							Menu Principal
						</div>
						<div align="center" class="${username == null ? 'hide' : 'template-menu-item'}">
							<a href="#" class="a-clean">
								${username}
							</a>
						</div>
						<div align="center" class="template-menu-item">
							<a href="usuario" class="a-clean">
								Usuario
							</a>
						</div>
						<div align="center" class="template-menu-header">
							Links Externos
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div align="center" id="div-footer">
  			&copy; New Project Development (2015). All rights reserved.
		</div>

		<script>
			function autoResizeDiv() {
				 height = (document.body.clientHeight
						  - document.getElementById('div-header').offsetHeight
						  - document.getElementById('div-footer').offsetHeight
						  - document.getElementById('menu-header').offsetHeight
// 						  - 15
						  ) +'px';
				 document.getElementById('div-left').style.height = height;
				 document.getElementById('div-right').style.height = height;
				 document.getElementById('browser').innerHTML =
					 document.documentElement.clientWidth + " x " + document.documentElement.clientHeight;
			}
			window.onresize = autoResizeDiv;
			autoResizeDiv();
			window.setInterval(function updateServerTime() {
				date = new Date();
				document.getElementById("servertime").innerHTML = date.toLocaleTimeString() + " " + date.toLocaleDateString();
			}, 1000);
		</script>
	</body>
</html>