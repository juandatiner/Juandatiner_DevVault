
ingreso = input("Bienvenido a MundoLand, ¿Te gustaria recibir un 25% de descuento en tu entrada? (S/N): ")

if ingreso == "S" or ingreso == "s":
    print("Excelente, necesito que me brindes una información por favor")
    edad = int(input("¿Cuantos años tienes? "))
    carnet = input("¿Qué tipo de carnet tienes? \n"
                   "E= Universitario \n"
                   "P= Pensionado \n"
                   "F= Familia Numerosa \n"
                   "N= Ninguno \n")


    if ((25 <= edad <= 35) and carnet == "E") or (edad <= 10) or ((edad >= 65) and carnet == "P") or (carnet == "F"):
        print("Cumples con los requisitos para el descuento del 25% en tu entrada, Felicidades!!!")


    else:
        print("No cumples con los requisitos para el descuento")


else:
    print("Esta bien el valor de tu entrada sera completo")