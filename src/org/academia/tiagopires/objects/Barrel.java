package org.academia.tiagopires.objects;

import org.academia.tiagopires.game.Sound;

/**
 * Created by itsamepires on 08-02-2016.
 */

public class Barrel extends GameObject implements Destroyable {

    private boolean isDestroyed;
    BarrelType barrelType;
    Representation representation;
    private int barrelHitPoints;
    private SoldierEnemy soldierEnemy;


    public Barrel() {
        getRandomType();
        representation = new Representation(barrelType.getPath());
        barrelHitPoints = barrelType.getMaxDamage();
    }

    public Representation getRepresentation() {
        return representation;
    }

    @Override
    public String getMessage() {
        return "Barrel{" +
                ", destoyed=" + isDestroyed +
                '}';
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    @Override
    public void delete() {
        getRepresentation().deletePicture();

    }


    @Override
    public void hit(int bulletDamage) throws Exception {

        if (barrelHitPoints - bulletDamage > 0) {

            barrelHitPoints -= bulletDamage;

            System.out.println(barrelHitPoints);

            if (barrelHitPoints - bulletDamage <= 0) {

                barrelHitPoints = 0;
                Sound.sound("resources/barrel.wav");

                delete();

                setDestroyed(true);


            }
        }

    }

    private void createNewSoldier() throws InterruptedException {
        soldierEnemy = new SoldierEnemy(2);
        while (true) {
            soldierEnemy.moveEnemy();
            soldierEnemy.changeEnemyDirection();
        }
    }


    public BarrelType getRandomType() {

        int ran = (int) (Math.random() * BarrelType.values().length);

        barrelType = BarrelType.values()[ran];

        return barrelType;

    }

}

