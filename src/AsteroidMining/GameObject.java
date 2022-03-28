package src.AsteroidMining;

import java.awt.*;

public class GameObject {

    protected ID id;

    public GameObject(ID id){
        this.id = id;

    }


    public ID getId(){
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
