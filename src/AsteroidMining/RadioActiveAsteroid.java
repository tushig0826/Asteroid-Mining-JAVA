package src.AsteroidMining;
/*Initializing RadioActiveAsteroid*/
public class RadioActiveAsteroid extends Asteroid {

    public RadioActiveAsteroid(int x, int y, Resource resource, int depth) {
        super(resource, depth);
    }
    /*Radio active asteroid explode method, it can be called when asteroid is on perihelion*/
    /*public void explode(Handler handler){
        Visitor visitor = this.getVisitor();


        if(visitor.getId().equals(ID.Settler)){
            visitor.die();
        }
        else if(visitor.getId().equals(ID.Robot)){
            Asteroid a2 = (Asteroid) this.getNeighbour();
            a2.addVisitor(visitor);
            this.removeVisitor();
        }
        handler.removeObject(this);
    }*/
}
