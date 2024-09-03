package com.platzi.functional._14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalsJ {

    public static void main(String[] args) {

        List<String> names = getNames();
        if(names != null){
            // The empty data always be taken and this can affect
        }

        Optional<List<String>> optionalNames = getOptionalName();

        //optionalFunction is present (Consumer(lambda -> Sout))
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> valuablePlayer = optionalValuablePlayer();

        String valuablePlayerName = valuablePlayer.orElseGet(() -> "No Player"); // No player is better that an empty space

        //Is more easy and practice to do that because manage all the case with the Uncertain data
    }


    ////////////////////////////////////////////////////////////////////////
    static List<String> getNames(){ // is a basic List

        List<String> list = new LinkedList<>();

        return Collections.emptyList();  // return a list without elements
    }

    static List<String> mostValuablePlayer(){

//        return ""; // is good?
        return null; // or that?
    }

    static int mostExpensiveItem(){

        return -1; // or that?
    }

    ////////////////////////////////////////////////////////////////////////

    //Optional Function
    static Optional<List<String>> getOptionalName(){

        List<String> namesList = new LinkedList<>();

        //get names
        return Optional.of(namesList);
    }

    static Optional<String> optionalValuablePlayer(){

        try {
            //Access
            return Optional.of("Juanda");
        }catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
