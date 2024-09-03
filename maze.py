import readchar
import os
import random

POS_X = 0
POS_Y = 1

NUM_OF_MAP_OBJECTS = 15

#Create obstacle map
obstacle_definition = """\
##########################
                       ####
####    ############   ####
######  ############   ####
#####  ####
######      ######  ######
##########  ####         ##
#######            ########
#########   #####
####      ############   ###
######    ########         #
########                 ###
######## #########
#####    ###########    ####
############################\
"""

#Make sure all lines are the same length
max_line_length = max(len(line) for line in obstacle_definition.split("\n"))
obstacle_definition = [line.ljust(max_line_length) for line in obstacle_definition.split("\n")]


myPosition = [0, 1]
mapObjects= []
tail = []
tail_length = 0

end_game = False
died = False

#Clear screen
def clear_screen():
    os.system("cls" if os.name == "nt" else "clear")

#Divide into list of lists
#List comprehension
obstacle_definition = [list(row) for row in obstacle_definition]
#[position y][position x]

MAP_WIDTH = len(obstacle_definition[0])
MAP_HEIGHT = len(obstacle_definition)

#Main
while not end_game:
    
    clear_screen()
    
    #Generate random objects
    while len(mapObjects) < NUM_OF_MAP_OBJECTS:
        new_position = [random.randint(0, MAP_WIDTH - 1), random.randint(0, MAP_HEIGHT - 1)]
    
        if new_position not in mapObjects and new_position != myPosition and \
                obstacle_definition[new_position[POS_Y]][new_position[POS_X]] != "#":
            mapObjects.append(new_position)
    
    #Draw map
    print("+" + "-" * MAP_WIDTH * 2 + "+")

    for coordinate_y in range(MAP_HEIGHT):
        print("|", end = "")

        for coordinate_x in range(MAP_WIDTH):
            
            char_to_draw = "  "
            object_in_cell = None
            tail_in_cell = None


            #Draw objects
            for map_object in mapObjects:
                if map_object[POS_X] == coordinate_x and map_object[POS_Y] == coordinate_y:
                    char_to_draw = " *"
                    object_in_cell = map_object
                    

            #Draw tail
            for tail_piece in tail:
                if tail_piece[POS_X] == coordinate_x and tail_piece[POS_Y] == coordinate_y:
                    char_to_draw = " @"
                    tail_in_cell = tail_piece

            #Draw initial position
            if myPosition[POS_X] == coordinate_x and myPosition[POS_Y] == coordinate_y:
                char_to_draw = " @"
                
                #Remove objecto
                if object_in_cell:
                    mapObjects.remove(object_in_cell)
                    #Add tail
                    tail_length += 1


                #Dead with tail
                if tail_in_cell:
                    end_game = True
                    died = True

            if obstacle_definition[coordinate_y][coordinate_x] == "#":
                char_to_draw = "##"
            

            print("{}".format(char_to_draw), end = "")
        print("|")

    print("+" + "-" * MAP_WIDTH * 2 + "+")  

    #Move from position
    direction = readchar.readchar()
    new_position = None

    if direction == "w":
        #Search if new position there is a obstacle
        new_position = [myPosition[POS_X], (myPosition[POS_Y] - 1) % MAP_WIDTH]
        
    
    elif direction == "s":
        new_position = [myPosition[POS_X], (myPosition[POS_Y] + 1) % MAP_WIDTH]
        
    
    elif direction == "a":
        new_position = [(myPosition[POS_X] - 1) % MAP_WIDTH, myPosition[POS_Y]]
        
    
    elif direction == "d":
        new_position = [(myPosition[POS_X] + 1) % MAP_WIDTH, myPosition[POS_Y]]
        
    
    elif direction == "q":
        end_game = True
    
    if new_position:
        if obstacle_definition[new_position[POS_Y]][new_position[POS_X]] != "#":
            #Add last position in tail
            tail.insert(0, myPosition.copy())
            #Cut tail
            tail = tail[:tail_length] 
            #Move
            myPosition = new_position


    clear_screen()

if died:
    print("Has muerto!")