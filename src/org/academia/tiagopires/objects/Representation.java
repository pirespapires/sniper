
package org.academia.tiagopires.objects;

import org.academia.tiagopires.game.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by itsamepires on 10-02-2016.
 */
public class Representation {

    private Picture picture;
    private int direction;

    public Representation(String path) {

        this.picture = new Picture(0, 0, path);
        picture.draw();
        setRandomPosition();
        direction = (int) (Math.random() * 4);
    }

    public double getX() {
        return picture.getX();
    }

    public double getY() {
        return picture.getY();
    }

    public double getWidth() {
        return picture.getWidth();
    }

    public double getHeight() {
        return picture.getHeight();
    }


    public void deletePicture() {
        picture.delete();
    }

    private void setRandomPosition() {

        double randX = RandomGenerator.random(Background.MARGIN, (int) (Background.WIDTH - picture.getWidth() + Background.MARGIN));

        double randY = RandomGenerator.random(Background.MARGIN, (int) (Background.HEIGHT - picture.getHeight() + Background.MARGIN));

        picture.translate(randX, randY);
    }


    private void moveRight() {
        picture.translate(1, 0);

    }

    public Picture picture() {
        return picture;
    }

    private void moveLeft() {
        picture.translate(-1, 0);


    }

    private void moveUp() {
        picture.translate(0, -1);

    }

    private void moveDown() {

        picture.translate(0, 1);
    }

    // TODO: create changeDirection method that changes the direction property
    public void changeDirection() {
        int random = (int) (Math.random() * 100);
        if (random <= 2) {
            direction = (int) (Math.random() * 4);
        }
    }

    public int getDirection() {
        return direction;
    }

    public boolean contains(double x, double y) {
        return (x > picture().getX() && x < picture().getWidth() + picture().getX() &&
                y > picture().getY() && y < picture().getHeight() + picture().getY());

    }

    //x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;

    public boolean contains(Representation representation) {

        return (picture.getX()<=representation.getX()+representation.getWidth()&& picture.getX() +picture.getWidth()>=representation.getX() &&
        picture.getY()<=representation.getY()+representation.getHeight() && picture.getY()+picture.getHeight() >=representation.getY());
    }


    public void setOppositeDirection() {
        switch (direction) {
            case 0:
                this.direction = 1;
                break;
            case 1:
                this.direction = 0;
                break;
            case 2:
                this.direction = 3;
                break;
            case 3:
                this.direction = 2;
                break;
        }

    }

    // TODO: change method name to move and remove direction argument (inside the method use the direction property)
    public void move() {

        switch (direction) {
            case 0: //up
                if (picture.getY() < Background.MARGIN) {
                    direction = 1;
                }
                moveUp();
                break;
            case 1: //down
                if (picture.getMaxY() > Background.HEIGHT + Background.MARGIN) {
                    direction = 0;
                }
                moveDown();
                break;
            case 2: //right
                if (picture.getMaxX() > Background.WIDTH) {
                    direction = 3;
                }
                moveRight();
                break;
            case 3: //left
                if (picture.getX() < Background.MARGIN) {
                    direction = 2;
                }
                moveLeft();
                break;

        }
    }
}


