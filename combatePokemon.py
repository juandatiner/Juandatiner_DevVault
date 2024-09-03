from random import randint
import os

VIDA_INICIAL_PIKACHU = 80
VIDA_INICIAL_SQUIRTLE = 90

vidaPikachu = VIDA_INICIAL_PIKACHU
vidaSquirtle = VIDA_INICIAL_SQUIRTLE

       

TAMAÑO_BARRA_VIDA = 20


def borrar_pantalla():
    if os.name == 'nt':  # Para sistemas Windows
        os.system('cls')
    else:  # Para sistemas Unix/Linux/Mac
        os.system('clear')


print("\n" + "En el nivel de hoy tendras que enfrentarte ante uno de los pokemones mas conocidos que es: Pikachu" + "\n"
      "Suerte!!!" + "\n")

while vidaPikachu > 0 and vidaSquirtle > 0:
    
    #Turno pikachu
    print("---------------------------------")
    print("Turno Pikachu")
    ataquePikachu = randint(1, 3)
    
    if ataquePikachu == 1:
        #Bola Voltio
        print("Pikachu ataca con Bola Voltio")
        vidaSquirtle -= 10
    
    elif ataquePikachu == 2:
        #Onda Trueno
        print("Pikachu ataca con Onda Trueno")
        vidaSquirtle -= 11

    else:
        #No ataca
        print("Pikachu No ataca")

    if vidaPikachu < 0:
        vidaPikachu = 0
    if vidaSquirtle < 0:
        vidaSquirtle = 0 

    barraVidaPikachu = int(vidaPikachu * TAMAÑO_BARRA_VIDA / VIDA_INICIAL_PIKACHU)
    print("Pikachu: [{}{}] ({}/{})".format("*" * barraVidaPikachu, " " * (TAMAÑO_BARRA_VIDA - barraVidaPikachu), vidaPikachu, VIDA_INICIAL_PIKACHU))

    barraVidaSquirtle = int(vidaSquirtle * TAMAÑO_BARRA_VIDA / VIDA_INICIAL_SQUIRTLE)
    print("Pikachu: [{}{}] ({}/{})".format("*" * barraVidaSquirtle, " " * (TAMAÑO_BARRA_VIDA - barraVidaSquirtle), vidaSquirtle, VIDA_INICIAL_SQUIRTLE))

    input("Enter para continuar... \n\n")
    borrar_pantalla()

    #Turno Squirtle
    print("---------------------------------")
    print("Turno Squirtle")
    ataqueSquirtle= None

    while ataqueSquirtle not in ["P", "PA", "B", "N"]:

        ataqueSquirtle = input("¿Que ataque deseas realizar?  [P]--> Placaje, [PA]--> Pistola de Agua, [B]--> Burbuja, [N]--> No atacar: " )
        print("\n")
        
    if ataqueSquirtle == "P":
        #Placaje
        print("Squirtle ataca con Placaje")
        vidaPikachu -= 10
    
    elif ataqueSquirtle == "PA":
        #Pistola de Agua 
        print("Squirtle ataca con Pistola de de Agua")
        vidaPikachu -= 12

    elif ataqueSquirtle == "B":
        #Burbuja
        print("Squirtle ataca con Burbuja")
        vidaPikachu -= 9                    

    else:
        #No ataca
        print("Squirtle No ataca")

    if vidaPikachu < 0:
        vidaPikachu = 0
    if vidaSquirtle < 0:    
        vidaSquirtle = 0 

    barraVidaPikachu = int(vidaPikachu * TAMAÑO_BARRA_VIDA / VIDA_INICIAL_PIKACHU)
    print("Pikachu: [{}{}] ({}/{})".format("*" * barraVidaPikachu, " " * (TAMAÑO_BARRA_VIDA - barraVidaPikachu), vidaPikachu, VIDA_INICIAL_PIKACHU))

    barraVidaSquirtle = int(vidaSquirtle * TAMAÑO_BARRA_VIDA / VIDA_INICIAL_SQUIRTLE)
    print("Pikachu: [{}{}] ({}/{})".format("*" * barraVidaSquirtle, " " * (TAMAÑO_BARRA_VIDA - barraVidaSquirtle), vidaSquirtle, VIDA_INICIAL_SQUIRTLE))        
    
    input("Enter para continuar... \n\n")
    borrar_pantalla()

#Se dice el ganador
if vidaPikachu > vidaSquirtle:
    print("Pikachu gana")

else:
    print("Squirtle gana")