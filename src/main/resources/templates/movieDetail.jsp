<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Video Store. Detalle de película</title>

<meta name="description" content="Welcome home!">
<meta name="author" content="Álvaro Fernández">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

/* Add a hover effect if you want */
.fa:hover {
	opacity: 0.7;
}

.blockquote {
	border-left: 5px solid #212121;
}
</style>

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
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
							<li class="active"><a href="Movies">Películas</a></li>
							<li><a href="MoviesManagement">Gestión de Películas</a></li>
						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input class="form-control" type="text">
							</div>
							<button type="submit" class="btn btn-default">Buscar</button>
						</form>

					</div>

				</nav>

			</div>
		</div>

		<div class="row qt">
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-12">
						<img alt="Bootstrap Image Preview" class="img-rounded"
							src="http://lorempixel.com/300/350/">
					</div>
				</div>

			</div>
			<div class="col-md-7">
				<label id="movieTitle" class="movie-title">Pulp Fiction</label>
				<dl>
					<dt>Duración</dt>
					<dd id="movieDuration">180 min</dd>
					<dt>Año</dt>
					<dd id="movieYear">1994</dd>
					<dt>Sinopsis</dt>
					<dd id="movieSinopsis">Vestibulum id ligula porta felis
						euismod semper eget lacinia odio sem nec elit.</dd>
					<dt>Director</dt>
					<dd id="movieDirector">Quentin Tarantino</dd>
					<dt>Reparto</dt>
					<dd id="movieStarring">John Travolta, Uma Thurman, Samuel L.Jackson, Bruce Willis</dd>
				</dl>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">

				<button type="button" class="btn btn-lg btn-danger btn-block"
					onClick="watchMovie();">Ver película</button>
			</div>
			<div class="col-md-4"></div>
		</div>


		<div class="row dark qt">
			<div class="col-md-4">

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
	<script type="text/javascript">
	$(document).ready(function() {
		console.log("ready!");
		
		
		// TODO Ajax getting movie details
		setMovieDetails();
		
	});
</script>
</body>
</html>