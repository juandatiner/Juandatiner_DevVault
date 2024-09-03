from machine import Pin as pin
from utime import sleep as pausa, sleep_ms as pausam, sleep_us as pausaus

puerto = [15, 2, 4, 16, 5, 19, 21, 22, 23, 26]
instancias = []

for i in puerto:
  instancias.append (pin(i, pin.OUT))

print (instancias)

inicio = 0
fin = 11
def derecha_a_izquierda(inicio, fin):
  for i in instancias[inicio:fin]:
    for j in range (2):
      i.value(not i.value())
    pausam(350)

def izquierda_a_derecha(inicio, fin):
  for i in reversed (instancias[inicio:fin]):
    for j in range (2):
      i.value(not i.value())
    pausam(350)


while True:
  derecha_a_izquierda(inicio, fin)
  # izquierda_a_derecha(inicio, fin)