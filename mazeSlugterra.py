import random
import readchar
import os

#Nuestro personaje
VIDA_INICIAL_BURPY = 100

TAMAÑO_BARRA_VIDA = 10


#Clear screen
def clear_screen():
    os.system("cls" if os.name == "nt" else "clear")


#Initial positions
POS_X = 0
POS_Y = 1


#Positions
burpyPosition = [0, 1]
sierraPosition = [2, 5]
joulesPosition = [2, 10]
stinkyPosition = [19, 13]
docPosition = [20, 2]

levelBurpy= 0

mapEnemies= [sierraPosition, joulesPosition, stinkyPosition, docPosition]
end_game = False

sierra_found = False
joules_found = False
stinky_found = False
doc_found = False

#Create obstacle map
obstacle_definition = """\
############################
        ###            #####
####    #########       ####
######  ##########      ####
          ####
         #########    ######
         ########      #####
#######             ########
#########   #####
           ###########   ###
             #####      ####
    ######               ###
################
###########             ####
############################\
"""

#Make sure all lines are the same length
max_line_length = max(len(line) for line in obstacle_definition.split("\n"))
obstacle_definition = [line.ljust(max_line_length) for line in obstacle_definition.split("\n")]


#Divide into list of lists
#List comprehension
obstacle_definition = [list(row) for row in obstacle_definition]
#[position y][position x]

MAP_WIDTH = len(obstacle_definition[0])
MAP_HEIGHT = len(obstacle_definition)


#Main
while not end_game:
    
    clear_screen()

    #Draw map
    print("--------------       BATTLE OF SLUGS       ---------------")
    print("+" + "-" * MAP_WIDTH * 2 + "+")

    for coordinate_y in range(MAP_HEIGHT):
        print("|", end = "")

        for coordinate_x in range(MAP_WIDTH):
            
            char_to_draw = "  "
            enemies_in_cell = None

            #Draw enemies
            for map_Enemie in mapEnemies:
                if map_Enemie[POS_X] == coordinate_x and map_Enemie[POS_Y] == coordinate_y:
                    char_to_draw = " *"
                    enemies_in_cell = map_Enemie


            #Draw initial position
            if burpyPosition[POS_X] == coordinate_x and burpyPosition[POS_Y] == coordinate_y:
                char_to_draw = " @"
                

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
        new_position = [burpyPosition[POS_X], (burpyPosition[POS_Y] - 1) % MAP_WIDTH]
        
    
    elif direction == "s":
        new_position = [burpyPosition[POS_X], (burpyPosition[POS_Y] + 1) % MAP_WIDTH]
        
    
    elif direction == "a":
        new_position = [(burpyPosition[POS_X] - 1) % MAP_WIDTH, burpyPosition[POS_Y]]
        
    
    elif direction == "d":
        new_position = [(burpyPosition[POS_X] + 1) % MAP_WIDTH, burpyPosition[POS_Y]]
        
    
    elif direction == "q":
        clear_screen()
        end_game = True

    elif direction == "\r":
        if burpyPosition in mapEnemies:
            print("¿Quieres enfrentarte a este enemigo nivel {}?".format(mapEnemies.index([burpyPosition[POS_X], burpyPosition[POS_Y]]) + 1 + levelBurpy))
            print("ENTER para luchar")

            clear_screen()

            if burpyPosition[POS_X] == sierraPosition[POS_X] and burpyPosition[POS_Y] == sierraPosition[POS_Y]:
                print("Tu rival es sierra")

    if new_position:
        if obstacle_definition[new_position[POS_Y]][new_position[POS_X]] != "#":
            burpyPosition = new_position
            
            
