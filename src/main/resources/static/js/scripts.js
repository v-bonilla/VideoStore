/*
 *@param {string} email - user email direction
 *@param {string} password - user password
 * */
function login(email, password) {
	var email = $('#inputEmail').val();
	var password = $('#inputPassword').val();

	// var loginData = {
	// "email": email,
	// "password": password
	// }

	// TODO AJAX
	// $.ajax({
	// type: "GET",
	// url: "login",
	// data: loginData,
	// success: function (result) {
	// alert('Login OK');
	// },
	// error: function (result) {
	// alert('Error en la conexion con el servidor');
	// }
	// });
	var url = "Home";
	window.location.replace(url);
}

/*------------------------USERS FUNCTIONS------------------------*/

function saveUser() {
	var name = $("#inputName").val();
	//var lastname = $("#inputLastname").val();
	var email = $("#inputEmail").val();
	var pass = $("#inputPassword").val();
	var repeat = $("#inputRepeatPassword").val();

	if (name != null /*&& lastname != null*/ && email != null && pass != null
			&& repeat != null) {

		var nameOk = $('#errorMessageName').hasClass('hidden');
		//var lastnameOk = $('#errorMessageLastname').hasClass('hidden');
		var emailOk = $('#errorMessageEmail').hasClass('hidden');
		var passOk = $('#errorMessagePassword').hasClass('hidden');
		var repeatPassOk = $('#errorMessageRepeatPassword').hasClass('hidden');

		if (nameOk /*&& lastnameOk*/ && emailOk && passOk && repeatPassOk) {

			if (pass == repeat) {

				var table = $('#usersTable').DataTable();
				var size = table.column(0).data().length;

				var now = getCurrentDate();

				var td = "<td>"
						+ "<a href='#'> "
						+ "<span class='material-icons' onClick='modalUpdateUser("
						+ size
						+ ");'>search</span>"
						+ "</a>"
						+ "<a href='#'> "
						+ "<span class='material-icons'onClick='modalDeleteUser("
						+ size + ");'>" + "delete</span>" + "</a>" + "</td>";
				// var tdId = "<td style='display: none;'>"+count+"</td>";

				
				//TODO AJAX
				// $.ajax({
				// type: "GET",
				// url: "PostUser",
				// data: user,
				// success: function (result) {
				// 	
				// },
				// error: function (result) {
				// alert('Error en la conexion con el servidor');
				// }
				// });
				var rowNode = table.row.add([ td, name, /*lastname,*/ email]).draw().node();

				$(rowNode).attr('id', size);

				// TODO Insertar en la BD - Añadir contraseña

				if ($(rowNode).hasClass('even')) {
					$(rowNode).addClass('active');
				}

				$("#modal-container-user").modal('toggle');

			} else {

				$('#errorMessagePassword').removeClass('hidden').text(
						"* Las contraseñas no coinciden");

			}
		}

	}
}

function modalUpdateUser(id) {
	$('#errorMessagePassword2').text("* Campo obligatorio");
	$('#errorMessageEmail2').text("* Campo obligatorio");

	$('#buttonUpdateUser').off('click').click(function() {
		updateUser(id);
	});

	var table = $('#usersTable').DataTable();
	var row = table.row('#' + id);

	var name = table.cell(row, 1).data();
	//var lastname = table.cell(row, 2).data();
	var email = table.cell(row, 2).data();

	$("#inputName2").val(name);
	//$("#inputLastname2").val(lastname);
	$("#inputEmail2").val(email);

	$("#modal-container-update-user").modal();

}

function updateUser(id) {
	var name = $("#inputName2").val();
	//var lastname = $("#inputLastname2").val();
	var email = $("#inputEmail2").val();
	var pass = $("#inputPassword2").val();
	var repeat = $("#inputRepeatPassword2").val();

	if (name != null /*&& lastname != null*/ && email != null && pass != null
			&& repeat != null) {

		var nameOk = $('#errorMessageName2').hasClass('hidden');
		//var lastnameOk = $('#errorMessageLastname2').hasClass('hidden');
		var emailOk = $('#errorMessageEmail2').hasClass('hidden');
		var passOk = $('#errorMessagePassword2').hasClass('hidden');
		var repeatPassOk = $('#errorMessageRepeatPassword2').hasClass('hidden');

		if (nameOk /*&& lastnameOk*/ && emailOk && passOk && repeatPassOk) {

			if (pass == repeat) {
				var table = $('#usersTable').DataTable();
				var row = table.row('#' + id);

				// TODO Actualizar en la BD

				table.cell(row, 1).data(name).draw();
				//table.cell(row, 2).data(lastname).draw();
				table.cell(row, 2).data(email).draw();

				$("#modal-container-update-user").modal('toggle');
			} else {
				$('#errorMessagePassword2').removeClass('hidden').text(
						"* Las contraseñas no coinciden");

			}
		}
	}
}

function modalDeleteUser(id) {
	$('#buttonDeleteUser').off('click').click(function() {
		deleteUser(id);
	});
	$("#modal-container-delete-user").modal();
}

function deleteUser(id) {
	var table = $('#usersTable').DataTable();
	var row = table.row('#' + id);

	// TODO borrar de la BD

	row.remove().draw();
	$("#modal-container-delete-user").modal('toggle');
}

function validateEmail(email) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}
/*----------------------END USERS FUNCTIONS----------------------*/

function getCurrentDate() {
	var date = new Date();
	var month = date.getMonth() + 1;
	var day = date.getDate();

	var output = (day < 10 ? '0' : '') + day + '/' + (month < 10 ? '0' : '')
			+ month + '/' + date.getFullYear();

	return output;
}

/*----------------------MOVIES FUNCTIONS----------------------*/
function getMovies() {

	// TODO Ajax

	var moviesList = new Array(); // get from ajax

	// for (movie in moviesList) {
	// addMovie(movie);
	// }

	for (var i = 0; i < 12; i++) {
		addMovie();
	}
}

function addMovie() {
	var movie = "<div class='col-md-2 row-top-padding'>"
			+ "<img alt='Bootstrap Image Preview' src='http://lorempixel.com/200/250/' "
			+ "class='img-rounded' onClick='window.location.replace(\"MovieDetail\");'> "
			+ "<span class='label label-danger image-label'>Nombre de ejemplo 1</span></div>";

	$('#divImages').append(movie);
}

function urlExists(url, callback) {
	$.ajax({
		type : 'HEAD',
		url : url,
		success : function() {
			callback(true);
		},
		error : function() {
			callback(false);
		}
	});
}

/*--------------------MOVIES FUNCTIONS END--------------------*/

/*----------------------MOVIE DETAIL FUNCTIONS---------------------*/

function setMovieDetails() {
	// TODO get details from DB

	/*$('#movieTitle').text('');
	$('#movieDuration').text('');
	$('#movieSinopsis').text('');
	$('#movieStarring').text('');
	$('#movieDirector').text('');
	$('#movieYear').text('');*/
}
function watchMovie() {
	// TODO set URL to Youtube link to movie trailer
	var win = window.open('http://youtube.com/', 'movie');
}

/*-------------------MOVIE DETAIL FUNCTIONS END-------------------*/

/*----------------------MOVIE MANAGEMENT FUNCTIONS---------------------*/

function saveMovie() {
	var title = $("#inputTitle").val();
	var url = $("#inputUrl").val();
	var description = $("#inputDescription").val();
	var year = $("#inputYear").val();
	var director = $("#inputDirector").val();
	var cast = $("#inputCast").val();
	var front = $("#inputFront").val();
	var rating = $("#inputRating").val();

	if (title != null && url != null && description != null && year != null
			&& director != null && cast != null && front != null
			&& rating != null) {

		var titleOk = $('#errorMessageTitle').hasClass('hidden');
		var urlOk = $('#errorMessageUrl').hasClass('hidden');
		var descOk = $('#errorMessageDescription').hasClass('hidden');
		var yearOk = $('#errorMessageYear').hasClass('hidden');
		var directorOk = $('#errorMessageDirector').hasClass('hidden');
		var castOk = $('#errorMessageCast').hasClass('hidden');
		var frontOk = $('#errorMessageFront').hasClass('hidden');
		var ratingOk = $('#errorMessageRating').hasClass('hidden');

		if (titleOk && urlOk && descOk && yearOk && directorOk && castOk
				&& frontOk && ratingOk) {

			var table = $('#moviesTable').DataTable();
			var size = table.column(0).data().length;

			var td = "<td>" + "<a href='#'> "
					+ "<span class='material-icons' onClick='modalUpdateMovie("
					+ size + ");'>search</span>" + "</a>" + "<a href='#'> "
					+ "<span class='material-icons'onClick='modalDeleteMovie("
					+ size + ");'>" + "delete</span>" + "</a>" + "</td>";

			var rowNode = table.row.add(
					[ td, title, url, description, year, director, cast, front, rating])
					.draw().node();

			$(rowNode).attr('id', size);

			// TODO Insertar en la BD

			if ($(rowNode).hasClass('even')) {
				$(rowNode).addClass('active');
			}

			$("#modal-container-movie").modal('toggle');

		}

	}
}

function modalUpdateMovie(id) {
	$('#buttonUpdateMovie').off('click').click(function() {
		updateMovie(id);
	});

	var table = $('#moviesTable').DataTable();
	var row = table.row('#' + id);

	var title = table.cell(row, 1).data();
	var url = table.cell(row, 2).data();
	var description = table.cell(row, 3).data();
	var year = table.cell(row, 4).data();
	var director = table.cell(row, 5).data();
	var cast = table.cell(row, 6).data();
	var front = table.cell(row, 7).data();
	var rating = table.cell(row, 8).data();

	$("#inputTitle2").val(title);
	$("#inputUrl2").val(url);
	$("#inputDescription2").val(description);
	$("#inputYear2").val(year);
	$("#inputDirector2").val(director);
	$("#inputCast2").val(cast);
	$("#inputFront2").val(front);
	$("#inputRating2").val(rating);

	$("#modal-container-update-movie").modal();

}

function updateMovie(id) {
	var title = $("#inputTitle2").val();
	var url = $("#inputUrl2").val();
	var description = $("#inputDescription2").val();
	var year = $("#inputYear2").val();
	var director = $("#inputDirector2").val();
	var cast = $("#inputCast2").val();
	var front = $("#inputFront2").val();
	var rating = $("#inputRating2").val();

	if (title != null && url != null && description != null && year != null
			&& director != null && cast != null && front != null
			&& rating != null) {

		var titleOk = $('#errorMessageTitle2').hasClass('hidden');
		var urlOk = $('#errorMessageUrl2').hasClass('hidden');
		var descOk = $('#errorMessageDescription2').hasClass('hidden');
		var yearOk = $('#errorMessageYear2').hasClass('hidden');
		var directorOk = $('#errorMessageDirector2').hasClass('hidden');
		var castOk = $('#errorMessageCast2').hasClass('hidden');
		var frontOk = $('#errorMessageFront2').hasClass('hidden');
		var ratingOk = $('#errorMessageRating2').hasClass('hidden');

		if (titleOk && urlOk && descOk && yearOk && directorOk && castOk
				&& frontOk && ratingOk) {
			
			var table = $('#moviesTable').DataTable();
			var row = table.row('#' + id);
			
			table.cell(row, 1).data(title).draw();
			table.cell(row, 2).data(url).draw();
			table.cell(row, 3).data(description).draw();
			table.cell(row, 4).data(year).draw();
			table.cell(row, 5).data(director).draw();
			table.cell(row, 6).data(cast).draw();
			table.cell(row, 7).data(front).draw();
			table.cell(row, 8).data(rating).draw();

			// TODO Update AJAX
			
			$("#modal-container-update-movie").modal('toggle');
		}

	}
}

function modalDeleteMovie(id) {
	$('#buttonDeleteMovie').off('click').click(function() {
		deleteMovie(id);
	});
	$("#modal-container-delete-movie").modal();
}

function deleteMovie(id) {
	var table = $('#moviesTable').DataTable();
	var row = table.row('#' + id);

	// TODO borrar de la BD

	row.remove().draw();
	$("#modal-container-delete-movie").modal('toggle');
}

/*--------------------MOVIE MANAGEMENT FUNCTIONS END-------------------*/

