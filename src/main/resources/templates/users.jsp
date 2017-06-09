<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- <meta charset="utf-8"> -->
<meta http-equiv="content-type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>VideoStore. Alta/Modificaci�n de usuarios</title>

<meta name="description" content="Welcome home!">
<meta name="author" content="�lvaro Fern�ndez">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<style>
.qt {
	margin-top: 100px;
}

/* Style all font awesome icons */
.fa {
	/* padding: 40px;*/
	font-size: 40px;
	width: 50px;
	/*text-align: center;*/
	text-decoration: none;
	padding-top: 15px;
}

.dark {
	background-color: #161616;
	color: white;
	padding-top: 15px;
}

.pad-left {
	padding-left: 100px;
}

.title-top {
	padding-top: 100px;
}

/* Add a hover effect if you want */
.fa:hover {
	opacity: 0.7;
}

</style>




</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10 title-top">
						<h3>Lista de usuarios</h3>
					</div>
					<div class="col-md-1"></div>
				</div>
				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation">
					<div class="navbar-header">

						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">VideoStore</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="Home">Inicio</a></li>
							<li class="active"><a href="Users">Usuarios</a></li>
							<li><a href="Movies">Pel�culas</a></li>
							<li><a href="MoviesManagement">Gesti�n de Pel�culas</a></li>
						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input class="form-control" type="text">
							</div>
							<button type="submit" class="btn btn-default">Buscar</button>
						</form>

					</div>

				</nav>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<table id="usersTable" class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<!-- <th>Apellidos</th> -->
									<th>Correo</th>
									<!-- <th>Fecha de creaci�n</th> -->
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<div class="col-md-1">
						<a id="modal-user" href="#modal-container-user" role="button"
							class="btn btn-primary" data-toggle="modal">+</a>
					</div>


					<div class="col-md-12">

						<!-- MODAL NEW USER -->
						<div class="modal fade" id="modal-container-user" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">�</button>
										<h4 class="modal-title" id="myModalLabel">Nuevo usuario</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="inputName"> Nombre </label>
											<input class="form-control" id="inputName" type="text">
											<label id="errorMessageName" for="inputName" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<!-- <div class="form-group">
											<label for="inputLastname"> Apellidos </label>
											<input class="form-control" id="inputLastname" type="text">
											<label id="errorMessageLastname" for="inputLastname" class="bold-red">
											* Campo obligatorio</label>
										</div> -->
										<div class="form-group">
											<label for="inputEmail"> Correo electr�nico </label>
											<input class="form-control" id="inputEmail" type="email">
											<label id="errorMessageEmail" for="inputEmail" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputPassword"> Contrase�a </label>
											<input class="form-control" id="inputPassword" type="password">
											<label id="errorMessagePassword" for="inputPassword" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputRepeatPassword"> Repetir contrase�a </label>
											<input class="form-control" id="inputRepeatPassword"
												type="password">
											<label id="errorMessageRepeatPassword" for="inputRepeatPassword" class="bold-red">
											* Campo obligatorio</label>
										</div>

									</div>
									<div class="modal-footer">

										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button type="button" class="btn btn-success"
											onClick="saveUser();">Guardar</button>
									</div>
								</div>

							</div>
						</div>
						<!-- END MODAL NEW USER -->


						<!-- MODAL UPDATE USER -->
						<div class="modal fade" id="modal-container-update-user"
							role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">�</button>
										<h4 class="modal-title" id="myModalLabel2">Modificar
											usuario</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="inputName2"> Nombre </label> <input
												class="form-control" id="inputName2" type="text">
												<label id="errorMessageName2" for="inputName2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<!-- <div class="form-group">
											<label for="inputLastname2"> Apellidos </label> <input
												class="form-control" id="inputLastname2" type="text">
												<label id="errorMessageLastname2" for="inputLastname2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div> -->
										<div class="form-group">
											<label for="inputEmail2"> Correo electr�nico </label> <input
												class="form-control" id="inputEmail2" type="email">
												<label id="errorMessageEmail2" for="inputEmail2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputPassword2"> Contrase�a </label> <input
												class="form-control" id="inputPassword2" type="password">
												<label id="errorMessagePassword2" for="inputPassword2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputRepeatPassword2"> Repetir contrase�a
											</label> <input class="form-control" id="inputRepeatPassword2"
												type="password">
												<label id="errorMessageRepeatPassword2" for="inputRepeatPassword2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>

									</div>
									<div class="modal-footer">

										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button type="button" id="buttonUpdateUser" class="btn btn-success">Actualizar</button>
									</div>
								</div>

							</div>
						</div>
						<!-- END MODAL UPDATE USER -->


						<!-- MODAL DELETE USER -->
						<div class="modal fade" id="modal-container-delete-user"
							role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">�</button>
										<h4 class="modal-title" id="myModalLabel3">Eliminar
											usuario</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label> �Est�s seguro de que quieres eliminar este
												usuario? </label>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button id="buttonDeleteUser" type="button" class="btn btn-danger">Eliminar</button>
									</div>
								</div>

							</div>
						</div>
						<!-- END MODAL DELETE USER -->

					</div>


				</div>
			</div>
		</div>
		<div class="row dark" style="margin-top: 250px;">
			<div class="col-md-4 pad-left">

				<address>
					<strong>VideoStore, Inc.</strong><br> Paseo de la Castellana,
					666<br> Madrid, MA 28046<br> <abbr title="Tel�fono">Tlf:</abbr>
					(912) 202122
				</address>
			</div>
			<div class="col-md-4">
				<blockquote>
					<p>To infinite...and beyond!!.</p>
					<small>Buzz Lightyear <cite>Toy Story</cite></small>
				</blockquote>
			</div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-4">
						<a href="https://www.facebook.com" class="fa fa-facebook"></a>
					</div>
					<div class="col-md-4">
						<a href="https://twitter.com/?lang=es" class="fa fa-twitter"></a>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/scripts.js"></script>
	<script src="resources/js/jquery.dataTables.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(
				function() {
					console.log("ready!");

					$("#modal-container-user").on(
							'hidden.bs.modal',
							function(e) {
								$(this).find("input,textarea,select").val('').end();
								
								$('#errorMessageName').removeClass("hidden");
								//$('#errorMessageLastname').removeClass("hidden");
								$('#errorMessageEmail').removeClass("hidden");
								$('#errorMessagePassword').removeClass("hidden");
								$('#errorMessageRepeatPassword').removeClass("hidden");
								
								$('#errorMessagePassword').text("* Campo obligatorio");
								$('#errorMessageEmail').text("* Campo obligatorio");
							});

					$("#modal-container-update-user").on(
							'hidden.bs.modal',
							function(e) {
								$(this).find("input,textarea,select").val('').end();
						
								$('#errorMessagePassword2').removeClass("hidden");
								$('#errorMessageRepeatPassword2').removeClass("hidden");
								
								$('#errorMessagePassword2').text("* Campo obligatorio");
								$('#errorMessageEmail2').text("* Campo obligatorio");
							});

					
					$('#inputName').on('input', function() {
						var input = $(this);
						var is_name = input.val();
						
						var error = $('#errorMessageName');
						if(is_name){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					/* $('#inputLastname').on('input', function() {
						var input = $(this);
						var is_name = input.val();
						
						var error = $('#errorMessageLastname');
						if(is_name){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					}); */
					
					$('#inputEmail').on('input', function() {
						var input = $(this);
						var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
						
						var is_email = re.test(input.val());
						
						var error = $('#errorMessageEmail');
						if(is_email){
							error.addClass("hidden");
						}
						else if(input.text==""){
							error.removeClass("hidden");
							error.text("* Campo obligatorio");
						}
						else{
							error.removeClass("hidden");
							error.text("* Direcci�n de email incorrecta");
						}
					});
					
					$('#inputPassword').on('input', function() {
						var input = $(this);
						var is_pass = input.val();
						
						var error = $('#errorMessagePassword');
						if(is_pass){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputRepeatPassword').on('input', function() {
						var input = $(this);
						var is_pass = input.val();
						
						var error = $('#errorMessageRepeatPassword');
						if(is_pass){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});

					
					$('#inputName2').on('input', function() {
						var input = $(this);
						var is_name = input.val();
						
						var error = $('#errorMessageName2');
						if(is_name){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					/* $('#inputLastname2').on('input', function() {
						var input = $(this);
						var is_name = input.val();
						
						var error = $('#errorMessageLastname2');
						if(is_name){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					}); */
					
					$('#inputEmail2').on('input', function() {
						var input = $(this);
						var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
						
						var is_email = re.test(input.val());
						
						var error = $('#errorMessageEmail2');
						if(is_email){
							error.addClass("hidden");
						}
						else if(input.val==""){
							error.removeClass("hidden");
							error.text("* Campo obligatorio");
						}
						else{
							error.removeClass("hidden");
							error.text("* Direcci�n de email incorrecta");
						}
					});
					
					$('#inputPassword2').on('input', function() {
						var input = $(this);
						var is_pass = input.val();
						
						var error = $('#errorMessagePassword2');
						if(is_pass){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputRepeatPassword2').on('input', function() {
						var input = $(this);
						var is_pass = input.val();
						
						var error = $('#errorMessageRepeatPassword2');
						if(is_pass){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					
					$('#usersTable').dataTable( {
						 "language":{ 
							"lengthMenu":"Mostrar _MENU_ registros por p�gina.",
						       "zeroRecords": "No se han encontrado registros.",
				             "info": "Mostrando p�gina _PAGE_ de _PAGES_",
				             "infoEmpty": "No hay registros a�n.",
				             "infoFiltered": "(filtrados de un total de _MAX_ registros)",
				             "search" : "B�squeda",
				             "LoadingRecords": "Cargando ...",
				             "Processing": "Procesando...",
				             "SearchPlaceholder": "Buscar...",
				             "paginate": {
							     "previous": "Anterior ",
							     "next": " Siguiente"
						     }
						},
						"columnDefs": [
						    { "name": "#", "targets": 0 },
						    { "name": "Nombre", "targets": 1 },
						    //{ "name": "Apellidos", "targets": 2 },
						    { "name": "Correo", "targets": 2 }
						    //{ "name": "Fecha de creaci�n", "targets": 4 },
						    //{ "name": "Estado", "targets": 5 }
						  ]
						
			        } );
					
							
				});
	</script>
</body>
</html>