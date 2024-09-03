import readchar
import os
import random

POS_X = 0
POS_Y = 1

MAP_WIDTH = 20
MAP_HEIGHT = 15
NUM_OF_MAP_OBJECTS = 25

myPosition = [6, 3]
mapObjects= []
tail = []
tail_length = 0

end_game = False
died = False

#Clear screen
def clear_screen():
    os.system("cls" if os.name == "nt" else "clear")

#Main
while not end_game:
    
    clear_screen()
    
    #Generate random objects
    while len(mapObjects) < NUM_OF_MAP_OBJECTS:
        new_position = [random.randint(0, MAP_WIDTH), random.randint(0, MAP_HEIGHT)]
    
        if new_position not in mapObjects and new_position != myPosition:
            mapObjects.append(new_position)
    
    #Draw map
    print("+" + "-" * MAP_WIDTH * 3 + "+")

    for coordinate_y in range(MAP_HEIGHT):
        print("|", end = "")

        for coordinate_x in range(MAP_WIDTH):
            
            char_to_draw = " "
            object_in_cell = None
            tail_in_cell = None


            #Draw objects
            for map_object in mapObjects:
                if map_object[POS_X] == coordinate_x and map_object[POS_Y] == coordinate_y:
                    char_to_draw = "*"
                    object_in_cell = map_object
                    

            #Draw tail
            for tail_piece in tail:
                if tail_piece[POS_X] == coordinate_x and tail_piece[POS_Y] == coordinate_y:
                    char_to_draw = "@"
                    tail_in_cell = tail_piece

            #Draw initial position
            if myPosition[POS_X] == coordinate_x and myPosition[POS_Y] == coordinate_y:
                char_to_draw = "@"
                
                #Remove objecto
                if object_in_cell:
                    mapObjects.remove(object_in_cell)
                    #Add tail
                    tail_length += 1


                #Dead with tail
                if tail_in_cell:
                    end_game = True
                    died = True


            print(" {} ".format(char_to_draw), end = "")
        print("|")

    print("+" + "-" * MAP_WIDTH * 3 + "+")  

    #Move from position
    direction = readchar.readchar()

    if direction == "w":
        #Add last position in tail
        tail.insert(0, myPosition.copy())
        #Cut tail
        tail = tail[:tail_length] 
        #Move
        myPosition[POS_Y] -= 1
        #Pass limit map --> move star map
        myPosition[POS_Y] %= MAP_HEIGHT
    
    elif direction == "s":
        tail.insert(0, myPosition.copy())
        tail = tail[:tail_length] 
        myPosition[POS_Y] += 1
        myPosition[POS_Y] %= MAP_HEIGHT
    
    elif direction == "a":
        tail.insert(0, myPosition.copy())
        tail = tail[:tail_length] 
        myPosition[POS_X] -= 1
        myPosition[POS_X] %= MAP_WIDTH 
    
    elif direction == "d":
        tail.insert(0, myPosition.copy())
        tail = tail[:tail_length] 
        myPosition[POS_X] += 1
        myPosition[POS_X] %= MAP_WIDTH 
    
    elif direction == "q":
        end_game = True
    
    clear_screen()

if died:
    print("Has muerto!")