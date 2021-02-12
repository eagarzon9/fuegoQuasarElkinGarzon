# FUEGO DE QUASAR
Prueba de ingreso (Challenge) para proceso de selección de Mercado Libre

# INTRODUCCIÓN

Este es un proyecto más que para una prueba de ingreso, una motivación para aprender y encaminarme en las nuevas tecnologías; Fuego de Quasar es una aplicación de análisis e interpretación de requerimientos, que implica la construcción o desarrollo servicios REST con la finalidad de tener la emisión de tres satélites (kenobi, skywalker y sato)  obteniendo la posición y el mensaje.

# ARQUITECTURA

Se utiliza un proyecto Maven con Spring-Boot sobre Java 11 separado por capas bajo dominio (Domain Driven Design) que incluye capa Entities, ValueObjects y services y una base de datos en POSTGRES 

# DEPENDENCIAS IMPLEMENTADAS
-	Java Spring Boot
-	Maven
-	Jpa
-	Trilateration
-	JUnit Test
-	POSTGRES
-	Swagger
-	Postman

# DESPLIEGUE
El api se encuentra desplegado en un contenedor de Google Cloud app engine, con la configuración básica free.

# EJECUCIÓN

| EJECUCIÓN | URL|
| ----------| ------ |
| PostMan | [https://www.getpostman.com/collections/94ce4e18ea123b324c18] |
| Swagger | [https://quasarapi-304612.rj.r.appspot.com/swagger-ui.html] |
| /topsecret/ | [https://quasarapi-304612.rj.r.appspot.com/topsecret/] |
| /topsecret_split/ | [https://quasarapi-304612.rj.r.appspot.com/topsecret_split/] |
| /topsecret_split/name | [https://quasarapi-304612.rj.r.appspot.com/topsecret_split/name]|

# Pruebas

Las pruebas se realizaron con Junit Test para casos prácticos de ejecución o también puedes usar la colección Postman  expuesta anteriormente y realizar las diferentes pruebas
