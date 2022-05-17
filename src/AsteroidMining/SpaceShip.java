package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
/*Initializing SpaceShip*/
public class SpaceShip extends GameObject{

    private int capacity=10; /*SpaceShip's max capacity*/
    private int currentInventory=0;

    HashMap<Resource, Integer> resources = new HashMap<Resource, Integer>();
    BufferedImage img=null;

    public SpaceShip() {
        super(ID.Inventory);
        try{
            img = ImageIO.read(new File("Assets/inventory.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) throws IOException {
        int i = 0;
        g.setColor(Color.YELLOW);
        g.drawLine(70, 670, 500, 670);

        g.drawImage(img, 30, 630, 30,30, null);
        for(Resource r: resources.keySet()){
            g.drawImage(r.getImg(), 70+i, 630, 30,30, null);
            i+=45;
        }
    }

    /*adding resource to the inventory*/
    public boolean addResource(Resource r){
        int num=0;
        if(currentInventory<capacity) {
            if(resources.containsKey(r)) {
                num = resources.get(r);
                resources.put(r, num + 1);

            }
            else {
                resources.put(r, 1);
            }
            currentInventory++;
            return true;
        }
        else return false;

    }
    /*removing resource from the inventory*/
    public boolean removeResource(Resource r){
        if(resources.containsKey(r)){
            resources.remove(r, 1);
            currentInventory--;
            return true;
        }
        return false;
    }
    public boolean removeResource(ID id, int num){
        Resource r = getResource(id);
        if(resources.containsKey(r)){
            resources.remove(r, num);
            currentInventory--;
            return true;
        }
        return false;
    }
    /*Counting resource of the inventory*/
    public int countResource(ID id){ /*Counts the resource from the inventory return amount if there is, otherwise 0*/
        for(Resource r : resources.keySet()){
            if(r.getId().equals(id))
                return resources.get(r);
        }
        return 0;
    }
    public Resource getResource(ID id){
        if(countResource(id)>0)
            for(Resource r : resources.keySet())
                if(r.getId().equals(id))
                    return r;
        return null;
    }
    /*Checking the capacity of inventory*/
    public boolean checkCapacity(){
        if(currentInventory<=capacity)
            return true;
        return false;
    }


}
