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
            BufferedImage imageBuffer = ImageIO.read(file);
            int width = imageBuffer.getWidth();
            int height = imageBuffer.getHeight();
            double scale = determineImageScale(width, height, 800, 600);
            Image image = imageBuffer.getScaledInstance((int) (width * scale), (int) (height * scale), BufferedImage.SCALE_SMOOTH);
            
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
    
    private double determineImageScale(int sourceWidth, int sourceHeight, int targetWidth, int targetHeight) {
        double scalex = (double) targetWidth / sourceWidth;
        double scaley = (double) targetHeight / sourceHeight;
        return Math.min(scalex, scaley);
    }
}