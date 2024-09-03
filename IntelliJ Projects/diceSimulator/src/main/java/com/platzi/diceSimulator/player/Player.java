package com.platzi.diceSimulator.player;

public class Player {

    private final Dice dice;
    private final int minNumber_toWin;


    public Player(Dice dice, int minNumber_toWin) {

        this.dice = dice;
        this.minNumber_toWin = minNumber_toWin;
    }

    public boolean play() {

        int diceNumber = dice.roll();
        return diceNumber > minNumber_toWin;
    }

}
