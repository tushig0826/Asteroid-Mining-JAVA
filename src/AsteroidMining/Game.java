package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * This class handles operations of each objects in the game and rendering processes.
 */
public class Game extends Canvas implements Runnable {

    private Thread thread;
    protected static boolean running = true;

    public static int WIDTH = 1000;
    public static int HEIGHT = WIDTH / 12 * 9;
    Handler handler;
    BufferedImage backImg = null;

    private Settler settler;
    private java.util.List<Robot> robots = new ArrayList<Robot>();
    private SunStorm sunStorm;

    public Game() {
        handler = new Handler();
        Settler settler = new Settler(300, 400);
        settler.setSpaceship(new SpaceShip());

        Asteroid a1 = new Asteroid(100, 500, null, 10);
        settler.setPlace(a1);
        System.out.println("setPlace(a1)");

        a1.addVisitor(settler);
        System.out.println("addVisitor(s1)");

        handler.addObject(new Asteroid(100, 200, new Carbon(), 10));
        System.out.println("addObject(a1)");
        System.out.println("addResource(r1)");
        handler.addObject(new Asteroid(400, 220, new Iron(), 10));
        System.out.println("addObject(a1)");
        System.out.println("addResource(r1)");
        handler.addObject(new Asteroid(600, 250, new WaterIce(), 10));
        System.out.println("addObject(a1)");
        System.out.println("addResource(r1)");
        handler.addObject(a1);
        System.out.println("addObject(a1)");
        System.out.println("addResource(r1)");

        handler.addObject(settler);
        System.out.println("addObject(s1)");

        this.addKeyListener(new KeyHandler(handler, this));

        new Window(WIDTH, HEIGHT, "Asteroid Mining", this);

        this.requestFocusInWindow();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running) {
                render();
            }

            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS:" + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        //System.out.println("Tick!");
        handler.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);

        try {
            backImg = ImageIO.read(new File("Assets/space.png"));
            //g.drawImage(backImg,0,0, WIDTH/2, HEIGHT/2, null);
            g.drawImage(backImg, 0, 0, this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //g.setColor(Color.black);
        //g.fillRect(0, 0, WIDTH, HEIGHT);

        g.drawString("Welcome to Asteroid-Mining!", 10, 10);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    /**
     * @author kasay
     */
    public void createSunStorm() {
        System.out.println("createSunstorm(10)   ~ System created sunstorm with fixed time 10 sec");

        SunStorm sunstorm = new SunStorm(0, 0, ID.SunStorm);
        handler.addObject(sunstorm);
        System.out.println("addObject(sunstorm)");

        sunstorm.setTime(0);
        System.out.println("setTime(t)");

        System.out.println("SunStorm is occurring. Do you want to hide?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            System.out.println("Please press the “H” key!");
        } else if (input.equals("no")) {
            System.out.println("Nothing has happened.");
        }

        for (GameObject obj : handler.objects)
            if (obj.getClass().getName().equals(Asteroid.class.getName()))
                sunstorm.collisionWith((Asteroid) obj);

        System.out.println("Are you there and not hidden?");
        sc = new java.util.Scanner(System.in);
        input = sc.nextLine();

        if (input.equals("yes")) {
            if (settler != null)
                settler.die();
            System.out.println("die()");
            System.out.println("See sequence diagram 5.3.12. “Losing the game”.");
        }
    }

    /**
     * @author kasay
     */
    public void determinePerihelion() {
        System.out.println("determinePerihelion()");

        System.out.println("h1.checkExplosiveAsteroids()");
        if (handler != null)
            handler.checkExplosiveAsteroids();

        for (GameObject obj : handler.objects) {
            if (obj.getClass().getName().equals(Asteroid.class.getName())) {
                boolean periheionOrNot = ((Asteroid) obj).isPerihelion();
                System.out.println("a1.isPerhelion(): bool");

                Resource resource = ((Asteroid) obj).getResource();
                System.out.println("a1.getResource(): Resource");
            }
        }

        System.out.println("Is it on perihelion, WaterIce and fullyDrilled?");
        System.out.println("yes (automatically checked by the system because none of user inputs are required)");
    }

    /**
     * @author kasay
     */
    public void endGame(){

    }

    public static void main(String args[]) {
        System.out.println("startGame()");
        Game game = new Game();
    }
}
