//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.academia.tiagopires.tester;

import javafx.scene.input.Dragboard;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SniperTest {


    double pictureX = 20;
    double pictureY = 220;

    public void drawRectEdge() {
        Rectangle rectedge = new Rectangle(10.0D, 10.0D, 1000.0D, 500.0D);
        rectedge.setColor(Color.BLACK);
        rectedge.draw();
    }

    public Picture drawPicture() {
        Picture picture = new Picture(pictureX, pictureY, "/home/itsamepires/IdeaProjects/Workspace/SniperElite/resources/soldierreworked.png");
        picture.draw();
        return picture;
    }


    public Rectangle drawHitBox() {
        Rectangle hitbox = new Rectangle(pictureX, pictureY, drawPicture().getWidth(), drawPicture().getHeight());
        hitbox.setColor(Color.RED);
        return hitbox;

    }

    public void drawAndMoveSoldier() {
        drawRectEdge();
        Picture picture = drawPicture();
        Rectangle hitbox = drawHitBox();


        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            picture.translate(73, 0);
            hitbox.translate(73, 0);


        }


    }}



