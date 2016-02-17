package org.academia.tiagopires.game;

import org.academia.tiagopires.objects.*;
import org.academia.tiagopires.utils.PictureUtils;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by itsamepires on 05-02-2016.
 */
public class SniperRifle {


    private int bulletDamage;
    Representation representation;
    Representation shotline;
    MyLine shot;
    private boolean hasline;
    private boolean dead;

    public boolean Hasline() {
        return hasline;
    }

    public void isDead() {
        if (dead){
            representation.deletePicture();
            Background background = new Background("resources/gameover.png");
    }}

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
        representation = new Representation("resources/sniper.png");
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void shoot(double x, double y) {
        if (x > Background.MARGIN && x < Background.WIDTH && y > Background.MARGIN && y < Background.HEIGHT && hasline==false) {
            shot = new MyLine(representation.getX() + 68, representation.getY() + 13, x, y);
            hasline = true;
        } else {
            System.out.println("missed");
        }




        //enemy.hit(bulletDamage);
    }

    public void deleteShot() {
        shot.delete();
        hasline = false;

    }
}
