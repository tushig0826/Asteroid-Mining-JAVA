package src.AsteroidMining;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Game{
    //"Skeleton Code:"

    Handler handler; /*handler of the game*/

    Settler settler;
    HashMap<Resource, Integer> nResources;
    SunStorm sunStorm;


    public Game(){
        handler = new Handler();
        nResources = new HashMap<Resource, Integer>();
        nResources.put(new Carbon(), 1);
        nResources.put(new Iron(), 1);
        nResources.put(new Uranium(), 1);
        nResources.put(new WaterIce(), 1);


    }
    public void startGame(){
        /*Initializing the settler*/
        settler = new Settler(handler);

        /*Initializing the Asteroids*/

        for(Resource r: nResources.keySet()){
            int num = nResources.get(r);
            while(num>0){
                handler.addObject(new Asteroid(r, 10));
                num--;
            }
        }
        Asteroid a1 = new Asteroid(null, 10);
        a1.addVisitor(settler);
        handler.addObject(a1);
        handler.generateNbrs();

        System.out.println("Asteroid belt is created successfully!");
        System.out.println("Asteroids were added!");

    }
    /*Ending the game, exittting*/
    public void endGame(){
        System.out.println("Game Over");
        System.exit(1);
    }

    /*Creating sunstorm for fixed time*/
    public void createSunStorm(int time){
        sunStorm = new SunStorm(time);
        for(GameObject obj : handler.objects){
            if(obj instanceof Place){
               Asteroid a1 = (Asteroid) obj;
                sunStorm.collisionWith(a1);
                System.out.println("collisionWith(a1)");
                }
            }
    }

    public void determinePerihelion() {
        System.out.println("determinePerihelion()");

        if(handler!=null){
            handler.checkAsteroids();
        }

    }





    public static void main(String args[]){

         boolean running = false;

        java.util.Scanner sc = new java.util.Scanner(System.in);
        Game game = new Game();

        System.out.println("StartGame()      Enter: 'S' character");
        System.out.println("EndGame()        Enter: 'X' character");
        String input = sc.nextLine();
        if(input.toLowerCase().equals("s")){
            game.startGame();
            running = true;
        }
        else if(input.toLowerCase().equals("x"))
            game.endGame();

        if(running) {
            System.out.println("Game has been started!" +
                    "You can check test cases one by one enter corresponding Key \n" +
                    "1. Settler Travel -> 'AWSD'\n" +
                    "2. Settler Drill -> 'D'\n" +
                    "3. Settler Mine-> 'M'\n" +
                    "4. Settler Hide-> 'H'\n" +
                    "5. Fill Asteroid-> 'F'\n" +
                    "6. Check Inventory-> 'C'\n" +
                    "7. Build Robot-> 'B'\n" +
                    "8. Build Teleportation Gate-> 'T'\n" +
                    "9. Deploy Gate-> 'G'\n" +
                    "10. Sunstorm occurs-> 'SS'\n" +
                    "11. Asteroid Explosion-> 'AE'\n");
        }

        /*Running loop of the concole screen*/
        while(running){

            input = sc.nextLine();
            switch(input.toUpperCase()){
                case "A":
                    game.settler.travel();break;
                case "D":
                    if(!game.settler.drill()) System.out.println("You can't drill!"); ;break;
                case "M":
                    if(game.settler.mine()) System.out.println("Mined the asteroid successfully!");break;
                case "H":
                    if(game.settler.hide()) System.out.println("Settler is hidden!");break;
                case "F":
                    if(game.settler.fillAsteroid()) System.out.println("Filled Asteroid Successfully");break;
                case "C":
                    game.settler.checkInventory(); break;
                case "B":
                    if(game.settler.buildRobot()) System.out.println("You cannot build robot!"); break;
                case "G":
                    if(game.settler.buildTeleportationGates()) System.out.println("You cannot build teleporation gates"); break;
                case "SS":
                    game.createSunStorm(10);break;
                case "AE":
                    game.determinePerihelion(); break; //
            }
        }


    }
}
