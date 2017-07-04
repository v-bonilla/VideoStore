#DAW's project#
Developed on 2017 by:
 - Víctor Bonilla
 - Álvaro Fernández

##Uso de la aplicación:##
  Nota: leer README.txt del directorio vagrant antes de desplegar la aplicacion.
  
  La aplicación se desplegará en http://192.168.100.200:8080/
 
  Para el primer inicio de sesion se debe usar el usuario "admin" con contraseña "admin".
  
  La aplicacion dispone de las siguientes peliculas tras iniciar:
  - Interstellar
  - Deadpool
  - Regreso al futuro II
  
  Si se quiere usar la barra de busqueda se debe introducir el titulo exacto de la pelicula a buscar.
  
  Si se quiere modificar un usuario o pelicula los unicos campos obligatorios son el ID y Administrador en el caso de usuario,
  los campos que no se rellenen no se modificaran.
  
  Al añadir una pelicula, el campo URL debe ser un enlace a un video de YouTube cuyo path relativo comience por "embed"
  (es el enlace disponible en el atributo src mostrado cuando se pincha en compartir video -> insertar).
  
  La opcion de administracion en la barra de navegacion solo aparece cuando el usuario tiene el rol de administrador.