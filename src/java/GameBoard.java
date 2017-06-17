
import java.util.HashMap;
import java.util.Random;

/**
 *
 * \This class is to create the GameBoard 
 */
public class GameBoard extends Thread{

    HashMap <Integer,Dots> board = new HashMap<>(); // Store the dots in the GameBoard
   
    GameBoard(){
    }

    //Create a Gameboard with randomly generated points
    public HashMap<Integer,Dots> createBoard(){

        Random rand =new Random();

        String color = "null";
        for(int i = 0;i<12;i++){
            int x,y;
            Dots d = new Dots("null",0,0);
             x = rand.nextInt(100);
             y= rand.nextInt(100);

            if(x<0 && x<=60){
                color = "R";
            }

            if(x<60 && x<=80){
                color = "G";
            }

            if(x>80){
                color = "B";
            }

            if(color.equals("null")){
                color = "R";
            }

            d.setX(x);
            d.setY(y);
            d.setColor(color);
            board.put(i, d);
        }

        return board;
    }

    //Update the gameBoard
    public String updateGameBoard(Player p){
        int x = p.getX();
        int y = p.getY();
        String color ="";
        
        for(int i=0;i<12;i++){
            if(board.get(i).getX()==x && board.get(i).getY()==y){
                color = board.get(i).getColor();
                
            }
        }
    
    
        return color;
    }

    // Return the string of the dots in the GameBoard
    @Override
    public String toString(){
        String obj1;
        char c = '"';
        obj1 = "\"DOTS\":"+"[ ["+c+board.get(0).getColor()+c+","+board.get(0).getX()+","+board.get(0).getY()+"],["+c+board.get(1).getColor()+c+","+board.get(1).getX()+","+board.get(1).getY()+"],["+c+board.get(2).getColor()+c+","+board.get(2).getX()+","+board.get(2).getY()+"]"+",["+c+board.get(3).getColor()+c+","+board.get(3).getX()+","+board.get(3).getY()+"]"+",["+c+board.get(4).getColor()+c+","+board.get(4).getX()+","+board.get(4).getY()+"]"+",["+c+board.get(5).getColor()+c+","+board.get(5).getX()+","+board.get(5).getY()+"]"+",["+c+board.get(6).getColor()+c+","+board.get(6).getX()+","+board.get(6).getY()+"]"+",["+c+board.get(7).getColor()+c+","+board.get(7).getX()+","+board.get(7).getY()+"]"+",["+c+board.get(8).getColor()+c+","+board.get(8).getX()+","+board.get(8).getY()+"]"+",["+c+board.get(9).getColor()+c+","+board.get(9).getX()+","+board.get(9).getY()+"]"+",["+c+board.get(10).getColor()+c+","+board.get(10).getX()+","+board.get(10).getY()+"]"+",["+c+board.get(11).getColor()+c+","+board.get(11).getX()+","+board.get(11).getY()+"] ]";
        return obj1;
    }




}
