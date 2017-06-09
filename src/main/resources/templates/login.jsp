<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login</title>

<meta name="description" content="Videoclub Login">
<meta name="author" content="Álvaro Fernández">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<style>
label {
	color: #FFFF;
}

h1.intro {
	color: #b2081f;
	font-size: 50px;
	font-weight: bold;
	line-height: 48px;
}
</style>


</head>
<body background="resources/images/background.jpg">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h1 class="intro">Inicio de sesión</h1>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form role="form">
					<div class="form-group">
						<label for="inputEmail"> Correo electrónico </label> <input
							class="form-control" id="inputEmail" type="email">
					</div>
					<div class="form-group">
						<label for="inputPassword"> Contraseña </label> <input
							class="form-control" id="inputPassword" type="password">
					</div>
					<button type="button" class="btn btn-default"
						onClick="login();">
						Login</button>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
		</div>

	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/scripts.js"></script>
</body>
</html>
