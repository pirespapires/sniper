package org.academia.tiagopires.game;



/**
 * Created by itsamepires on 03-02-2016.
 */
public class RandomGenerator {

  private int Min;
    private  int Max;


    public static int random(int Min, int Max) {


        return Min + (int)(Math.random() * ((Max-Min)+1));

    }

}
