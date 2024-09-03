from machine import Pin as pin
from utime import sleep as pausa, sleep_ms as pausam, sleep_us as pausau

led_1 = pin(15, pin.OUT)
led_2 = pin(2, pin.OUT)
led_3 = pin(4, pin.OUT)
led_4 = pin(16, pin.OUT)
led_5 = pin(5, pin.OUT)
led_6 = pin(19, pin.OUT)
led_7 = pin(21, pin.OUT)
led_8 = pin(22, pin.OUT)
led_9 = pin(23, pin.OUT)
led_10 = pin(26, pin.OUT)


def imprimir_led(a, b, c, d, e, f, g, h, i, k):
  led_1.value(a)
  led_2.value(b)
  led_3.value(c)
  led_4.value(d)
  led_5.value(e)
  led_6.value(f)
  led_7.value(g)
  led_8.value(h)
  led_9.value(i)
  led_10.value(k)
  pausam(200)

while True:
  imprimir_led(1, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  imprimir_led(0, 1, 0, 0, 0, 0, 0, 0, 0, 0) 
  imprimir_led(0, 0, 1, 0, 0, 0, 0, 0, 0, 0) 
  imprimir_led(0, 0, 0, 1, 0, 0, 0, 0, 0, 0) 
  imprimir_led(0, 0, 0, 0, 1, 0, 0, 0, 0, 0) 
  imprimir_led(0, 0, 0, 0, 0, 1, 0, 0, 0, 0) 
  imprimir_led(0, 0, 0, 0, 0, 0, 1, 0, 0, 0)
  imprimir_led(0, 0, 0, 0, 0, 0, 0, 1, 0, 0)
  imprimir_led(0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
  imprimir_led(0, 0, 0, 0, 0, 0, 0, 0, 0, 1)