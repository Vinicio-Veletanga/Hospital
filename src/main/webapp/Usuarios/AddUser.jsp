<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen" href="/Hospital/css/formularioRegistro.css" />
<script type="text/javascript" src="/Hospital/js/login.js"></script>
<title>Crear Cuenta</title>
</head>
<body>
	<form action="/Hospital/CreateUser" class="form-register" method="post" onsubmit="return validar()">
		<h4>Crear Cuenta</h4>
		<input class="controls" type="text" name="nombres" id="nombres"  pattern="[a-zA-Z\s]*"  title="Debe solo ingresar texto"  placeholder="Ingrese sus nombres" required><br>
		<span id="mensajeNombres" class="error"></span>
		
		<input class="controls" type="text" name="apellidos" id="apellidos"   pattern="[a-zA-Z\s]*"  title="Debe solo ingresar texto"  placeholder="Ingrese sus apellidos" required/><br>
		<span id="mensajeApellidos"> </span>
		
		<input class="controls" type="text" name="cedula" id="cedula" placeholder="Ingrese su cedula"  maxlength="10"   pattern="[0-9]*" title="Debe solo ingresar numeros"   required/><br>
		<span id="mensajeCedula" class="error"></span>
		
		<input class="controls" type="text" name="direccion" id="direccion" placeholder="Ingrese su Dirección" required/><br>
		
		<input class="controls" type="text" name="telefono" id="telefono" placeholder="Ingrese su #teléfono" required/><br>
		<input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su email" required/><br>
		
		<select class="controls"  name="rol" required>
			<option>Seleccione el Rol</option>
			<option value="Doctor">Doctor</option>
			<option value="Secretaria">Secretaria</option>
			<option value="Administrador">Administrador</option>
		</select>
		<br>
		<p>Estoy de acuerdo con <a href="#">Terminos y condiciones</a></p>
		<input class="botons" type="submit" value="Crear Usuario" onclick="validar">
		<p><a href="/Hospital/index.html">¿Ya tengo cuenta?</a></p>
	</form>
	
</body>
</html>