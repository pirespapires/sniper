package org.academia.tiagopires.game;

import org.academia.tiagopires.objects.*;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

/**
 * Created by itsamepires on 05-02-2016.
 */
public class Game implements MouseHandler {
    private int counter = 1;
    GameObject[] gameObjects;
    SniperRifle sniperRifle;
    private int enemyHealth = 1;
    private int enemyArmour = 2;
    private int bulletDamage = 1;
    private int numberOfObjects;
    private Background background;
    private double mouseX;
    private double mouseY;
    Mouse mouse;
    private boolean mouseClicked;


    public Game(int numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
        background = new Background("resources/desert.png");
        gameObjects = createObjects(numberOfObjects);
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    public GameObject[] createObjects(int numberOfObjects) {

        GameObject[] newGameObjects = new GameObject[numberOfObjects];

        for (int j = 0; j < numberOfObjects; j++) {

            double random = Math.random() * 100;

            if (0 < random && random < 30) {
                newGameObjects[j] = new ArmouredEnemy(enemyHealth, enemyArmour);
            }
            if (random >= 30 && random < 80) {
                newGameObjects[j] = new SoldierEnemy(enemyHealth);
            }
            if (random >= 80 && random <= 100) {
                newGameObjects[j] = new Barrel();
            }

        }

        return newGameObjects;

    }

    public void start() throws Exception {

        sniperRifle = new SniperRifle(bulletDamage);

        while (true) {
            Thread.sleep(50);
            shootWithMouse();
            for (int j = 0; j < gameObjects.length; j++) {
                if (counter % 5 == 0 && sniperRifle.Hasline()) {
                    sniperRifle.deleteShot();
                }

                if (!(gameObjects[j] instanceof Enemy)) {
                    continue;
                }
                Enemy enemy = (Enemy) gameObjects[j];

                enemy.changeEnemyDirection();
                enemy.moveEnemy();

                if (enemy.getRepresentation().contains(sniperRifle.getRepresentation())) {
                    sniperRifle.setDead(true);
                    sniperRifle.isDead();
                }
                counter++;

                for (int i = 0; i < gameObjects.length; i++) {

                    if (!(gameObjects[i] instanceof Enemy)) {
                        continue;
                    }

                    Enemy enemy1 = (Enemy) gameObjects[i];

                    if (i == j) {
                        continue;
                    }

                    if (enemy.getRepresentation().contains(enemy1.getRepresentation())) {

                        enemy.getRepresentation().setOppositeDirection();
                        enemy1.getRepresentation().setOppositeDirection();
                    }

                    if (enemy.isDestroyed()) {
                        gameObjects[j] = null;
                    }
                }
            }
        }
    }

    public void shootWithMouse() throws Exception {
        if (mouseClicked) {
            System.out.println("x: " + mouseX + "  y: " + mouseY);
            sniperRifle.shoot(mouseX, mouseY);
            Sound.sound("resources/pistol.au");
            mouseClicked = false;
            for (int j = 0; j < gameObjects.length; j++) {

                if (gameObjects[j] instanceof Destroyable) {
                    Destroyable enemy = (Destroyable) gameObjects[j];

                    if (enemy.getRepresentation().contains(mouseX, mouseY)) {
                        enemy.hit(bulletDamage);
                    }


                }
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY() - 30;
        mouseClicked = true;

    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}



