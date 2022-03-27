package src.AsteroidMining;

import java.awt.*;

public abstract class GameObject {

    protected int x,y, nextDestX, nextDestY, velX=0, velY=0;
    protected int width, height, vel, gap;

    private ID id;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
        //this.nextDestY =y;
       // this.nextDestX = x;
    }
    public abstract void tick();

    public abstract void render(Graphics g);

    public Rectangle getBounds(){

        return new Rectangle(x, y, width, height);
    }
    public boolean checkForCollision(GameObject obj1){
        if(!obj1.equals(this) && obj1.getBounds().intersects(this.getBounds())) {
            //this.x-=gap;
            //this.y-=gap;
            System.out.println(this.getBounds() + " intersects " + obj1.getBounds());
            vel=0;
            return false;
        }
        return true;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public void setVelX(int vx){
        if(vx>0) this.gap = vx;
        this.velX = vx;
    }
    public int getVelX(int vx){
        return this.velX;
    }

    public void setVelY(int vy){
        if(vy>0)this.gap = vy;
        this.velY = vy;
    }
    public int getVelY(int vx){
        return this.velY;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId(){
        return this.id;
    }
    public void setNextDestX(int nx){
        this.nextDestY=nx;
    }
    public void setNextDestY(int ny){
        this.nextDestY = ny;
    }
}
