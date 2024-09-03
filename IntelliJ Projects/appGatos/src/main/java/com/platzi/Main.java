package com.platzi;

import javax.swing.*;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        int optionMenu = -1;

        String[] bottom = {
                "1. See Cats",
                "2. See Favourites",
                "3. Exit"
        };
        do {

            String option = (String) JOptionPane.showInputDialog(null,
                    "Cats Java", "Pricipal Menu", JOptionPane.INFORMATION_MESSAGE,
                    null, bottom, bottom[0]);

            for (int i = 0; i < bottom.length; i++) {

                if (option.equals(bottom[i])){

                    optionMenu = i;
                }
            }

            switch (optionMenu){

                case 0:
                    CatsService.seeCats();
                    break;

                case 1:
                    Cats cats = new Cats();
                    CatsService.seeFavourites(cats.getApikey());

                default:
                    break;
            }
        } while (optionMenu != 1);
    }
}