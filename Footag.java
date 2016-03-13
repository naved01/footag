import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Footag extends JFrame {
    
    public Footag() {            
        UI_init();
        
        ImageCollectionModel imageCollectionModel = new ImageCollectionModel();
        
        ImageCollectionView imageCollectionView = new ImageCollectionView(imageCollectionModel);
        imageCollectionModel.addObserver(imageCollectionView);
        Toolbar toolbar = new Toolbar(imageCollectionModel);
        imageCollectionModel.addObserver(toolbar);
        
        add(toolbar, BorderLayout.PAGE_START);
        add(imageCollectionView);
    }

    public void UI_init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(100, 100);
        setSize(700, 500);
        setLayout(new BorderLayout());
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