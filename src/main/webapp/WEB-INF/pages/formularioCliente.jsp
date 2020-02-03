<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario cliente</title>
</head>
<body>
 	<main>
	 	<header>
		 	<h1>Formulario clientes</h1> 
		</header>
		<nav>
			<button class="button formulario" onclick="history.back()">Formularios</button>
		</nav>
	 	<article>
	 		<div class="formulario-cliente">
		 		<form:form method="post" action="guardarCliente" modelAttribute="cliente">
			 		Rut: <form:input path="rut"/>
			 		Nombre: <form:input path="nombre"/>
			 		Apellido Paterno: <form:input path="apellidoPaterno"/>
			 		Apellido Materno: <form:input path="apellidoMaterno"/>
			 		<input type="submit" value="Guardar">
			 	</form:form>
	 		</div>
	 		
	 		
		 	
	 	</article>
	 	<footer>
	 	</footer>
 	</main>
</body>
</html>