package src.AsteroidMining;

public class RadioActiveAsteroid extends Asteroid {

    public RadioActiveAsteroid(int x, int y, Resource resource, int depth) {
        super(x, y, resource, depth);
    }

    /**
     * @author kasay
     */
    public void explode() {
        System.out.println("explode()");

        System.out.println("Is it on perihelion?");
        System.out.println("yes (automatically checked by the system because none of user inputs are required)");

        Visitor visitor = this.getVisitor();
        System.out.println("ra1.getVisitor(): v1");

        System.out.println("Are you there?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            if (visitor != null)
                visitor.die();
            System.out.println("die()");
            System.out.println("See sequence diagram 5.3.12. “Losing the game”.");
        }
    }
}
