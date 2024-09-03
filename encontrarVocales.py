
vocales = ["a", "e", "i", "o", "u"]

frase = "Hola estoy aprendiendo python en mi mamalona"

vocalesEncontradas = 0

for letra in frase:
    if letra in vocales:
        print("He encontrado una: {}".format(letra))
        vocalesEncontradas += 1


print("\n" + "Vocales encontradas: {}".format(vocalesEncontradas))