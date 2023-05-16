# a) ¿Qué son las pruebas efectivas y sistemáticas?

Las pruebas efectivas y sistemáticas se basan en un enfoque estructurado y metódico para probar software. A diferencia de centrarse únicamente en las herramientas de prueba y las mejores prácticas de codificación, se enfocan en el diseño y la creación sistemática de casos de prueba.

En lugar de depender del instinto o la intuición del ingeniero de pruebas, se siguen pasos claros y definidos para generar los casos de prueba. Esto implica comprender los requisitos del programa o método que se está probando, descomponerlos en entradas y salidas esperadas, explorar diferentes combinaciones de entradas y salidas, y crear pruebas que abarquen de manera adecuada estos aspectos.

Además, las pruebas efectivas y sistemáticas también consideran la cobertura de código y las pruebas estructurales. Se busca identificar las áreas del código que no están siendo cubiertas por las pruebas y tomar medidas para solucionar esas brechas.

El objetivo final de las pruebas efectivas y sistemáticas es desarrollar un conjunto sólido de pruebas que capturen los errores relevantes y significativos, al mismo tiempo que se omitan pruebas innecesarias o que no aporten valor. Siguiendo los pasos y técnicas recomendadas, se espera lograr un conjunto de pruebas lo suficientemente sólido como para equipararse al de un ingeniero de pruebas experimentado.

# b) Pruebas (2 puntos)

(a) Comienza a implementar una estrategia de prueba sistemática para esta función
escribiendo una buena partición del espacio de entrada solo en el límite de entrada, es
decir, la partición no debe mencionar ni el texto ni el delimitador.

Caso 1: límite < 0 (Para manejar el caso sin límite.)

Caso 2: límite = 0 (Para manejar el caso inválido.)

Caso 3: límite > 0 (Para manejar un caso estándar.)

(b) Ahora, escriba una buena partición del espacio de entrada sobre la relación entre el
límite y las ocurrencias del delimitador en el texto. Tu partición debe mencionar las tres
entradas.

Caso 1: delimitador no está incluido en texto, limite != 0

Caso 2: limite > 0 y hay más de limite-1 ocurrencias de delimitador en el texto

Caso 3: límite = 0

Caso 4: limite < 0 y hay una cantidad menor o igual a limite-1 ocurrencias de delimitador en el texto

# c) Refactorización avanzada (3 puntos)

No hay código para 'DataStats' necesario para la pregunta

