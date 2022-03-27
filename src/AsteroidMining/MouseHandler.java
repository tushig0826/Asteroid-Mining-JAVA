package src.AsteroidMining;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter implements MouseListener {
    private Handler handler;
    private Game game;
    //private Settler settler;

    public MouseHandler(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        //this.settler = settler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        for(Place place:handler.neighbours){
            System.out.println("pressed");
            if(place.getBounds().contains(mx, my)){
                game.settler.setX(mx);
                game.settler.setY(my-place.height);
            }
        }

    }

}
