package src.AsteroidMining;

import java.awt.*;
/*Initializing GameObject for setting and getting identifier*/
public class GameObject {

    protected ID id;

    public GameObject(ID id){
        this.id = id;

    }

    /*Getting the identifier of the object*/
    public ID getId(){
        return this.id;
    }
    /*Setting the identifier of the object*/
    public void setId(ID id) {
        this.id = id;
    }
}
