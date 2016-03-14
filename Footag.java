import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

//import javax.swing.JOptionPane;

public class Footag extends JFrame {
    
    ImageCollectionModel imageCollectionModel;
    ImageCollectionView imageCollectionView;
    JScrollPane pane;
    Toolbar toolbar;
    
    public Footag() {            
        
        UI_init();
   
        imageCollectionModel = new ImageCollectionModel();

        try {
            File loadedFile = new File("model.bin");
            ObjectInputStream obj_in = new ObjectInputStream(new FileInputStream(loadedFile));
            Object obj = obj_in.readObject();
            if (obj instanceof ImageCollectionModel) {
                ImageCollectionModel loadedModel = (ImageCollectionModel) obj;
                imageCollectionModel.loadModel(loadedModel);                                                    
            }
            obj_in.close();              
        } catch (Exception e) {
            System.out.println("error loading model");
        }
        
        imageCollectionView = new ImageCollectionView(imageCollectionModel);
        imageCollectionModel.addObserver(imageCollectionView);
        
        toolbar = new Toolbar(imageCollectionModel);
        imageCollectionModel.addObserver(toolbar);        
              
        add(toolbar, BorderLayout.PAGE_START);
        pane = new JScrollPane();
        pane.setViewportView(imageCollectionView);
        
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(pane);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    File file = new File("model.bin"); 
                    if (file.exists()) {
                        file.delete();
                    } 
                    ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream(file));
                    obj_out.writeObject(imageCollectionModel);
                    obj_out.close();                  
                } catch(Exception error) {         
                    System.out.println("error saving the file");
                    error.printStackTrace();
                }               

                Footag.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   
            }
        });   

    }
   
    public void UI_init() {
        setLocation(100, 100);
        setSize(800, 500);
        setMinimumSize(new Dimension(480, 300));
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