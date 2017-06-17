
import java.util.Random;
/*This class is to create a player*/
public class Player {
    
    public int x;
    public int y;
    public int marks;
    public String player;

    final Random rand =new Random();
    
    
    Player(String player,int marks,int x, int y){
        this.marks = marks;
        this.x = x;
        this.y = y;
        this.player = player;
    }
   
    Player(){
    }
   

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
    
    
    // Update the players position 
    public  Player updatePlayer(Player p,String keyStroke){
        if(keyStroke.equals("ArrowUp")){
            this.y++;
            if(this.y>100){
              this.y= 0;  
            }
           
        }
        if(keyStroke.equals("ArrowDown")){
            this.y--;
            if(this.y<0){
                this.y= 99;
            }
            
        }
        if(keyStroke.equals("ArrowRight")){
            this.x++;
            if(this.x>100){
                this.x = 0;
            }
        }
        
        if(keyStroke.equals("ArrowLeft")){
            this.x--;
            if(this.x<0){
                this.x = 99;
            }
        }
    return p;
    }
    
    //Update the players marks
    public Player updateMarks(String color,Player p){
        int marks = p.getMarks();
        if(color.equals("R")){
            marks = marks+1;
        }
        
        if(color.equals("G")){
            marks = marks+2;
        }
        
        if(color.equals("B")){
            marks = marks+4;
        }
        
        p.setMarks(marks);
    
    return p;
    }
    
    // Check for player collisions
    public void isCollision(Player[] p1, Player p){
        int marks = p.getMarks(),x =p.getX(),y=p.getY();
        String pos1 = p.getPlayer();
        for(int i=0;i<4;i++){
            if(!p1[i].getPlayer().equals(p.getPlayer())){
                if(p.getX()==p1[i].getY() && p.getY()==p1[i].getY()){
                    marks = marks-3;
                }
            }
            
            if(pos1.equals("P1")){
                p.setX(0);
                p.setY(0);
            }
            
            if(pos1.equals("P2")){
                p.setX(100);
                p.setY(0);
            }
            
            if(pos1.equals("P3")){
                p.setX(0);
                p.setY(100);
            }
            
           if(pos1.equals("P4")){
                p.setX(100);
                p.setY(100);
            }
            
        
        }
   
    }
    
    // Return the string of a player's details
    @Override
    public String toString(){
        char c = '"';
        return "["+c+this.player+c+","+this.marks+","+this.x+","+this.y+"]";
    }

    
}
