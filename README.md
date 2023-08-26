# appPruebaSymplifica

## despliegue

Este proyecto esta hecho con Spring Boot y es de tipo Maven. Para correrlo se recomienda descargar Spring Tools 4 for Eclipse (https://spring.io/tools) y abrir el proyecto desde allí.
import project -> existing maven projects allí selecionar carpeta del proyecto y finalizar.

en la clase AppPruebaAlianzaApplication (contiene el método main) click derecho -> Run As -> Spring Boot App para ejecutarlo. Esta clse se encuentra en la ruta com.steven.prueba.symplifica dentro de src/main/java


## detalles

como base de datos se escogio SQLite ya que es una DB embebida y así simplificar el despliegue. Esta DB esta en la raiz del proyecto con nombre database.sqlite. la tabla USERS la genera la aplicación automaticamente a partir de la entidad.

La app se despliega en el puerto 9090
