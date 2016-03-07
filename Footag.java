import javax.swing.JFrame;
import java.awt.EventQueue;

public class Footag extends JFrame {
    
    public Footag() {
       setUI();
    }

    public void setUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(700, 500);
        setTitle("footag");
        setVisible(true);         
    } 
    
    /* Main method */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Footag footag = new Footag();
            } 
        });        
    }
}