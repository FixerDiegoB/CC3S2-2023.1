## Curso de desarrollo de software

**Integrantes**

- Bayes Santos, Diego Edson
- Zuñiga Chicaña, Alejandra Aztirma

### Pruebas en sotware - parte1

Una prueba es un ejemplo de un proceso más general llamado validación. El propósito de la validación es descubrir problemas en un programa y, por lo tanto, aumentar tu confianza en la corrección del programa.  
Aquí hay algunos enfoques que desafortunadamente no funcionan bien en el mundo del software. 

- Las pruebas exhaustivas son inviables. 
- Es menos probable que las pruebas aleatorias 
- Las pruebas aleatorias o estadísticas no funcionan bien para el software.

**Ejercicio 1**

Aquí hay un método con errores:

``` 
/**
 * @param bits un arreglo de 32 valores true/false
 * @retorna el Boleano AND de todos los valores en el arreglo
 */
boolean andAll(boolean[] bits) {
  boolean result = bits[0];
  for (int i = 1; i < 31; i++) {
    result = result && bits[i];
  }
  return result;
}

``` 
Abejita, quien escribió este método y cree que debería funcionar, lo prueba en un par de casos de prueba elegidos al azar que se muestran a continuación. ¿Cuál es el resultado de cada caso de prueba? 

- `andAll([true, true, true, ..., true, true]) // 32 valores true` 
- `andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true ` 
- Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error? 
- ¿Cuál podría ser el número de casos de prueba requeridos para probar esta función exhaustivamente?

**Solución**
- `andAll([true, true, true, ..., true, true]) // 32 valores true`  
 El resultado para la primera prueba, el método en cuestión devolverá “true”. Esto se debe a que el operador AND lógico devuelve “true” cuando los valores que se están comparando son “true”. Al ser todos los valores en el arreglo (para este caso) son “true”, el resultado de la operación en todas sus iteraciones del bucle será “true”.

- `andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true `  
El resultado para el segundo caso de prueba, el método en cuestión devolverá “false”. Esto se debe a que el operador AND lógico devuelve “false” si al menos hay un valor “false” en el arreglo. Aunque los valores en el arreglo alternen entre “true” y “false” como se mencionó, basta un “false” para que el resultado sea “false”


- Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error?  
 La expresión que contiene el error off-by-one es la condición del bucle "for". La condición actual es "i < 31", lo que significa que el bucle se ejecutará para los valores de "i" de 1 a 30, pero no incluirá el último valor del arreglo. La condición correcta debería ser "i < 32". Esto garantizará que el bucle se ejecute para todos los valores del arreglo "bits", incluyendo el último valor.



**Ejercicio 2**

En la década de 1990, el vehículo de lanzamiento Ariane 5, diseñado y construido para la Agencia Espacial Europea, se autodestruyó 37 segundos después de su primer lanzamiento. El motivo fue un error del software de control que no se detectó. El software de guía del Ariane 5 se reutilizó del Ariane 4, que era un cohete más lento. Cuando el cálculo de la velocidad se convirtió de un número de coma flotante de 64 bits (el mismo que un número en TypeScript, aunque este software no se escribió en TypeScript) a un número entero con signo de 16 bits, desbordó el número entero pequeño y provocó una excepción. El controlador de excepciones se había deshabilitado por razones de eficiencia, por lo que el software de guía se bloqueó. Sin guía, el cohete también se estrelló. El costo de la falla fue de mil millones de dólares. 

 ¿Qué ideas demuestra esta historia? 

- Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales.
- Probar todas las entradas posibles es la mejor solución a este problema. 
- El software exhibe un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente. 
- La verificación de tipos estáticos podría haber detectado este error.

**Solución**

* Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales.  

 Esta historia muestra que incluso cuando se utiliza un software de alta calidad, el error humano y la falta de pruebas adecuadas pueden provocar errores “residuales” que tienen fatales consecuencias. Esto destaca la importancia de una verificación y pruebas rigurosas para garantizar la calidad y seguridad del software utilizado en aplicaciones críticas. 


### Pruebas sistemáticas 

En lugar de pruebas exhaustivas, o aleatorias, queremos probar de manera sistemática. 
Las pruebas sistemáticas significan que estamos eligiendo casos de prueba de una manera basada en principios, con el objetivo de diseñar un conjunto de pruebas con tres propiedades deseables: 

- Correcto
- Exhaustivo
- Pequeño

**Ejercicio 3**

Un conjunto de pruebas es correcto si: 

- Todos sus casos de prueba fallan cuando se ejecutan en una implementación con errores 
- Algún caso de prueba falla cuando se ejecuta en una implementación con errores
- Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal 
- algunos casos de prueba pasan cuando se ejecutan en una implementación legal 

**Solución**
* Algún caso de prueba falla cuando se ejecuta en una implementación con errores.  

 Un conjunto de pruebas es correcto si puede encontrar errores en el software. Para que esto suceda, el conjunto de pruebas debe tener al menos un caso de prueba que falle cuando se ejecute en una versión con errores del software. Si todas las pruebas pasan cuando se ejecutan en una versión del software sin errores, esto no garantiza que el software esté libre de ellos.


**Ejercicio 4**

Un conjunto de pruebas vacío no contiene casos de prueba. Suponiendo una especificación no trivial, un conjunto de pruebas vacío es: 

- Correcto 
- Exhaustivo 
- Pequeña

**Solución**

- La determinación de si un conjunto de pruebas vacío es correcto o no en una especificación no trivial depende de si existen requisitos funcionales que deban ser validados o no.  
- Un conjunto de pruebas vacío no es exhaustivo, ya que no se han realizado pruebas en ninguna de las funcionalidades del sistema.  
- Tampoco se puede decir que sea pequeño, ya que simplemente no existe un conjunto de pruebas.


### Elección de casos de prueba mediante partición

Dividimos el espacio de entrada en **subdominios**, cada uno de los cuales consta de un conjunto de entradas. En conjunto, los **subdominios** forman una **partición**: una colección de conjuntos disjuntos que cubre completamente el espacio de entrada, de modo que cada la entrada se encuentra exactamente en un subdominio. Luego elegimos un caso de prueba de cada subdominio, y ese es nuestro conjunto de pruebas. 


**Ejemplo: abs()**

``` 
/**
 * ...
 * @param a  el argumento cuyo valor absoluto es determinado 
 * @returna el valor absoluto del argumento.
 */
public static int abs(int a)
``` 
Matemáticamente, este método es una función del siguiente tipo: 

```
abs : int -->  int 

``` 
La función tiene un espacio de entrada unidimensional, que consta de todos los valores posibles de `a`. Podemos dividir el espacio de entrada en estos dos subdominios: `{a | a ≥ 0 }` y `{ a | a < 0 }`. 

```
// particion: a >= 0; a < 0

``` 
Para elegir casos de prueba elegimos un valor arbitrario `a` de cada subdominio de la partición, por ejemplo: 

- a = 17 para cubrir el subdominio a ≥ 0 
- a = -3 para cubrir el subdominio a < 0 

**Ejemplo: máx()** 

Ahora veamos otro ejemplo de la biblioteca de Java: la función integer max(), que también se encuentra en Math. 

```
/**
 * ...
 * @param a  un argumento
 * @param b  otro argumento
 * @retorna el mayor de a y b.
 */

public static int max(int a, int b)

```
Matemáticamente, este método es una función de dos argumentos: 

```
máx : int × int --> int 

```
La forma compacta, la partición se ve así:

```
// particion: a < b; a > b; a = b

```
El conjunto de pruebas podría ser: 


- (a,b) = (1, 2) para cubrir a < b 
- (a,b) = (10, -8) para cubrir a > b
- (a,b) = (9, 9) para cubrir a = b

**Ejercicios 5**

Supongamos que deseas dividir el espacio de entrada de esta función de raíz cuadrada:

```
/**
 * @param x debe ser no negativo
 * @retorna la raiz cuadrada de x
 */
public static int sqrt(int x)
```

Evalúe la calidad de cada una de las siguientes particiones candidatas. ¿Son los subdominios propuestos separados y completos, formando así una partición? ¿Son correctos, en el sentido de que cada subdominio puede ser cubierto por un caso de prueba legal? Para una buena partición debes marcar las tres alternativas.

```
// particion: x < 0; x >= 0
```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos


```
// particion: x es un cuadrado perfecto; x es > 0 pero no es un cuadrado perfecto

```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

```
// particion: x=0, x=1, x=7, x=16
``` 

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Solución**

```
// particion: x < 0; x >= 0
```
- Los subdominios son disjuntos, porque un número no puede positivo y negativo a la vez  
- Los subdominios están completos, porque cualquier número entero pertenece a uno de los subdominios.  
- Los subdominios no son correctos, ya que la especificación de la función establece que el parámetro "x" debe ser no negativo.

```
// particion: x es un cuadrado perfecto; x es > 0 pero no es un cuadrado perfecto
```
- Los subdominios son disjuntos, porque un número no puede ser a la vez un cuadrado perfecto y no serlo.  
- Los subdominios están completos, porque cualquier número entero pertenece a uno de los subdominios, considerando el parámetro de la función de que “x” es no negativo.  
- Los subdominios son correctos, porque los valores están incluidos dentro del dominio del problema.


```
// particion: x=0, x=1, x=7, x=16
``` 
- Los subdominios son disjuntos, porque subdominio es un valor específico de x, por lo que están claramente separados y no se superponen.  
- Los subdominios no están completos, porque existen valores de x que no están incluidos en ninguna de las cuatro opciones propuestas.  
- Los subdominios son correctos, porque los valores están incluidos dentro del dominio del problema.



**Ejercicio 6**

Ahora considera esta especificación:

```
/**
 * @param x un entero 
 * @param y un entero, donde x, y no son ambos 0
 * @retorna el GCD de x e y
 */
/
public static int gcd(int x, int y);
```

Evalúa cada una de las siguientes particiones candidatas para gcd.

```
// particion: x e y no son  0
``` 

- Al solo haber un subdominio, la partición se considera disjunta.
- El subdominio no es completo porque no incluye los casos en los que uno de los parámetros es 0 y el otro no.
- El subdominio es correcto pues se encuentra dentro de los valores válidos.

```
// particion: x es divisible por y; y es divisible por x; x e y son primeros relativos
```
`
- Los subdominios no son disjuntos cuando 'x' es igual a 'y', ya que 'y' sería divisible por 'x' y viceversa.
- Los subdominios están completos porque abarcan todas las posibilidades.
- Los subdominios son correctos porque todos cumplen con la condición que ambos no sean 0.

### Incluir límites en la partición 

Los errores a menudo ocurren en los límites entre los subdominios. Algunos ejemplos: 

- `0` es un límite entre números positivos y números negativos 
- Los valores máximo y mínimo de tipos numéricos, como `int` o `double` 
- El vacío para tipos de colección, como la cadena vacía, la lista vacía o el conjunto vacío el primer 
- El último elemento de una secuencia, como una cadena o lista

La función `abs()` en Java se comporta de una manera muy inesperada en uno de estos límites, que la especificación describe de la siguiente manera:

```
/**
 *
 * Ten en cuenta que si el argumento es igual al valor de Integer.MIN_VALUE, 
 * el valor int representable más negativo, el resultado es el mismo valor
 * negativo.
 * ...
 */

``` 

Incorporamos límites como subdominios de un solo elemento en la partición, de modo que el conjunto de pruebas incluya necesariamente el valor del límite como un caso de prueba. Para abs, agregaremos subdominios para cada uno de los límites relevantes: 

- `a = 0`, porque `abs` se comporta de manera diferente en números positivos y negativos
- `a = Integer.MIN_VALUE`, el valor int más negativo posible, porque la especificación indica un comportamiento inusual - 
- `a = Integer.MAX_VALUE`, el mayor valor int positivo, para simetría y completitud

Los dos subdominios originales se reducirían para excluir los valores límite: `{ a | 0 < a < Integer.MAX_VALUE }` y `{ a | Integer.MIN_VALUE < a < 0 }`. 

Esta es ahora una partición del espacio de entrada de `abs`: los cinco subdominios están separados y cubren completamente el espacio. 

```
// particion:
//     a = Integer.MIN_VALUE
//     Integer.MIN_VALUE < a < 0
//     a = 0
//     0 < a < Integer.MAX_VALUE
//     a = Integer.MAX_VALUE

```
El conjunto de pruebas podría ser: 

```
a = 0 
a = Integer.MIN_VALUE 
a = Integer.MAX_VALUE 
a = 17 para cubrir el subdominio 0 < a < Integer.MAX_VALUE 
a = -3 para cubrir el subdominio Integer.MIN_VALUE < a < 0 
```
**Ejercicio 7**

Para esta función: 

```
/**`
 * @param winsAndLosses una cadena de a lo más 5 de consistiendo de los caracteres 'W' o 'L'
 * @retorna la fraccion de caracteres en winsAndLosses que son 'W'
 */

double winLossRatio(String winsAndLosses);
```
¿Cuáles son los valores límite apropiados para probar esta función?

Los valores límites apropiados incluyen:
- La cadena vacía: ""
- El caso de las 5 victorias: "WWWWW"
- El caso de las 5 derrotas: "LLLLL"

### Uso de varias particiones 

Un enfoque es tratar las características de cada entrada `a` y `b` como dos particiones separadas del espacio de entrada. Una partición solo considera el valor de `a`: 

`(a,b)` tal que `a = 0, 1`, pequeño positivo, pequeño negativo, grande positivo, grande negativo 

Y la otra partición solo considera el valor de `b`:

`(a,b)` tal que `b = 0, 1`, pequeño positivo, pequeño negativo, grande positivo, grande negativo 


Cada par de entradas `(a,b)` pertenece exactamente a un subdominio de cada partición. Podríamos escribir las dos particiones de forma compacta de la siguiente manera:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
//           
// particion en b:
//      b = 0
//      b = 1
//      b es un entero pequeño > 1
//      b es un entero pequeño < 0
//      b es un entero grande positivo
//      b es un entero grande negativo

```

Particionar `a` y `b` de forma independiente aumenta el riesgo de que ya no esté probando la interacción entre ellos.

```
// particion de signos de a y b:
//    a y b son ambos positivos
//    a y b son ambos negativos
//    a positivo y b negativo
//    a negativo y b positivo
//    uno o ambos son 0

```

Un conjunto de pruebas con 6 casos de prueba cuidadosamente elegidos puede cubrir los subdominios de las tres particiones. 


**Ejercicio 8**

Considera la partición de `a` anterior:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición en realidad combina varios intereses distintos: el signo de `a`, la magnitud de `a` (pequeño o grande) y los valores límite 0 y 1. Podemos pensar en estos intereses como particiones independientes.
De entre las opciones a continuación, elija un subconjunto que serían particiones legales y que juntas captarían los mismos intereses.

- particion en a: `0, 1`
- particion en a: `0`
- particion en a: `1`
- particion en a: `0`, positivo, negativo
- particion en a: positivo, negativo
- particion en a: `1, !=1`
- particion en a: (donde "pequeño" encaja en long y "grande" no)

Las opciones que cumplen con las 3 condiciones serían:
- particion en a: `0`, positivo, negativo
- particion en a: `1, !=1`
- particion en a: (donde "pequeño" encaja en long y "grande" no)

**Ejercicio 9**

Considera nuevamente esta partición `a` en un desde arriba:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición tiene 6 subdominios, por lo que pueden cubrirla 6 valores diferentes de `a`, uno elegido para cada subdominio. 

Supongamos que usamos estas tres particiones de a en su lugar:

```
// particion en a: 0, positivo, negativo
// particion en a: 1, !=1
// particion on a: donde "pequeño" encaja en long y "grande" no)
```

Si solo queremos cubrir cada subdominio de las tres particiones, ¿cuántos valores diferentes de a necesitaríamos?.

Se necesitarían 4 valores. Por ejemplo, el 0, el 1, un entero pequeño positivo diferente de 1 y un entero negativo grande.

**Ejercicio 10**

A veces es conveniente pensar y escribir una partición de espacio de entrada en términos de la salida de la función, porque las variaciones en el comportamiento pueden ser más visibles allí. Por ejemplo: 

```
// particion en a.multiply(b): 0, positivo, negativo

```
es la abreviatura de la partición de tres subdominios que consta de:

```
 { (a,b) | a.multiply(b) = 0 }
 { (a,b) | a.multiply(b) > 0 }
 { (a,b) | a.multiply(b) < 0 }

```
Con este enfoque, ¿cuántos casos de prueba se necesitan para cubrir las siguientes tres particiones? 

```
// particion en a: 0, positivo, negativo
// particion en b: 0, positive, negativo
// particion en a.multiply(b): 0, positivo, negativo
````
Bastaría con los 7 casos de prueba para abarcar las particiones:
- a = 0, b != 0
- a != 0, b = 0
- a > 0, b > 0
- a < 0, b > 0
- a > 0, b < 0
- a < 0, b < 0

### Cobertura

Una forma de juzgar un conjunto de pruebas es preguntar cuán minuciosamente ejercita el programa. Esta noción se llama **cobertura**. Aquí hay tres tipos comunes de cobertura: 

* Cobertura de declaraciones: ¿cada declaración se ejecuta en algún caso de prueba?
* Cobertura de rama: para cada instrucción if o while en el programa, ¿se toman tanto la dirección verdadera como la falsa en algún caso de prueba? 
* Cobertura de ruta: ¿todas las posibles combinaciones de ramas, todas las rutas a través del programa, son tomadas por algún caso de prueba? 

 En la industria, la cobertura del 100% de las declaraciones es un objetivo común, pero incluso eso rara vez se logra debido al código defensivo 
 inalcanzable (como las aserciones de "nunca debería llegar aquí"). 



