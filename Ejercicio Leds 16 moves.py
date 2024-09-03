from machine import Pin as pin
from utime import sleep

led1 = pin(15, pin.OUT)
led2 = pin(2, pin.OUT)
led3 = pin(4, pin.OUT)
led4 = pin(16, pin.OUT)
led5 = pin(5, pin.OUT)
led6 = pin(19, pin.OUT)
led7 = pin(21, pin.OUT)
led8 = pin(22, pin.OUT)
botonr = pin(26, pin.IN)
botonam = pin(25, pin.IN)
botonaz = pin(33, pin.IN)
botonv = pin(32, pin.IN)
botonvelocidad = pin(34, pin.IN)

LEDSt= [led1, led2, led3, led4, led5, led6, led7, led8]
LEDSsec = [led1, led8, led2, led7, led3, led6, led4, led5]
LEDS7_8 = [led2, led3, led1, led4, led6, led7, led5, led8]
LEDS9_10 = [led1, led4, led2, led3, led5, led8, led6, led7]
LEDS11_12 = [led3, led4, led5, led6, led1, led2, led7, led8]
LEDS13_14 = [led2, led3, led4, led7, led6, led5, led1, led8]
LEDS15_16 = [led1, led2, led5, led6, led3, led4, led7, led8]

pausa = 0.5
if botonvelocidad.value(0):
    pausa + 0.2

def e(a):
    a.value(1)
    sleep(pausa)
    a.value(0)
    sleep(pausa)
        
if botonvelocidad.value(0):
    pausa + 0.2

def secuencia_1():
    LEDSfinales = LEDSt[::-1]
    for elemento in LEDSfinales:
        e(elemento)
        
    
def secuencia_2():
    LEDSiniciales = LEDSt[::1]
    for elemento in LEDSiniciales:
        e(elemento)

def secuencia_3():
    LEDSpares = LEDSt[::2]
    for elemento in LEDSpares:
        e(elemento)


def secuencia_4():
    for elemento in LEDSsec:
        e(elemento)


def secuencia_5():
    LEDSimpares = LEDSt[1::2]
    for elemento in LEDSimpares:
        e(elemento)


def secuencia_6():
    LEDSrot = LEDSsec[::-1]
    for elemento in LEDSrot:
        e(elemento)



def secuencia_7():
    for elemento in LEDS7_8:
        e(elemento)
        


def secuencia_8():
    LEDrot7 = LEDS7_8[::-1]
    for elemento in LEDrot7:
        e(elemento)


def secuencia_9():
    for elemento in LEDS9_10:
        e(elemento)


def secuencia_10():
    LEDrot9 = LEDS9_10[::-1]
    for elemento in LEDrot9:
        e(elemento)


def secuencia_11():
    for elemento in LEDS11_12:
        e(elemento)

def secuencia_12():
    LEDrot11 = LEDS11_12[::-1]
    for elemento in LEDrot11:
        e(elemento)
  
def secuencia_13():
    for elemento in LEDS13_14:
        e(elemento)


def secuencia_14():
    LEDrot13 = LEDS13_14[::-1]
    for elemento in LEDrot13:
        e(elemento)


def secuencia_15():
    for elemento in LEDS15_16:
        e(elemento)


while True:
  botonam.value(0)
  botonaz.value(0)
  botonr.value(0)
  botonv.value(0)
  dato=0
  dato=botonr.value()+botonam.value()*2+botonaz.value()*4+botonv.value()*8
  print(dato)
  sleep(0.1)  

  if dato == 0:
    secuencia_15()
  if dato == 1:
    secuencia_14()
  if dato == 2:
    secuencia_13()
  if dato == 3:
    secuencia_12()
  if dato == 4:
    secuencia_11()
  if dato == 5:
    secuencia_10()
  if dato == 6:
    secuencia_9()
  if dato == 7:
    secuencia_8()
  if dato == 8:
    secuencia_7()
  if dato == 9:
    secuencia_6()
  if dato == 10:
    secuencia_5()
  if dato == 11:
    secuencia_4()
  if dato == 12:
    secuencia_3()
  if dato == 13:
    secuencia_2()
  if dato == 14:
    secuencia_1()
