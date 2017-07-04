Configuración del despligue:
Se han usado dos scripts de provisionamiento: webProvision.sh para la aplicacion spring y dbProvision.sh para la bbdd MySQL.
Para un correcto despliegue junto al Vagrantfile deben estar los dos scripts de provisionamiento, un tercer script
 usado por la VM de la app web (para arrancar la app durante el arranque de la VM) y un directorio data con
 el jar de la web app y el tercer script.
La máquina virtual empleada es la proporcionada en clase: atorre/daw.
El provisionamiento de las maquinas tarda unos minutos puesto que tiene que descargar e intalar el cliente de MySQL
 y por otro lado el JDK de Java, con todas sus dependencias.
La aplicación se iniciará automáticamente.
Antes de iniciar el despliegue se recomienda empaquetar de nuevo el jar (mvn package) y copiarlo a la carpeta data

Uso de la aplicación:
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
