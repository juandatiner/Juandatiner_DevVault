
numero = int(input("¿De que numero quiere ver la tabla de multiplicar?: "))

for n in range(1, 11):
    if (n*numero) % 2 == 0:
        print("{} x {} = {}".format(numero, n, n * numero))



    