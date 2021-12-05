<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registroCita</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Potta+One&family=Spartan:wght@300;600&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/fc9d3d8245.js"
	crossorigin="anonymous"></script>

</head>
<body>


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#campofecha").datepicker({
				numberOfMonths : 2,
				showButtonPanel : true
			});
		});
	</script>


	

<div class="container col-8">
<h1>Registre su Cita Médica</h1>
<form action="Cita" method="POST">

	<div class="row mb-3 border border-primary">
		
			<div class="col-md-3">
				<label for="paciente" class="form-label">PACIENTE</label>
			</div>
			<div class="col">
				<input type="text" class="form-control" placeholder="0101010101"
					readonly="readonly" disabled>
			</div>
			<div class="col">
				<input type="text" class="form-control" placeholder="JUAN PEREZ"
					readonly="readonly" disabled>
			</div>
			<div class="col">
				<input type="text" class="form-control" placeholder="999999999"
					readonly="readonly" disabled>
			</div>
	</div>

	<div class="mb-3">
		<label for="especialidad" class="form-label">Especialidades</label> <select
			class="form-select" aria-label="Default select example">
			<option selected>Psicología Clinica</option>
			<option value="1">Traumatologia</option>
			<option value="2">Ginecologia</option>
			<option value="3">Cardiologia</option>
			<option value="4">Odontología</option>
		</select placeholder= "" required>
		<div id="medicoHelp" class="form-text">Seleccione la
			especialidad</div>
	</div>

	<div class="mb-3">
		<label for="medico" class="form-label">Medicos</label> <select
			class="form-select" aria-label="Default select example">
			<option selected>Dr. Juan Durazno</option>
			<option value="1">Dra. Regina Barrera</option>
			<option value="2">Dra. Maria Mendieta</option>
			<option value="3">Dr. Diego Altamirano</option>
		</select placeholder= "" required>
		<div id="medicoHelp" class="form-text">Seleccione su Medico de
			preferencia</div>
	</div>

	<div class="col-md-3">
		<label for="fecha" class="form-label">Fecha de la Cita</label> <input
			type="text" id="campofecha" class="form-control">
	</div>

	<div class="mb-3">
		<label for="validationTextarea" class="form-label">Sintomatología</label>
		<textarea class="form-control is-invalid" id="validationTextarea"
			placeholder="DESCRIBA SU SINTOMATOLOGÍA" required></textarea>
	</div>


	<div class="col-md-2">
		<label for="estado" class="form-label">Estado de la Cita</label> <input
			type="text" class="form-control" placeholder="POR ATENDER"
			readonly="readonly" disabled>
	</div>

	<div class="mb-3">
		<label for="validationTextarea" class="form-label">Comentario</label>
		<textarea class="form-control" name="comentario" id="validationTextarea"></textarea>
	</div>

	<div class="col-md-2">
		<label for="costo" class="form-label">Costo</label> <input type="text"
			class="form-control" id="costo" placeholder="Pendiente"
			readonly="readonly" disabled>
		

	</div>
<br>
	<div class="col-3 mb-4">
	<button type="submit" class="btn btn-primary">REGISTRAR</button>
	</div>
</form>
</div>
	
</body>
</html>