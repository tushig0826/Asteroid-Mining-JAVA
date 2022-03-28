package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Settler extends Visitor{
    private List<TeleportationGate> gates;
    private SpaceShip spaceship;
    private Robot robot;

    public Settler(Handler handler) {

        super(ID.Settler);
        spaceship = new SpaceShip();
        this.handler = handler;

    }

    public boolean mine(){
        System.out.println("mine()");
        Asteroid a1 = (Asteroid) this.getPlace();
        if(a1.depth==0 && !a1.isHollow()){
            if(spaceship.checkCapacity()){
                spaceship.addResource(a1.getResource());
                a1.removeResource();
                return true;
            }
        }
        return false;

    }

    public boolean buildRobot(){
        System.out.println("buildRobot()");

            Place p=this.getPlace();
            int nIron = spaceship.countResource(ID.Iron);
            System.out.println("countResource(\"iron”): nIron");
            int nCarbon = spaceship.countResource(ID.Carbon);
            System.out.println("countResource(\"carbon”): nCarbon");
            int nUranium = spaceship.countResource(ID.Uranium);
            System.out.println("countResource(\"uranium”): nUranium");

            if(nIron >=1 && nCarbon >=1 && nUranium >=1){
                System.out.println("You have enough resources! Do you want to build a robot?");
                java.util.Scanner sc = new java.util.Scanner(System.in);
                String input = sc.nextLine();
                if (input.equals("yes")) {
                    robot = new Robot();

                    handler.addObject(robot);
                    System.out.println("addObject(r1)");
                    //inside addObject(robot) of Handler, it calls addVisitor(robot) of Asteroid
                    System.out.println("addVisitor(r1)");
                    this.getPlace().getNeighbours().get(2).addVisitor(robot);
                    System.out.println("Robots are automatically controlled by the system from now on.");
                    return true;
                }
            }
            else{
                System.out.println("You do not have enough resources!");
            }
            return false;
    }

    /*Filling the hollow asteroid with one unit of selected resource*/
    public boolean fillAsteroid() {
        System.out.println("FillAsteroid(Resource r)");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();
        Resource resource=null;
        switch(input.toLowerCase()){
            case "uranium": resource = new Uranium(); break;
            case "iron": resource = new Iron(); break;
            case "carbon": resource = new Carbon(); break;
            case "waterIce": resource = new WaterIce(); break;
        }
        if(!resource.equals(null)) {
            Asteroid a1 = (Asteroid) this.getPlace();
            if (a1.isHollow()) {
                if (spaceship.removeResource(resource)) {
                    a1.addResource(resource);
                    System.out.println("a1.addResource(resource)");
                    return true;
                }
            }
        }
        return false;
    }
    public void checkInventory(){
        System.out.println("checkInventory()");
        for(Resource r: spaceship.resources.keySet()){
            System.out.println("SpaceShip's inventory:");
            System.out.println(r.getType() + spaceship.resources.get(r));
        }
    }


    public boolean buildTeleportationGates(){
        System.out.println("buildRobot()");

        Place p=this.getPlace();
        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nWaterIce = spaceship.countResource(ID.WaterIce);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");

        if(nIron >=2 &&  nWaterIce>=1 && nUranium >=1){
            System.out.println("You have enough resources! Do you want to build a teleportation gates?");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("yes")) {
                TeleportationGate gate1 = new TeleportationGate();
                TeleportationGate gate2 = new TeleportationGate();
                gates.add(gate1);
                System.out.println("addGate()");
                gates.add(gate2);
                System.out.println("addGate()");

                return true;
            }
        }
        else{
            System.out.println("You do not have enough resources!");
        }
        return false;
    }

    public void deployGate(){
        System.out.println("deployGate()");
        if(gates.size()==2){
            gates.get(0).setGate(gates.get(1));
            gates.get(1).setGate(gates.get(0));
            System.out.println("setGate(gate1) -- setGate(gate2)");
            this.getPlace().addNeighbour(gates.get(0));
            System.out.println("addNeighbour(gate1)");
            System.out.println("First gate deployed successfully!");
        }
        else if(gates.size() == 1){
            this.getPlace().addNeighbour(gates.get(1));
            System.out.println("addNeighbour(gate2)");
            System.out.println("Second gate deployed successfully!");
        }
    }

}
