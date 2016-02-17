package org.academia.tiagopires.tester;


import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;


public class MouseTest implements  MouseHandler {

    public static void main(String[] args) {

        SniperTest sniper = new SniperTest();
        sniper.drawAndMoveSoldier();

    }



    public void mouseClicked(MouseEvent e) {
        System.out.println(e);
    }


    public void mouseMoved(MouseEvent e) {

        System.out.println(e);

    }
}
