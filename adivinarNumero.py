import random

numeroGanador = random.randint(1,10);

numeroUsuario = int(input("Debes adivinar el número, Ingresa un numero del 1-10: "))

if numeroUsuario != numeroGanador:
    print("Perdiste :/ , el numero ganador era: {}".format(numeroGanador))
    SystemExit

else :
    print("Ganaste!!!")    