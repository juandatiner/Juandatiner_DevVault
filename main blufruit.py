from machine import Pin
import bluetooth
from BLE import BLEUART
import utime
name = "EspWilli"
print (name , "aca")
ble = bluetooth.BLE()
uart = BLEUART (ble,name)
while True:
    for i in range (100):
        uart.write(f"{i}\n")
        utime.sleep(0.1)