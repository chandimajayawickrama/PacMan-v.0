import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {

    volatile String message;
    HashMap <String,String> session;  // HashMap to store the sesson ID and the player name
    HashMap <String,Player> player = new HashMap<>(); // HashMap to store the session ID with the corresponding player.

    //Create the GameBoard 
    GameBoard g = new GameBoard();
    HashMap<Integer,Dots> h = g.createBoard();

    final Random rand =new Random();
    
    // Create 4 players with  positions and scores
    Player p1 = new Player("P1",0,0,0); 
    Player p2 = new Player("P2",0,100,0);
    Player p3 = new Player("P3",0,0,100);
    Player p4 = new Player("P4",0,100,100);
   
    Player p;
  
    @Override
    public void init(ServletConfig config) {
        session = new HashMap<>();
        session.put("P1", null);
        session.put("P2", null);
        session.put("P3", null);
        session.put("P4", null);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession();
        // check whether a sessio is new
        if(sess.isNew()){
            if(session.get("P1") == null){ // Check whether the value of "P1" in session hashmap null
                session.put("P1", sess.getId()); // Put the session ID as the value of "P1"
                player.put(sess.getId(), p1);
            }
            
            else if(session.get("P2")==null){// Check whether the value of "P2" in session hashmap null
               session.put("P2", sess.getId());// Put the session ID as the value of "P1"
                player.put(sess.getId(), p2);

            }
            
           else if(session.get("P3")==null){// Check whether the value of "P3" in session hashmap null
               session.put("P3", sess.getId());// Put the session ID as the value of "P1"
                player.put(sess.getId(), p3);

            }
            
           else if(session.get("P4")==null){// Check whether the value of "P4" in session hashmap null
               session.put("P4", sess.getId());// Put the session ID as the value of "P1"
                player.put(sess.getId(), p4); 

            }
            
        }
       
            p = player.get(sess.getId());
       
            synchronized (this) {
                message = request.getReader().readLine(); //Get the key stroke 
                p = p.updatePlayer(p, message); // Update the state of the player
                String color = g.updateGameBoard(p);
                p = p.updateMarks(color, p);
                //p.isCollision(p1, p);
                notifyAll();
                Logger.getGlobal().log(Level.INFO, "Received "+message);
            }
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        

        try (final PrintWriter out = response.getWriter()) {
         
            while (!Thread.interrupted()) {
                
                Logger.getGlobal().log(Level.INFO, "Sent " + message);
                
                String obj2 = g.toString();
                String obj1 = "\"PLAYERS\":["+p1.toString()+","+p2.toString()+","+p3.toString()+","+p4.toString()+"]";
                String obj = "{"+obj2+","+obj1+"}";
                
                synchronized (this) {
                   
                    out.print("data: ");
                    out.println(obj);
                    out.println();
                    out.flush();
                    wait();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getGlobal().log(Level.INFO, "Exiting");
        }
    }
}
