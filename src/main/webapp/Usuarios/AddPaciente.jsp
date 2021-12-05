<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="/Hospital/css/formularioRegistro.css" />
<script type="text/javascript" src="/Hospital/js/login.js"></script>
<title>Crear Cuenta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<form action="/Hospital/CreatePaciente" class="form-register" method="post" onsubmit="return validar()">
		<h1 class="display-5">Paciente</h1>
		<br>
		<input class="controls form-control form-control-lg" type="text" name="nombres" id="nombres"  pattern="[a-zA-Z\s]*"  title="Debe solo ingresar texto"  placeholder="Ingrese sus nombres" required>
		<span id="mensajeNombres" class="error"></span>
		
		<input class="controls form-control form-control-lg" type="text" name="apellidos" id="apellidos"   pattern="[a-zA-Z\s]*"  title="Debe solo ingresar texto"  placeholder="Ingrese sus apellidos" required/>
		<span id="mensajeApellidos"> </span>
		
		<input class="controls form-control form-control-lg" type="text" name="cedula" id="cedula" placeholder="Ingrese su cedula"  maxlength="10"   pattern="[0-9]*" title="Debe solo ingresar numeros"   required/>
		<span id="mensajeCedula" class="error"></span>
		
		<input class="controls form-control form-control-lg" type="text" name="direccion" id="direccion" placeholder="Ingrese su dirección" required/>
		
		<input class="controls form-control form-control-lg" type="text" name="telefono" id="telefono" placeholder="Ingrese su teléfono" required/>
		<input class="controls form-control form-control-lg" type="email" name="correo" id="correo" placeholder="Ingrese su email" required/>
		
		<input class="controls form-control form-control-lg" type="password" name="password" id="password" placeholder="Ingrese su contraseña" required>
		
		<input class="botons btn btn-primary mb-3" type="submit" value="Crear Usuario" onclick="validar">
		<p class="lead"><a class="navbar-brand" href="/Hospital/index.html"><strong>¿Ya tengo cuenta?</strong></a></p>
	</form>
	
</body>
</html>