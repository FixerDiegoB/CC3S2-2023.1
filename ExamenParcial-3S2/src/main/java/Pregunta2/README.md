### Requisito 1: Colocación de piezas

### Prueba: límites del tablero I

- Primera ejecución: La prueba falla porque el método 'jugar' no existe.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/c203646d-9be1-428e-83f1-6904ff306fea)\

- Segunda ejecución: La prueba falla porque no se lanza RuntimeException.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/6938f511-d982-45ee-8e2e-e7e1cac37a37)\

- Tercera ejecución: Prueba correctamente implementada.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/57b3ea63-8f80-48be-bef7-cffcfb127829)\

- Implementación:

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/ac1e89be-9e0a-45a6-b899-45fb35703546)\

### Prueba: límites del tablero II

- Primera ejecución: Dado que el método 'jugar' ya existe, esta ejecución se vuelve la primera. La prueba falla porque no se lanza RuntimeException.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/3892dd5a-66e7-48e1-a0f9-10e041754b46)\

- Segunda ejecución: Prueba correctamente implementada.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/90a76501-47b5-4473-8126-fca295afc39a)\

- Implementación:

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/435c9c3a-ea4f-46c1-9eaa-f9f40a9df6cc)\

### Prueba: Lugar ocupado

- Primera ejecución: Dado que el método 'jugar' ya existe, esta ejecución se vuelve la primera. La prueba falla porque no se lanza RuntimeException.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/25dd2ae9-1fdb-4316-b730-e63dccdbfbb6)\

- Segunda ejecución: Prueba correctamente implementada.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/ffe45dd6-6f47-4843-b483-ead600aa7ee9)\

- Implementación: Se añadió un atributo tablero para almacenar las casillas y sus estados (0 como libre y 1 como ocupado).

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/8117ce99-1d36-4e13-b5c5-2fdeb607a38a)\

### Refactorización

Dado que el método jugar realiza 2 validaciones y luego almacena el valor de la jugada, se separó en 3 métodos distintos ('validarLimitesTablero', 'validarLugarOcupado' y 'marcarCasilla'):

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/fc01883e-7948-4bf6-8458-7256af70448b)\

Además, se vuelve a correr las pruebas para asegurarse que la refactorización no alteró el funcionamiento del código:

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/1361e1e4-e481-4542-8a20-4c62c385cc99)\

### Requisito 2: Agregar soporte para dos jugadores

### Prueba: X juega primero

- Primera ejecución: La prueba falla porque el método 'proximoJugador' no existe.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/51582f1b-df07-4694-9eef-769aba7f5670)\

- Segunda ejecución: La prueba falla porque el método 'proximoJugador' existe pero no está implementado y, por ende, no retorna 'X'.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/1d89ad94-ead2-482d-a5c4-431972ac7cbf)\

- Tercera ejecución: Prueba correctamente implementada.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/9fd996e2-3c9d-4790-b344-35e10507f321)\

- Implementación: Para esta parte, se añadió la variable 'actualJugador' que inicia en 'X' y se irá cambiando dentro del método 'jugar'.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/51f64feb-b9bd-489b-9838-8c5b9df2f5f2)\

### Prueba: O juega justo después de X

- Primera ejecución: Dado que no se ha modificado la implementación anterior, la prueba falla porque siempre recibe 'X' y se espera 'O'.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/5535a4d9-cab6-42c0-b551-93be2548dbbf)\

- Segunda ejecución: Se añade el cambio de letra después de cada turno y la prueba funciona correctamente.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/c0d8c855-2f15-46e1-8368-c05e01122aa7)\

- Implementación: Se puede observar el cambio de turno al final, el cual luego será refactorizado en otro método.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/fda41351-45e9-4297-823c-4d22f67ad866)\

### Prueba: X juega justo después de O

- Primera ejecución: Se puede observar que la prueba pasa sin modificar el codigo de implementación, pues ya se implementó en la prueba anterior. Por lo tanto, se puede desechar esta prueba.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/74bb04da-d95b-4d81-bfea-9112e55be5b4)\

### Requisito 3: Agregar condiciones ganadoras

### Prueba: por defecto no hay ganador

- Primera ejecución: La prueba falla porque el método 'hayGanador' no existe.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/956c0897-c977-4c08-ac66-d6bc4a19ae52)\

- Segunda ejecución: Dado que por defecto, el método retorna false, son suficientes solo 2 ejecuciones para esta prueba.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/e2a70260-b62e-4c76-a49c-fa54eefae7f3)

- Implementación: Al ser un método de retorno, se implementa directamente en esta prueba.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/4d84624b-8139-4174-a5a1-f64be789caba)\

### Prueba – condición ganadora I

- Primera ejecución: La prueba falla porque se espera un valor verdadero y el método siempre retorna falso.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/57e6960c-786a-4ffb-83b0-62888b6ca340)\

- Segunda ejecución: Luego de la implementación, la prueba pasa correctamente.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/e40f0123-1d4b-407c-883b-61fa79a4e0be)\

- Implementación: La primera modificación fue de asignar 1 para almacenar 'X' y 2 para 'O'. Luego usando una iteración, se comprueba si cada fila esta ocupada por el mismo valor (1 o 2).

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/ea24e2cd-9660-42c1-85e0-de7bd2de2e8d)\

### Refactorización

Para esta sección, se modifica el tipo de retorno de 'hayGanador()' para que entregue el jugador que ha completado la línea horizontal. Además se cambian las pruebas creadas para que coincida con dicho cambio.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/1c72d57a-a6d2-4907-8efe-ad1d32d94efa)\

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/7727691f-11b7-4216-9d20-b2b6dde0f1a1)\

Asimismo, para evitar un cambio de turno luego de obtener un ganador, se modifica el método 'jugar':

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/907d1cf4-118e-4bbe-b2f2-44483a670c87)\

### Prueba – condición ganadora II

- Primera ejecución: La prueba falla porque se espera que el ganador sea 'X', pero aún no se implementa la verificación por líneas verticales.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/de8a4d5d-d620-43b0-a6ed-230d7fd8128a)\

- Segunda ejecución: Luego de la implementación, la prueba pasa correctamente.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/1886a54a-83a8-4896-bb15-4d38a2af9449)\

- Implementación: Se realiza de manera similar a la prueba anterior.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/86fc4fc4-9dc8-4e61-a184-1d3363fe4e8a)\

### Prueba – condición ganadora III

- Primera ejecución: La prueba falla porque se espera que el ganador sea 'X', pero aún no se implementa la verificación por primera línea diagonal.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/578031af-37db-4f02-8ae7-52935ea22ef5)\

- Segunda ejecución: Luego de la implementación, la prueba pasa correctamente.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/29c2e382-a5e8-46e4-b68b-4e6438bed64b)\

- Implementación: Se realiza directamente sin bucles.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/87b2af4c-5cb0-421a-9c8d-19b3cfeab31d)\

### Prueba – condición ganadora IV

- Primera ejecución: La prueba falla porque se espera que el ganador sea 'X', pero aún no se implementa la verificación por segunda línea diagonal.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/8846e5ae-b855-433c-af03-ce91af7af1cf)\

- Segunda ejecución: Luego de la implementación, la prueba pasa correctamente.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/c2c66f8b-c394-4d64-891a-55d9d4249f7b)\

- Implementación: Se realiza de manera similar a la prueba anterior.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/6fbde81e-34b3-4330-af78-88f110882048)\

### Refactorización

Ahora se modifica la implementación de los métodos para verificar ganador por línea diagonal para que implemente el bucle.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/4a839fd1-e1b5-48c4-a349-85db1a310aa9)\

Asimismo, se verifica que la refactorización pase todoas las pruebas.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/524b98ec-1792-4624-a51f-06ae8a7690fc)\

### Requisito 4: condiciones de empate

### Prueba: manejo de una situación de empate

- Primera ejecución: La prueba falla porque no existe el método 'hayEmpate'.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/8137b888-e87a-4b90-9340-8f3f604eeb6a)\

- Segunda ejecución: Esta prueba falla porque el método 'hayEmpate' no está implementado y siempre retorna falso.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/db5537d0-1c66-4c60-b576-09ab66b9e9c5)\

- Tercera ejecución: Luego de la implementación del método, la prueba pasa correctamente.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/0d8c4505-4e28-4098-a78d-13209bd8e798)\

- Implementación: Se lee todo el tablero buscando casillas vacías y además, se asegura que no haya ganador.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/a925692c-7e8d-483b-b45d-4321ea3a71ff)\

### Refactorización

Una posible refactorización sería de esta forma. Se agrega el método 'esGanador' y se modifican los de 'hayEmpate' y 'obtenerGanador'.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/69d6bcc4-429b-4bb1-b7d4-a97367bc1761)\

### Cobertura de código

Se aplica la cobertura de código a la unidad de pruebas.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/528ea4b9-b3f7-490b-a108-c594f1dfb71c)\

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/97dbaf15-740a-4316-ab1b-74c4e59337d2)\






