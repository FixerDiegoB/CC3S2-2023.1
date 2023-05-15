### Antes de la refactorización

- Clase Member: Se implementa tal cual se espeficifica en la pregunta con un método adicional para obtener el nombre.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/7378d78d-ddfa-4b3b-9fdf-bb3b2c745748)\

- Clase PremiumMember: Implementa ambos métodos y añade una salida por consola para verificar el correcto funcionamiento.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/4cbe7c30-b790-4414-b22a-811089f47085)\

- Clase VipMember: Se implementa similar a la clase anterior, por lo que no hay mayor cambio más que la salida de consola.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/7249e5c2-fcc8-4730-938f-d0b537ad45df)

- Clase FreeMember: El cambio se muestra en la salida por consola del método 'organizeTournament()'.

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/98bc5401-a9a5-4fad-b1cd-e864a82d1887)\

### Después de la refactorización

Para que el código sea compatible con LSP, se plantean los siguientes cambios:
- Crear una interfaz TournamentParticipant que defina el método joinTournament().

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/56d61618-5c02-4db8-8d16-583af7137756)\

- Modificar la clase Member abstracta para que implemente la interfaz TournamentParticipant y que contenga el método getNombre().

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/d8164dd3-7ca6-4d06-928d-39ac9af13fe8)\

- Crear una clase Organizer abstracta que herede de Member y agregue el método organizeTournament().

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/6ade866a-1ca9-41d6-a4be-b2fae4b80db6)\

- Modificar la clase FreeMember para que herede de Member, pero no implemente el método organizeTournament().

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/f7669feb-a47e-49c9-a7f3-678dcb85089f)\

- Modificar las clases PremiumMember y VipMember para que hereden de Organizer e implementen el método organizeTournament().

![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/97d97024-bf40-4c46-94a1-f061d67fc1c3)\
![image](https://github.com/FixerDiegoB/CC3S2-2023.1/assets/57854488/80d97bc2-27ae-4cbb-86cd-c161d3f73cf4)\

