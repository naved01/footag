import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Footag extends JFrame {
    
    public Footag() {      
       
        UI_init();
        
        Toolbar toolbar = new Toolbar();
        setLayout(new BorderLayout());
        add(toolbar);
       
    }

    public void UI_init() {
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