import json
import NDataStats

test_data = [
    {
        "id": 1,
        "nombre": "Irene",
        "apodo": "Lara",
        "edad": 68,
        "salario": "$27888"
    },
    {
        "id": 2,
        "nombre": "Claudio",
        "apodo": "Avila",
        "edad": 49,
        "salario": "$67137"
    },
    {
        "id": 3,
        "nombre": "Tomo",
        "apodo": "Frugs",
        "edad": 70,
        "salario": "$70472"
    }
]

def test_init():
    ds = NDataStats(test_data)
    assert ds.data == test_data
