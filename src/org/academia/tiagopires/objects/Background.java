package org.academia.tiagopires.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.omg.CORBA.portable.Streamable;

/**
 * Created by itsamepires on 10-02-2016.
 */
public class Background {

    public static final int MARGIN = 10;

    public static double WIDTH = 1000;
    public static double HEIGHT = 500;
    Picture picture;

    public Background(String path) {
        //Rectangle rectedge = new Rectangle(MARGIN, MARGIN, WIDTH, HEIGHT);
        //rectedge.setColor(Color.YELLOW);
        picture = new Picture(10,10,path);
        picture.draw();




    }
}
