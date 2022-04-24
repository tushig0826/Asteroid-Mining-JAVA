package src.AsteroidMining;
/*Initializing Resource*/
public class Resource extends GameObject{
    protected String type;
    /*Constructing the resource*/
    public Resource(ID id){super(id);}
    /*Getting the type of the resource*/
    public String getType(){ return this.type;}

}
