package src.AsteroidMining;

import java.awt.*;
import java.util.AbstractList;

/**
 * The Visitor class is a parent class of Settler and Robot classes, since they share many attributes
 * and features. It stores information about the asteroid the visitor is currently on (place), whether
 * the visitor is hidden in a hollow asteroid, and if it is alive at all. It contains methods responsible
 * for traveling, drilling, mining, and getting and setting the place of each visitor.
 */
public abstract class Visitor extends GameObject {

    private boolean alive = true;
    private boolean hidden = false;
    private Place place;

    //unit velocity for visitors (i.e. settler and robot)
    private final int vel = 5;

    //unit depth to deepen the hole
    private final int deepen = 1;

    public Visitor(int x, int y, ID id) {
        super(x, y, id);
    }

    /*
     * This function is overridden by derived class.
     * This function is called for updating the information.
     */
    public abstract void tick();

    /*
     *
     */
    public abstract void render(Graphics g);

    /**
     * @author kasay
     */
    public boolean travel(Direction d) {
        System.out.println("\ntravel()");

        Place p1 = this.getPlace();
        System.out.println("getPlace(): p1");

        java.util.AbstractList<Place> places = (AbstractList<Place>) p1.getNeighbours();
        System.out.println("getNeighbours(): places");

        switch (d) {
            case UP:
                this.setVelY(-vel);
                break;
            case DOWN:
                this.setVelY(vel);
                break;
            case LEFT:
                this.setVelX(-vel);
                break;
            case RIGHT:
                this.setVelX(vel);
                break;
        }

        return true;
    }

    /**
     * @author kasay
     */
    public boolean drill() {
        System.out.println("\ndrill()");

        Place p1 = this.getPlace();
        System.out.println("getPlace(): a1");

        //if the current place is not Asteroid, then returns false
        if (!p1.getClass().getName().equals(Asteroid.class.getName()))
            return false;

        Asteroid a1 = (Asteroid) this.getPlace();

        //checks if the depth is greater than 0
        //if(a1.depth>0)
        System.out.println("Is depth greater than 0?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            a1.deepenHole(deepen);
            System.out.println("deepenHole(1)");

            return true;
        }

        return false;
    }

    public Place getPlace() {
        return this.place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    /**
     * @author kasay
     */
    public boolean hide() {
        System.out.println("\nhide()");

        Place p1 = this.getPlace();
        System.out.println("getPlace(): a1");

        //if the current place is not Asteroid, then returns false
        if (!p1.getClass().getName().equals(Asteroid.class.getName()))
            return false;

        Asteroid a1 = (Asteroid) this.getPlace();

        //checks if hollow or not
        System.out.println("a1.isHollow(): bool");
        System.out.println("Is this asteroid hollow?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            hidden = true;
            System.out.println("isHidden = true");
            System.out.println("Succeeded to hide.");

            return true;
        } else if (input.equals("no")) {
            hidden = false;
            System.out.println("isHidden = false");
            System.out.println("Failed to hide.");

            return false;
        }
        return false;
    }

    public boolean isHidden() {
        return hidden;
    }

    /**
     * @author kasay
     */
    public boolean die() {
        return false;
    }
}
