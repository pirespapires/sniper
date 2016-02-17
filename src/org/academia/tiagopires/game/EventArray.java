package org.academia.tiagopires.game;

import org.academia.tiagopires.objects.GameObject;

/**
 * Created by itsamepires on 16-02-2016.
 */
public class EventArray {

    GameObject[] gameObjects;
    private int nextIndex;

    public EventArray(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void push( GameObject e){

        gameObjects[nextIndex]=e;
        nextIndex++;

    }
    public GameObject pop(){
        nextIndex--;
        return gameObjects[nextIndex];
    }
}
