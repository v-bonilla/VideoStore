<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- <meta charset="utf-8"> -->
<meta http-equiv="content-type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>VideoStore. Alta/Modificación de películas</title>

<meta name="description" content="Welcome home!">
<meta name="author" content="Álvaro Fernández">

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
						<h3>Lista de películas</h3>
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
							<li><a href="Users">Usuarios</a></li>
							<li><a href="Movies">Películas</a></li>
							<li class="active"><a href="MoviesManagement">Gestión de Películas</a></li>
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
						<table id="moviesTable" class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Título</th>
									<th>Url</th>
									<th>Descripción</th>
									<th>Año</th>
									<th>Director</th>
									<th>Reparto</th>
									<th>Imagen</th>
									<th>Puntuación</th>
								</tr>
							</thead>
							<tbody>
							
							</tbody>
						</table>
					</div>
					<div class="col-md-1">
						<a id="modal-movie" href="#modal-container-movie" role="button"
							class="btn btn-primary" data-toggle="modal">+</a>
					</div>


					<div class="col-md-12">

						<!-- MODAL NEW MOVIE -->
						<div class="modal fade" id="modal-container-movie" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel">Nueva película</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="inputTitle"> Título </label>
											<input class="form-control" id="inputTitle" type="text">
											<label id="errorMessageTitle" for="inputTitle" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputDescription"> Descripción </label>
											<input class="form-control" id="inputDescription" type="text">
											<label id="errorMessageDescription" for="inputDescription" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputUrl"> URL </label>
											<input class="form-control" id="inputUrl" type="url">
											<label id="errorMessageUrl" for="inputUrl" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputYear"> Año </label>
											<input class="form-control" id="inputYear" type="number">
											<label id="errorMessageYear" for="inputYear" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputDirector"> Director </label>
											<input class="form-control" id="inputDirector"
												type="text">
											<label id="errorMessageDirector" for="inputDirector" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputCast"> Reparto </label>
											<input class="form-control" id="inputCast"
												type="text">
											<label id="errorMessageCast" for="inputCast" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputFront"> Imagen </label>
											<input class="form-control" id="inputFront"
												type="url">
											<label id="errorMessageFront" for="inputFront" class="bold-red">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputRating"> Puntuación </label>
											<input class="form-control" id="inputRating"
												type="number">
											<label id="errorMessageRating" for="inputRating" class="bold-red">
											* Campo obligatorio</label>
										</div>

									</div>
									<div class="modal-footer">

										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button type="button" class="btn btn-success"
											onClick="saveMovie();">Guardar</button>
									</div>
								</div>

							</div>
						</div>
						<!-- END MODAL NEW MOVIE -->


						<!-- MODAL UPDATE MOVIE -->
						<div class="modal fade" id="modal-container-update-movie"
							role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel2">Modificar
											película</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="inputTitle2"> Título </label>
											<input class="form-control" id="inputTitle2" type="text">
											<label id="errorMessageTitle2" for="inputTitle2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputDescription2"> Descripción </label>
											<input class="form-control" id="inputDescription2" type="text">
											<label id="errorMessageDescription2" for="inputDescription2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputUrl2"> URL </label>
											<input class="form-control" id="inputUrl2" type="url">
											<label id="errorMessageUrl2" for="inputUrl2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputYear2"> Año </label>
											<input class="form-control" id="inputYear2" type="number">
											<label id="errorMessageYear2" for="inputYear2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputDirector2"> Director </label>
											<input class="form-control" id="inputDirector2"
												type="text">
											<label id="errorMessageDirector2" for="inputDirector2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputCast2"> Reparto </label>
											<input class="form-control" id="inputCast2"
												type="text">
											<label id="errorMessageCast2" for="inputCast2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputFront2"> Imagen </label>
											<input class="form-control" id="inputFront2"
												type="text">
											<label id="errorMessageFront2" for="inputFront2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>
										<div class="form-group">
											<label for="inputRating2"> Puntuación </label>
											<input class="form-control" id="inputRating2"
												type="number">
											<label id="errorMessageRating2" for="inputRating2" class="bold-red hidden">
											* Campo obligatorio</label>
										</div>

									</div>
									<div class="modal-footer">

										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button type="button" id="buttonUpdateMovie" class="btn btn-success">Actualizar</button>
									</div>
								</div>

							</div>
						</div>
						<!-- END MODAL UPDATE MOVIE -->


						<!-- MODAL DELETE MOVIE -->
						<div class="modal fade" id="modal-container-delete-movie"
							role="dialog" aria-labelledby="myModalLabel3" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">

										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title" id="myModalLabel3">Eliminar
											película</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label> ¿Estás seguro de que quieres eliminar esta película? </label>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Cancelar</button>
										<button id="buttonDeleteMovie" type="button" class="btn btn-danger">Eliminar</button>
									</div>
								</div>

							</div>
						</div>
						<!-- END MODAL DELETE MOVIE -->

					</div>


				</div>
			</div>
		</div>
		<div class="row dark" style="margin-top: 250px;">
			<div class="col-md-4 pad-left">

				<address>
					<strong>VideoStore, Inc.</strong><br> Paseo de la Castellana,
					666<br> Madrid, MA 28046<br> <abbr title="Teléfono">Tlf:</abbr>
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

					$("#modal-container-movie").on(
							'hidden.bs.modal',
							function(e) {
								$(this).find("input,textarea,select").val('').end();
								
								$('#errorMessageTitle').removeClass("hidden");
								$('#errorMessageUrl').removeClass("hidden");
								$('#errorMessageDescription').removeClass("hidden");
								$('#errorMessageYear').removeClass("hidden");
								$('#errorMessageDirector').removeClass("hidden");
								$('#errorMessageCast').removeClass("hidden");
								$('#errorMessageFront').removeClass("hidden");
								$('#errorMessageRating').removeClass("hidden");
								
								/* $('#errorMessagePassword').text("* Campo obligatorio");
								$('#errorMessageEmail').text("* Campo obligatorio") */
							});

					$("#modal-container-update-movie").on(
							'hidden.bs.modal',
							function(e) {
								$(this).find("input,textarea,select").val('').end();
							});

					
					$('#inputTitle').on('input', function() {
						var input = $(this);
						var is_title = input.val();
						
						var error = $('#errorMessageTitle');
						if(is_title){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputUrl').on('input', function() {
						var input = $(this);
						var url = input.val();
						
						var error = $('#errorMessageUrl');
						
						var exists = true;
						//urlExists(url, function(exists){
							if(exists){
								error.addClass("hidden");
							}
							else{
								error.removeClass("hidden");
							}
						//});
						
					});
					
					$('#inputDescription').on('input', function() {
						var input = $(this);
						var is_desc = input.val();
						
						var error = $('#errorMessageDescription');
						if(is_desc){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputYear').on('input', function() {
						var input = $(this);
						var year = input.val();				
						
						var error = $('#errorMessageYear');
						if($.isNumeric(year)){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputDirector').on('input', function() {
						var input = $(this);
						var is_dir = input.val();
						
						var error = $('#errorMessageDirector');
						if(is_dir){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputCast').on('input', function() {
						var input = $(this);
						var is_cast = input.val();
						
						var error = $('#errorMessageCast');
						if(is_cast){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputFront').on('input', function() {
						var input = $(this);
						var url = input.val();
						
						var error = $('#errorMessageFront');
						
						var exists = true;
						//urlExists(url, function(exists){
							if(exists){
								error.addClass("hidden");
							}
							else{
								error.removeClass("hidden");
							}
						//});
						
					});
					
					$('#inputRating').on('input', function() {
						var input = $(this);
						var rate = input.val();				
						
						var error = $('#errorMessageRating');
						if($.isNumeric(rate)){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					
					$('#inputTitle2').on('input', function() {
						var input = $(this);
						var is_title = input.val();
						
						var error = $('#errorMessageTitle2');
						if(is_title){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputUrl2').on('input', function() {
						var input = $(this);
						var url = input.val();
						
						var error = $('#errorMessageUrl2');
						
						var exists = true;
						//urlExists(url, function(exists){
							if(exists){
								error.addClass("hidden");
							}
							else{
								error.removeClass("hidden");
							}
						//});
						
					});
					
					$('#inputDescription2').on('input', function() {
						var input = $(this);
						var is_desc = input.val();
						
						var error = $('#errorMessageDescription2');
						if(is_desc){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputYear2').on('input', function() {
						var input = $(this);
						var year = input.val();				
						
						var error = $('#errorMessageYear2');
						if($.isNumeric(year)){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputDirector2').on('input', function() {
						var input = $(this);
						var is_dir = input.val();
						
						var error = $('#errorMessageDirector2');
						if(is_dir){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputCast2').on('input', function() {
						var input = $(this);
						var is_cast = input.val();
						
						var error = $('#errorMessageCast2');
						if(is_cast){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#inputFront2').on('input', function() {
						var input = $(this);
						var url = input.val();
						
						var error = $('#errorMessageFront2');
						
						var exists = true;
						//urlExists(url, function(exists){
							if(exists){
								error.addClass("hidden");
							}
							else{
								error.removeClass("hidden");
							}
						//});
						
					});
					
					$('#inputRating2').on('input', function() {
						var input = $(this);
						var rate = input.val();				
						
						var error = $('#errorMessageRating2');
						if($.isNumeric(rate)){
							error.addClass("hidden");
						}
						else{
							error.removeClass("hidden");
						}
					});
					
					$('#moviesTable').dataTable( {
						"language":{
							"lengthMenu":"Mostrar _MENU_ registros por página.",
						       "zeroRecords": "No se han encontrado registros.",
				             "info": "Mostrando página _PAGE_ de _PAGES_",
				             "infoEmpty": "No hay registros aún.",
				             "infoFiltered": "(filtrados de un total de _MAX_ registros)",
				             "search" : "Búsqueda",
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
						    { "name": "Título", "targets": 1 },
						    { "name": "URL", "targets": 2 },
						    { "name": "Descripción", "targets": 3 },
						    { "name": "Año", "targets": 4 },
						    { "name": "Director", "targets": 5 },
						    { "name": "Reparto", "targets": 6 },
						    { "name": "Imagen", "targets": 7 },
						    { "name": "Puntuación", "targets": 8 }
						  ]
						
			        } );
					
							
				});
	</script>
</body>
</html>