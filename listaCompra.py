import os
import time

print("Bienvenido a tu lista de compra")

listaCompra = []
producto = None

while True:
    producto = input("¿Que desea comprar? [Q]--> Salir : ")

    if producto == "Q":
        break

    elif producto in listaCompra:
        print(producto + " ya se encuentra en la lista" + "\n")

    else:          
        if input("\n" + "Seguro que quiere añadir: {} [S/N]".format(producto)) == "S":
            listaCompra.append(producto)
            print(producto + " añadido!")
            time.sleep(1)

        else:
            pass

        os.system('cls')

print("\n" + "La lista de compra es:")
print(listaCompra)