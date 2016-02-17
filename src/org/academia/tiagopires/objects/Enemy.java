package org.academia.tiagopires.objects;


import org.academia.tiagopires.game.Sound;

/**
 * Created by itsamepires on 05-02-2016.
 */
public abstract class Enemy extends GameObject implements Destroyable {
    private int health;
    private boolean isDestroyed;
    private Representation representation;


    public Enemy(int health, String path) {
        this.health = health;
        representation = new Representation(path);


    }

    public Representation getRepresentation() {
        return representation;
    }

    public int getHealth() {
        return health;
    }


    public boolean isDestroyed() {

        return isDestroyed;
    }


    public void setDestroyed(boolean dead) {
        isDestroyed = dead;
    }

    public void hit(int bulletDamage) throws Exception {

        if (health - bulletDamage <= 0) {
            health = 0;
            Sound.sound("resources/scream.wav");
            delete();
            setDestroyed(true);

        } else {

            health -= bulletDamage;
        }
    }

    public void changeEnemyDirection() {
        getRepresentation().changeDirection();
    }

    public void moveEnemy() {
        getRepresentation().move();

    }


    @Override
    public void delete() {
        getRepresentation().deletePicture();


    }

    public String getMessage() {
        return "Enemy{" +
                "health=" + health +
                ", isDead=" + isDestroyed +
                '}';
    }
}
