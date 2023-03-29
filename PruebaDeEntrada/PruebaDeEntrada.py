'''
Función recursiva que evalua la suma de la lista de monedas y en cada recursión, retorna
el máximo entre incluir una moneda de la lista o no. Toma en referencia el valor maximo
de un grupo como el promedio total de la lista inicial para maximizarlo y, así, minimizar
la diferencia entre cada grupo.
'''
def split_coins(list_coins, prom_max, prom_act = 0, sum_act = 0):
    # Primer caso base: Cuando se tiene solo un elemento restante y este supera el
    # promedio actual, se retorna 0. Si no lo supera, se retorna dicho elemento.
    if len(list_coins) == 1:
        if list_coins[0] > prom_act:
            return 0
        return list_coins[0]
    
    # Cálculo del nuevo promedio
    prom_new = sum(list_coins[1:]) / 2

    # Segundo caso base: Si incluir la siguiente moneda supera el promedio máximo,
    # entonces no ejecuta la recursión.
    if sum_act + list_coins[0] > prom_max:
        return 0
    
    # Se retorna el máximo entre incluir la primera moneda de la lista actual o no.
    return max(list_coins[0] + 
               split_coins(list_coins[1:], prom_max, prom_new, sum_act + list_coins[0]), 
               split_coins(list_coins[1:], prom_max, prom_new, sum_act))

'''
Función inicial que ordena la lista de monedas, calcula el promedio y hace llamado
a la función recursiva 'split_coins'. Retorna la suma del monto que recibe cada
hijo.
'''
def split_coins_mom(list_coins):
    list_coins.sort()
    prom_max = sum(list_coins) / 2
    first_sum = split_coins(list_coins, prom_max)
    second_sum = sum(list_coins) - first_sum
    return first_sum, second_sum


# Valor ejemplo
list_mom = [1, 2, 3, 5, 5, 5, 10]
first_son, second_son = split_coins_mom(list_mom)
print(first_son, second_son)
