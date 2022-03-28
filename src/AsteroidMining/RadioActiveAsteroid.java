package src.AsteroidMining;

public class RadioActiveAsteroid extends Asteroid {

    public RadioActiveAsteroid(int x, int y, Resource resource, int depth) {
        super(resource, depth);
    }

    public void explode(Handler handler){
        Visitor visitor = this.getVisitor();

        if(visitor.getId().equals(ID.Settler)){
            visitor.die();
        }
        else if(visitor.getId().equals(ID.Robot)){
            Asteroid a2 = (Asteroid) this.getNeighbours().get(0);
            a2.addVisitor(visitor);
            this.removeVisitor();
        }
        handler.removeObject(this);
    }
}
