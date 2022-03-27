package src.AsteroidMining;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
    private Handler handler;
    private Game game;
    private Settler settler;

    public KeyHandler(Handler handler, Game game, Settler settler){
        this.handler = handler;
        this.game = game;
        this.settler = settler;

    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        //int vel = 5;

                //settler = (Settler)obj;
                switch (key) {
                    case KeyEvent.VK_UP:
                        //settler.setVelY(-vel);
                        settler.travel(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        settler.travel(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        settler.travel(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        settler.travel(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_D:
                        settler.drill();
                        break;
                    case KeyEvent.VK_H:
                        if(settler.hide());
                        break;
                }
            //}
        //}
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for(GameObject obj: handler.objects) {
            if (obj.getId() == ID.Settler) {
                switch (key) {
                    case KeyEvent.VK_UP:
                        obj.setVelY(0);
                        break;
                    case KeyEvent.VK_DOWN:
                        obj.setVelY(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        obj.setVelX(0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        obj.setVelX(0);
                        break;
                }
            }
        }
    }



}
