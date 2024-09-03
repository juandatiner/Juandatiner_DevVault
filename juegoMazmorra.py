import random

titulo = "Juego de la Mazmorra"
print("\n" + titulo + "\n" + "-" * len(titulo) + "\n"
      "Tu y tu compañero de celda os acabais de escapar de la prision espacial, habeis burlado a los guardias y os \n"
      "dirigis hacia el exterior. Entrais en una mazmorra controlada por mounstros alienigenas, uno de los guardias \n"
      "ataca a tu compañero, se lo lleva pero tu pasas desapercibido escondido en las sombras. El guardia se retira, \n"
      "es tu posibilidad de escapar. ¿Hacia donde te diriges? \n"
      "\n"
      "A la izquierda tienes una puerta semiabierta, a la derecha una escotilla en el suelo")


opcion = input("[OPCION (A) --> Puerta semiabierta] | [OPCION (B) --> Escotilla en el suelo]: ")

if opcion == "A":
    print("\n"+"Entras por la puerta semiabierta a un pasillo y un guardia te descubre, ¿Que decides hacer?")

    opcion = input("[OPCION (A) --> Tirarte al suelo y hacerte el dormido] | [OPCION (B) --> Escapar por una puerta que vez al fondo del pasillo]: ")

    if opcion == "A":
        print("\n"+"GAME OVER... El guardia no es tonto y te descrubre y pasaras el resto de tu vida en una carcel de maximo seguridad")

    elif opcion == "B":
        print("\n"+"Apenas ingresas, la puerta se cierra, se prendes las luces y miras que estas en un cuarto blanco vacio en silencio, ¿Que haras?")

        opcion = input("[OPCION (A) --> Esperar que sucede en silencio] | [OPCION (B) --> Gritar lo mas fuerte posible]: ")

        if opcion == "A":
            print("\n"+"El tener calma fue la mejor decisión, notas que hay un tiempo que en poco terminara\n"
                  "el tiempo llega a 00:00 el cual abre una pared en el medio con dos salidas, ¿Por cual salida saldras?")

            opcion = input("[OPCION (A) --> Esta salida parece que es un paisaje y dice salida en la parte superior]" 
                           "| [OPCION (B) --> Esta salida no dice nada y solo se ve oscura]: ")

            if opcion == "A":
                print("\n"+"GAME OVER... Apenas entras caes un hueco que al final tiene unos filos donde mueres terroficamente.")

            elif opcion == "B":
                print("\n"+"GANASTE... lograste salir ileso de la mazmorra, la clave fue ser arriesgado y no tomar los caminos faciles o apresurados.")

            else:
                print("\n"+"Las opciones validas son A y B")
                exit()

        elif opcion == "B":    
            print("\n"+"GAME OVER... Llamaste la atención de los guardias y te disparan en la cabeza por poco llegar a huir.")

        else:
            print("\n"+"Las opciones validas son A y B")
            exit()     

    else:
        print("\n"+"Las opciones validas son A y B")
        exit()        

elif opcion == "B":
    print("\n"+"Caes a un pozo con mucha luz donde logras ver un palo enorme con chuzos, ¿Lo tomarás?")

    palo = input("[OPCION (A) --> Si] | [OPCION (B) --> No]: ")

    if palo == "A":
        palo = True

    elif palo == "B":
        palo = False

    else:
        print("\n"+"Las opciones validas son A y B")
        exit()       

    print("\n"+"Continuas caminando y de la nada sobre tu cabeza cae una rata gigante de 10 metros"
          "quien te dice que para pasar debes resolverle una pregunta, ¿Lo haras?")
    
    opcion = input("[OPCION (A) --> Si] | [OPCION (B) --> No]: ")

    if opcion == "A":
        print("\n"+"Necesitaras resolverle una operacion arimetica: ")
        
        random = random.randint(1,20)
        valorOperacion = 13 * random

        operacion = int(input("¿Cuanto es 13 * "+ str(random) + "?: "))

        if operacion == valorOperacion:
            print("\n"+"No solo eres bueno escapando si no aun mejor con los números, "
                  "sigues caminando y te encuentras con un cocodrilo gigante a quien venceras con el palo, ¿Lo tomaste cierto?")

            if palo == True:
                print("\n"+"Si trajiste el palo, no sera necesaria mucha fuerza para vencerlo \n"
                      "\nGANASTE... Sabia que lo vencerias siendo asi de astut@")
                
            else:
                print("\n"+"GAME OVER... ¿Que se te paso por la cabeza en pensar que no habrian mas animales gigantes en ese pozo?.")
            
        else:
            print("\n"+"GAME OVER... No solo debias ser bueno corriendo, a practicar las tablas en la otra vida.")

    elif opcion == "B":
        print("\n"+"GAME OVER... ¿Pensaste que te dejaria pasar asi no más?.")

    else:
        print("\n"+"Las opciones validas son A y B")
        exit()

else:
    print("\n"+"Las opciones validas son A y B")
    exit()        
