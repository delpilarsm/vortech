# API Peliculas - Vortech

`peliculas` Esta API expone tres endpoints para guardar peliculas y consultarlas  o por detalle del titulo de pelicula.
* POST
 savePelicula  `/peliculas/add`
 {"titulo":"El principito","genero":"Infantil 10","anio":610,"oscar":2}

* GET
getPeliculas  `/peliculas/all`
getPeliculaByTitulo  `/peliculas/detalle?titulo=Alicia`


## Restaurar base de datos
 
* Restaurar base de datos: `peliculas` el dump se encuentra en la carpeta /peliculas  `peliculas_peliculas.sql`


## Para trabajar con API Vortech

Se requiere:

* MySQL 5
* Java 8
* Maven
* Sprint Boot

Con los siguientes comandos puedes descargar las dependencias y ejecutar las pruebas situados en /peliculas

* Limpiar el proyecto: `mvn clean`  situado en la carpeta /peliculas`
* Descargar dependencias : `mvn install`
* Ejecutar pruebas: `mvn test`

Nota:
El reporte de cobertura de codigo se genera en la ruta /target/site/jacoco/index.html


## Documentacion peliculas

  La Api escucha en el puerto 8081.
  
  Api Documentation al iniciar se encuentra en `http://localhost:8081/swagger-ui.html#/` 
  

