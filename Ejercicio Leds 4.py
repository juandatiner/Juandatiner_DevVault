from machine import Pin as pin 
from utime import sleep as pausa, sleep_ms as pausam, sleep_us as pausaus

led1 = pin(15,pin.OUT)
led2 = pin(2,pin.OUT)
led3 = pin(4,pin.OUT)
led4 = pin(16,pin.OUT)
led5 = pin(5,pin.OUT)
led6 = pin(19,pin.OUT)
led7 = pin(21,pin.OUT)
led8 = pin(22,pin.OUT)
led9 = pin(23,pin.OUT)
led10 = pin(26,pin.OUT)

leds = [led1,led2,led3,led4,led5,led6,led7,led8,led9,led10]

def derecha():
  for i in leds:
    for j in range (2):
      i.value(not i.value())
      pausam(150)
def izquierda():
  for i in reversed(leds):
    for j in range (2):
      i.value(not i.value())
      pausam(150)

while True:
  derecha()
  #izquierda()
