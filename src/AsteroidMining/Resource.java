package src.AsteroidMining;

/**
 * This class is a parent class to four different resources- uranium, iron, carbon and water ice. It
 * contains the attribute type, that indicates the name/type, and a method to access that name and
 * have it returned as a string.
 */
public class Resource {
    private String type;

    /**
     * @author kasay
     */
    public Resource() {
        type = this.getClass().getName().toLowerCase();
    }

    /**
     * @author kasay
     */
    public String getType() {
        return type;
    }
}
