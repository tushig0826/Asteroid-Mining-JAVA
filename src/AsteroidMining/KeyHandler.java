package src.AsteroidMining;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class has responsibility for handling the events related to keyboard interrupts.
 */
public class KeyHandler extends KeyAdapter {
    private Handler handler;
    private Game game;
    private Settler settler;

    public KeyHandler(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (GameObject obj : handler.objects) {
            if (obj.getClass().getName().equals(Settler.class.getName())) {
                settler = (Settler) obj;
                switch (key) {
                    //5.2.2 Settler traveling
                    case KeyEvent.VK_UP:
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

                    //5.2.3 Settler Drills
                    case KeyEvent.VK_D:
                        settler.drill();
                        break;

                    //5.2.4 Settler Mine
                    case KeyEvent.VK_M:
                        settler.mine();
                        break;

                    //5.2.5 Fill Asteroid
                    case KeyEvent.VK_F:
                        settler.putResource(new Resource());
                        break;

                    //5.2.6 Building the Robot
                    case KeyEvent.VK_R:
                        settler.buildRobot();
                        break;

                    //5.2.7 Building teleportation Gates
                    case KeyEvent.VK_T:
                        settler.buildTeleportationGates();
                        break;

                    //5.2.8 Deploying the Gate
                    case KeyEvent.VK_G:
                        settler.deployGate(settler.getTeleportationGate());
                        break;

                    //5.2.9 Settler Hides
                    case KeyEvent.VK_H:
                        settler.hide();
                        break;

                    //5.2.10 Sunstorm occurs
                    //5.2.11 Control Asteroid Explosion
                    //5.2.12 WaterIce sublimates
                    case KeyEvent.VK_X:
                        System.out.println("\nPlease type \"test sunstorm\", \"test explosion\" or \"test sublimate\"");
                        java.util.Scanner sc = new java.util.Scanner(System.in);
                        String input = sc.nextLine();

                        if (input.equals("test sunstorm"))
                            game.createSunStorm();
                        if (input.equals("test explosion"))
                            game.determinePerihelion();
                        if (input.equals("test sublimate"))
                            game.determinePerihelion();
                        break;

                    //5.2.13 Winning the Game
                    case KeyEvent.VK_S:
                        settler.buildSpaceShip();
                        break;

                    //5.2.14 User exits the Game
                    case KeyEvent.VK_ESCAPE:
                        game.endGame();
                        break;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject obj : handler.objects) {
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
