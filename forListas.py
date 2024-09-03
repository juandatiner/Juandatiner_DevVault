"""
listaNumeros= []

numero = int(input("\n" +"Ingresa un numero en la lista"))
listaNumeros.append(numero)

while input ("\n" + "Deseas ingresar mas numeros a la lista? [S/N]: "):
    numero = int(input("\n" +"Ingresa un numero en la lista"))
    listaNumeros.append(numero)

print(listaNumeros)
"""




#numerosIntroducidos = input("\n" + "Ingresa los numero separados por coma: ")
#numerosUsuario = numerosIntroducidos.split(",")
#numerosLimpios = []
#
#for numero in numerosUsuario:
#    numerosLimpios.append(int(numero))
#
#print(numerosLimpios)



numerosIntroducidos = input("\n" + "Ingresa los numero separados por coma: ")

numerosUsuario = [int(numero) for numero in numerosIntroducidos.split(",")]

numeroPequenio = numerosUsuario[0]
numeroGrande = numerosUsuario[0]

for numero in numerosUsuario[1:]:
    if numeroPequenio > numero:
        numeroPequenio = numero
    
    if numeroGrande < numero:
        numeroGrande = numero

print("Numero grande: {}, Numero Pequeño: {}".format(numeroGrande,numeroPequenio))