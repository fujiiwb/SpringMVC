<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html lang="en">
	<head>
		<title>Página Inicial - HTML5</title>
		
		<style>
			header,footer,section,article {
    			border: 1px solid grey;
    			margin: 5px;
    			margin: 5px 5px 5px 5px;
    			padding: 8px;
    			background-color: white;
			}
			header,footer {
    			color: #A8A8A8;
    			background-color: #444;
    			margin: 5px 5px 5px 5px;
			}
			section {
    			background-color: #DDD;
			}
			nav ul  {
    			margin: 0;
    			padding: 0;
			}
			nav ul li {
    			display: inline;
    			margin: 5px;
			}
		</style>
	</head>
	<t:template>
		<script type="text/javascript">
			$(document).ready(function(){
		    	$(".toggle-1").click(function(){
		        	$("section.part-1").fadeToggle("slow", "swing");
		    	});
		    	$(".toggle-2").click(function(){
		        	$("article.part-2").fadeToggle("slow", "swing");
		    	});
		    	$(".toggle-3").click(function(){
		        	$("article.part-3").fadeToggle("slow", "swing");
		    	});
		    	$(".toggle-4").click(function(){
		        	$("article.part-4").fadeToggle("slow", "swing");
		    	});
			});
		</script>
		<div align="center">
			<header>
	  			<h1>Monday Times</h1>
			</header>
		</div>
		<nav>
  			<ul>
    			<li class="toggle-1">Toggle 1</li>
    			<li class="toggle-2">Toggle 2</li>
    			<li class="toggle-3">Toggle 3</li>
    			<li class="toggle-4">Toggle 4</li>
  			</ul>
		</nav>

		<section class="part-1">
			<h2>News Section</h2>

			<article>
  				<h2>News Article</h2>
  				<p>Ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum.</p>
  				<p>Ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum.</p>
  				<p>Ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum.</p>
			</article>

			<article>
				<h2>News Article</h2>
  				<p>Ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum.</p>
  				<p>Ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum.</p>
  				<p>Ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum ipsum lurum hurum turum.</p>
			</article>
		</section>

		<article class="part-2">
			<h2>Famous Cities</h2>
			<article>
				<h2>London</h2>
				<p>London is the capital city of England. It is the most populous city in the United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
			</article>

			<article>
				<h2>Paris</h2>
				<p>Paris is the capital and most populous city of France.</p>
			</article>

			<article>
				<h2>Tokyo</h2>
				<p>Tokyo is the capital of Japan, the center of the Greater Tokyo Area, and the most populous metropolitan area in the world.</p>
			</article>
		</article>

		<article class="part-3">
			<h2>Famous Cities</h2>
			<div class="city">
				<h2>London</h2>
				<p>London is the capital city of England. It is the most populous city in the United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
			</div>

			<div class="city">
				<h2>Paris</h2>
				<p>Paris is the capital and most populous city of France.</p>
			</div>

			<div class="city">
				<h2>Tokyo</h2>
				<p>Tokyo is the capital of Japan, the center of the Greater Tokyo Area, and the most populous metropolitan area in the world.</p>
			</div>
		</article>

		<article class="part-4">
			<section>
				<h2>Famous Cities</h2>

				<div class="city">
					<h2>London</h2>
					<p>London is the capital city of England. It is the most populous city in the United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
				</div>

				<div class="city">
					<h2>Paris</h2>
					<p>Paris is the capital and most populous city of France.</p>
				</div>

				<div class="city">
					<h2>Tokyo</h2>
					<p>Tokyo is the capital of Japan, the center of the Greater Tokyo Area, and the most populous metropolitan area in the world.</p>
				</div>
			</section>

			<section>
				<h2>Famous Countries</h2>

				<div class="country">
					<h2>England</h2>
					<p>London is the capital city of England. It is the most populous city in the United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
				</div>

				<div class="country">
					<h2>France</h2>
					<p>Paris is the capital and most populous city of France.</p>
				</div>

				<div class="country">
					<h2>Japan</h2>
					<p>Tokyo is the capital of Japan, the center of the Greater Tokyo Area, and the most populous metropolitan area in the world.</p>
				</div>
			</section>
		</article>

		<footer>
  			<p>&copy; 2014 Monday Times. All rights reserved.</p>
		</footer>
	</t:template>
</html>