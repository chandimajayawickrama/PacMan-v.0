/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * This class is to generate dots for the Position of Foods
 */
public class Dots {
    
    public int x;
    public int y;
    public String color;
    
    Dots( String color,int x, int y){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public int getX(){
        return x;
    }
    
    public void setX(int x){
        this.x =x;
    }
    
    public int  getY(){
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
}
