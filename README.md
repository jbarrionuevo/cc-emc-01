EMC Call Center
===============

# Consideraciones

### Diseño

### Explicación de los puntos extra

### Otras consideraciones
1. Las llamadas a System.out se realizan para demostrar funcionalidad y porque la implementación de logging excede el alcance.  

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

###Consigna

####Descripción

Existe un call center donde hay 3 tipos de empleados: operador,
supervisor y director. El proceso de la atención de una llamada
telefónica en primera instancia debe ser atendida por un operador, si
no hay ninguno libre debe ser atendida por un supervisor, y de no
haber tampoco supervisores libres debe ser atendida por un director.

####Requerimientos

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

####Extras/Plus

1. Dar alguna solución sobre qué pasa con una llamada cuando no
hay ningún empleado libre.
2. Dar alguna solución sobre qué pasa con una llamada cuando
entran más de 10 llamadas concurrentes.
3. Agregar los tests unitarios que se crean convenientes.
4. Agregar documentación de código.

####Tener en Cuenta

1. El proyecto debe ser creado con Maven.
2. De ser necesario, anexar un documento con la explicación del
cómo y porqué resolvió los puntos extras, o comentarlo en las
clases donde se encuentran sus tests unitarios respectivos.