package src.AsteroidMining;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game  {

    public ArrayList<Settler> settler;
    public ArrayList<Handler> handler;
    public ArrayList<Robot> robots;
    public ArrayList<Spaceship> spaceship;








//    private Thread thread;
//    protected static boolean running = true;
//
//    public Game(){
//
//        new Window(600, 500, "Sokoban", this);
//
//    }
//    public synchronized void start(){
//        thread = new Thread(this);
//        thread.start();
//        running = true;
//    }
//
//    public synchronized void stop() {
//        try {
//            thread.join();
//            running = false;
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        long lastTime = System.nanoTime();
//        double amountOfTicks = 60.0;
//        double ns = 1000000000/ amountOfTicks;
//        double delta = 0;
//        long timer = System.currentTimeMillis();
//        int frames = 0;
//
//        while(running) {
//            long now = System.nanoTime();
//            delta += (now- lastTime) / ns;
//            lastTime = now;
//
//            while(delta >= 1) {
//                tick();
//                delta--;
//
//            }
//            if(running) {
//                render();
//            }
//
//            frames++;
//
//            if(System.currentTimeMillis() - timer > 1000) {
//                timer += 1000;
//                //System.out.println("FPS:" + frames);
//                frames = 0;
//            }
//        }
//        stop();
//    }
//
//    private void tick() {
//        //System.out.println("Tick!");
//    }
//
//    public void render(){
//        BufferStrategy bs = this.getBufferStrategy();
//        if(bs==null) {
//            this.createBufferStrategy(3);
//            return;
//        }
//
//        Graphics g = bs.getDrawGraphics();
//
//        g.setColor(Color.black);
//        g.fillRect(0, 0, 600, 500);
//
//        g.setColor(Color.white);
//
//        g.drawString("Welcome!", 100, 200);
//
//        g.dispose();
//        bs.show();
//    }

    public static void main(String args[]){
//        Game game = new Game();


        System.out.println("Hello");
    }
}
