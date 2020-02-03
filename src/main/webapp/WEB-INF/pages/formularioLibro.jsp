<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Libro</title>
</head>
<body>
	<main>
	 	<header>
		 	<h1>Formulario libro</h1> 
		</header>
		<nav>
			<button class="button formulario" onclick="history.back()">Formularios</button>
		</nav>
	 	<article>
	 		<div class="formulario-libro">
		 		<form:form method="post" action="guardarLibro" modelAttribute="libro">
			 		Nombre: <input type="text" name="nombre"/>
			 		Editorial: <input type="text" name="editorial"/>
			 		Fecha: <input type="date" name="fecha"/>
			 		<input type="submit" value="Guardar">
			 	</form:form>
	 		</div>
	 		
	 		
		 	
	 	</article>
	 	<footer>
	 	</footer>
 	</main>
</body>
</html>