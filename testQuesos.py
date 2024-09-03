
titulo = "Bienvenido al Test sobre el queso\n"
print("\n" + titulo + "\n" + "-" * len(titulo) + "\n")

puntuacion = 0

opcion = input("Pregunta 1: ¿Que haces cuando ves una tabla de quesos?\n"
               "A - Salgo corriendo \n"
               "B - Pruebo uno de los quesos o incluso varios \n"
               "C - No puedo evitar devorarla \n")

if opcion == "A":
    puntuacion += 0

elif opcion == "B":
    puntuacion += 5

elif opcion == "C":
    puntuacion += 10    

else:
    print("Las opciones posibles son A, B, y C")
    exit()
    

#--------------------------------------------------------------------------

opcion = input("Pregunta 2: ¿Como te gusta la hamburguesa?\n"
               "A - Sin queso \n"
               "B - Con queso \n"
               "C - Pan y queso \n")

if opcion == "A":
    puntuacion +=0

elif opcion == "B":
    puntuacion +=10

elif opcion == "C":
    puntuacion +=5    

else:
    print("Las opciones posibles son A, B, y C")
    exit()
    

#--------------------------------------------------------------------------

opcion = input("Pregunta 3: ¿Eres intolerante a la lactosa?\n"
               "A - Si \n"
               "B - No \n"
               "C - A veces \n")

if opcion == "A":
    puntuacion +=0

elif opcion == "B":
    puntuacion +=10

elif opcion == "C":
    puntuacion +=5    

else:
    print("Las opciones posibles son A, B, y C")
    exit()
    


if puntuacion >= 25:
    print("Eres un fanatico del queso, me caes genial")

elif 10 < puntuacion < 25:
    print("Te gusta el queso")

else:
    print("¿Para que hiciste este test?")    