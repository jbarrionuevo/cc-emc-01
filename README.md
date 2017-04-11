EMC Call Center
===============

# Consideraciones

### Diseño
Ver diagramas de clases y de secuenci adjuntos.
### Explicación de los puntos adicionales
1. Dar alguna solución sobre qué pasa con una llamada cuando no hay ningún empleado libre.

Cuando no hay ningún empleado libre, se intenta asignar la llamada hasta que el empleado se libera.
Ver test NoAvailableEmployeeScenarioTest (se reiteran los intentos hasta que todas las llamadas son atendidas).

2. Dar alguna solución sobre qué pasa con una llamada cuando entran más de 10 llamadas concurrentes:

Cuando entran mas de 10 llamadas (hasta cierto numero, ver *2.1) estas seran puestas en una cola de espera hasta que se libere una llamada en curso.Esto lo resuelve el java.util.concurrent.Executors.ExecutorService. Este va a poner en una cola de espera las llamadas nuevas (tasks o runnables), hasta que un thread termine de ejecutar una tarea y se libere un slot del pool. Entonces se ejecuta la primer tarea en la queue y se utiliza en thead disponible (y asi con el resto).

(*2.1) Si la cantidad de llamadas en espera supera el tamaño del queue del ExecutroService el comportamiento será diferente (se aceptan mas llamadas que las soportadas por el pool hasta llegar al maximo), y será necesaria una solución diferente a la presentada.


### Otras consideraciones
1. El código del EmployeeController puede ser mejorado usando streams. (ejemplo en clase EmployeeController, metodo getEmployeesByStatus())
2. Los tests unitarios pueden mejorarse, reduciendo el código duplicado y en algunos casos agregando mas asserts (en lugar de solo hacer llamadas).
3. La aplicación se ejecuta desde el main method del MainController. Se simula un pool de 2 llamadas.
4. Las 10 llamadas se simulan en el test runTenCalls en CallCenterTest.
5. Los diagramas de diseño UML se encuentran en el folder del proyecto llamado "configuration". 
6. El build de la presente version no presenta errores. Ver detalle:

```	
	Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
	[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ call-center-emc ---
	[INFO] Building jar: /Users/Jorge/Developer/dlp/call-center-emc/target/call-center-emc-0.0.1-SNAPSHOT.jar
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 52.131 s
```

### Inicialización

```
$ git clone https://github.com/jbarrionuevo/cc-emc-01.git
$ mvn clean package

```

### Info util

#### Urls

```
Repositorio https://github.com/jbarrionuevo/cc-emc-01.git
```

Consigna

Descripción

Existe un call center donde hay 3 tipos de empleados: operador,
supervisor y director. El proceso de la atención de una llamada
telefónica en primera instancia debe ser atendida por un operador, si
no hay ninguno libre debe ser atendida por un supervisor, y de no
haber tampoco supervisores libres debe ser atendida por un director.

Requerimientos

1. Diseñar el modelado de clases y diagramas UML necesarios
para documentar y comunicar el diseño.
2. Debe existir una clase Dispatcher encargada de manejar las
llamadas, y debe contener el método dispatchCall para que las
asigne a los empleados disponibles.
3. La clase Dispatcher debe tener la capacidad de poder procesar
10 llamadas al mismo tiempo (de modo concurrente).
4. Cada llamada puede durar un tiempo aleatorio entre 5 y 10
segundos.
5. Debe tener un test unitario donde lleguen 10 llamadas.

Extras/Plus

1. Dar alguna solución sobre qué pasa con una llamada cuando no
hay ningún empleado libre.
2. Dar alguna solución sobre qué pasa con una llamada cuando
entran más de 10 llamadas concurrentes.
3. Agregar los tests unitarios que se crean convenientes.
4. Agregar documentación de código.

Tener en Cuenta

1. El proyecto debe ser creado con Maven.
2. De ser necesario, anexar un documento con la explicación del
cómo y porqué resolvió los puntos extras, o comentarlo en las
clases donde se encuentran sus tests unitarios respectivos.