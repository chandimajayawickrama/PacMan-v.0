import java.text.*;
import java.util.*;
import java.util.logging.*;

public class Players {
    

    public int x;
    public int y;
    public int marks;
    public Random rand = new Random();
    String player;
    //public HashMap<String,Integer[]> player;
    
//    
    Players(String player,int marks,int x, int y){
        this.marks = marks;
        this.x = x;
        this.y = y;
        this.player = player;
    
    }
   
    Players(){
    }

    // Update the players position 
    public Players updatePlayer(Players p,String keyStroke){
        if(keyStroke.equals("ArrowUp")){
            y++;
           
        }
        if(keyStroke.equals("ArrowDown")){
            y--;
            
        }
        if(keyStroke.equals("ArrowRight")){
            x++;
        }
        
        if(keyStroke.equals("ArrowLeft")){
            x--;
        }
    return p;
    }
    
    
    @Override
    public String toString(){
        return "["+"player"+","+marks+","+x+","+y+"]";
    }

    public static void main(String [] args){

        Players p1 = new Players("P1",0,0,0);
        Players p2 = new Players("P2",0,0,0);
        Players p3 = new Players("P3",0,0,0);
        Players p4 = new Players("P4",0,0,0);

         p1.updatePlayer(p1, "ArrowUp");
         p1.updatePlayer(p1, "ArrowLeft");
         
         String play = "["+"\"PLAYERS \":"+p1.toString()+","+p2.toString()+","+p3.toString()+","+p4.toString()+"]";
         String obj2 = "\"DOTS\":"+"[ ["+"\"B\""+","+4+","+4+"],["+"\"R\""+","+5+","+5+"] ]";
         String obj = "{"+obj2+","+play+"}";
         System.out.println(obj);
                
    }
}