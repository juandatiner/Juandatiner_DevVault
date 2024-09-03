
respuesta = None

while respuesta != "A" and respuesta != "B" and respuesta != "C":
    respuesta = input("\n" + "¿Que opcion prefieres [A,B,C]?: ")

if respuesta == "A":
    print("Has elegido bien")
elif respuesta == "B":
    print("Podrias haber elegido mejor")
else:
    print("Elejiste mal")