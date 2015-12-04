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
		<title>Example of HTML Menu</title>
		<script type="text/javascript">
			window.setInterval(
				function fix() {
	    			$("td.box-1").addClass("box-1a");
	    			$("td.box-1a").removeClass("box-1");

	    			$("td.box-2").addClass("box-2a");
	    			$("td.box-2a").removeClass("box-2");

	    			$("td.box-1a").addClass("box-2");
	    			$("td.box-1a").removeClass("box-1a");

	    			$("td.box-2a").addClass("box-1");
	    			$("td.box-2a").removeClass("box-2a");
				}, 500
			);
		</script>
		<style type="text/css">
			.box-1a, .box-2a, .box-1, .box-2 {
				height: 25px!important;
				width: 25px!important;
			}
			.box-1 {
				background: white;
				border: 1px solid black;
			}
			.box-2 {
				background: black;
				border: 1px solid white;
			}
		</style>
	</head>
	<t:template>
		<table>
			<tr>
				<td class="col-33 box-1"></td>
				<td class="col-33 box-2"></td>
				<td class="col-33 box-1"></td>
			</tr>
			<tr>
				<td class="col-33 box-2"></td>
				<td class="col-33 box-1"></td>
				<td class="col-33 box-2"></td>
			</tr>
			<tr>
				<td class="col-33 box-1"></td>
				<td class="col-33 box-2"></td>
				<td class="col-33 box-1"></td>
			</tr>
		</table>
	</t:template>
</html>