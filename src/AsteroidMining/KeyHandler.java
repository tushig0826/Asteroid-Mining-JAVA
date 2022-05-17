package src.AsteroidMining;

import src.AsteroidMining.Resources.STATE;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyHandler extends KeyAdapter {
    private Handler handler;
    private Game game;
    private Settler settler;

    public KeyHandler(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        int vel = 3;
        for(GameObject obj: handler.objects) {
            if (obj.getId() == ID.Settler) {
                settler = (Settler)obj;
                switch (key) {
                    case KeyEvent.VK_UP:
                        settler.setVelY(-vel);
                        break;
                    case KeyEvent.VK_DOWN:
                        obj.setVelY(vel);
                        break;
                    case KeyEvent.VK_LEFT:
                        obj.setVelX(-vel);
                        break;
                    case KeyEvent.VK_RIGHT:
                        obj.setVelX(vel);
                        break;
                    case KeyEvent.VK_D:
                        settler.drill();
                        break;
                    case KeyEvent.VK_H:

                        if(settler.hide());

                        break;
                    case KeyEvent.VK_F:
                        settler.fillAsteroid();
                        break;
                    case KeyEvent.VK_M:
                        settler.mine(); //mining
                        break;
                    case KeyEvent.VK_B:
                        settler.buildRobot();
                        break;
                    case KeyEvent.VK_T:
                        settler.buildTeleportationGates();
                        break;
                    case KeyEvent.VK_G:
                        settler.deployGate();
                        break;
                    case KeyEvent.VK_P:
                        game.gameState = STATE.Menu;//pausing the game
                        break;

                }
            }
        }
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
