package org.academia.tiagopires.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;

/**
 * Created by itsamepires on 11-02-2016.
 */
public class MyLine  {

    Line myLine;

    public MyLine(double v, double v1, double v2, double v3) {
        myLine = new Line(v,v1,v2,v3);
        myLine.setColor(Color.RED);
        myLine.draw();

    }

    public void delete (){
        myLine.delete();
    }
}
