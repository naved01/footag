import java.io.IOException;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

public class ImageFrame extends JFrame {
    
    public ImageFrame(String path) {            
        
        UI_init();
        
        try {
            File file = new File(path);
            Image image = ImageIO.read(file).getScaledInstance(800, 600, BufferedImage.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            add(imageLabel);
        } catch (IOException error) {
            error.printStackTrace();
        }
        
    }

    public void UI_init() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(100, 100);
        setSize(800, 600);
        setTitle("original image");
        setVisible(true);         
    } 
}