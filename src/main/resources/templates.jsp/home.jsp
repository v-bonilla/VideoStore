<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Video Store. Inicio</title>

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

/* Set a specific color for each brand */

/* Facebook */
/* .fa-facebook {
		    background: #3B5998;
		    color: white;
		} */

/* Twitter */
/* .fa-twitter {
		    background: #55ACEE;
		    color: white;
		} */
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
							<li class="active"><a href="Home">Inicio</a></li>
							<li><a href="Users">Usuarios</a></li>
							<li><a href="Movies">Películas</a></li>
							<li><a href="MoviesManagement">Gestión de Películas</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right margin-rigth">
							<li><a href="/videoclub">Logout</a></li>
							<li><a> </a></li>
						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input class="form-control" type="text">
							</div>
							<button type="submit" class="btn btn-default">Buscar</button>
						</form>

					</div>

				</nav>
				<div class="page-header qt">
					<h1>
						VideoStore <small>Play it and relax</small>
					</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="carousel slide" id="carousel-815037">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-815037"></li>
						<li data-slide-to="1" data-target="#carousel-815037"
							class="active"></li>
						<li data-slide-to="2" data-target="#carousel-815037"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item">
							<img alt="Carousel Bootstrap First"
								src="resources/images/wonderWoman.jpg">
							<div class="carousel-caption">
								<h4>Los últimos estrenos</h4>
								<p>Aquí podrás ver los últimos estrenos y anticipos de las
									nuevas películas de los próximos meses!!</p>
							</div>
						</div>
						<div class="item active">
							<img alt="Carousel Bootstrap Second"
								src="resources/images/dunkerque.jpg">
							<div class="carousel-caption">
								<h4></h4>
								<p></p>
							</div>
						</div>
						<div class="item">
							<img alt="Carousel Bootstrap Third"
								src="resources/images/spiderman.jpg">
							<div class="carousel-caption">
								<h4></h4>
								<p></p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-815037"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-815037"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>Video Streaming</h2>
					<p>VideoStore es una Aplicación Web que te permite ver una gran
						colección de películas. Ofrece un servicio rápido, contenido en
						alta calidad y los últimos estrenos. Esta plataforma nace de la
						necesidad de ofrecer a los usuarios el mejor cine sin tener que
						moverse del sofá. ¡Pulsa aquí abajo si quieres saber más sobre
						nosotros!</p>
					<p>
						<a class="btn btn-primary btn-large"
							href="https://www.google.es/search?q=Video+store&gws_rd=cr,ssl&ei=64c6WYTxAoT8aevTKg">Más</a>
					</p>
				</div>
			</div>
		</div>
		<div class="row dark">
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
</body>
</html>