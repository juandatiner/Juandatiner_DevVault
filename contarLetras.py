import string

espacios = 0
puntos = 0
comas = 0
mayusculas = 0

textoUsuario = input("\n" + "Escribeme en un parrafo información importante de ti: ")

for letra in textoUsuario:
    if letra == " ":
        espacios += 1
    elif letra == ".":
        puntos += 1
    elif letra == ",":
        comas += 1
    elif letra in string.ascii_uppercase:
        mayusculas += 1


print("Tu parrafo tiene: {} Mayusculas, {} Espacios, {} puntos, {} comas".format(mayusculas,espacios,puntos,comas))