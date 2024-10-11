package com.platzi.diceSimulator.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void losses_when_dice_number_is_too_low() {

        Dice dice = Mockito.mock(Dice.class);   //simulator of a dice

        Mockito.when(dice.roll()).thenReturn(1);  //simulate with result in 2

        Player player = new Player(dice, 3);
        assertFalse(player.play());

    }

    @Test
    public void wins_when_dice_number_is_big() {

        Dice dice = Mockito.mock(Dice.class);   //simulator of a dice

        Mockito.when(dice.roll()).thenReturn(4);  //simulate with result in 2

        Player player = new Player(dice, 3);
        assertTrue(player.play());

    }
}