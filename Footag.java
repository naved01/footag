import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
        setSize(750, 500);
        setMinimumSize(new Dimension(360, 300));
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