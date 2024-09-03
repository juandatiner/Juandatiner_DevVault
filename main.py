from machine import Pin
import bluetooth
from BLE import BLEUART
import utime
name = "EspWilli"
print (name , "aca")
ble = bluetooth.BLE()
uart = BLEUART (ble,name)
def on_rx():
    rx_recibe = uart.read().decode().strip()
    uart.write("dato:" + str(rx_recibe) + "\n")
    
uart.irq(handler = on_rx)
 