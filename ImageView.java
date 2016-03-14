import java.util.Observer;
import java.util.Observable;
import java.io.File;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class ImageView extends JPanel implements Observer {
    
    ImageModel model;
    File file;
    Image thumbnail;
    JLabel thumbnailImg;
    JLabel name;
    ImageCollectionModel.LayoutType layout;
    JLabel date;
    JPanel metadata;
    JLabel rate;
    RatingPanel ratingPanel;
    
    public int getRating() {
        return model.getRating();
    }
    
    public void setCurrentLayout(ImageModel.LayoutType layout) {
        this.layout = layout;
        if (layout == ImageModel.LayoutType.GRID_LAYOUT) {
            setBorder(BorderFactory.createEmptyBorder(10,10,10,10));           
            setLayout(new BoxLayout(ImageView.this, BoxLayout.Y_AXIS));
            setPreferredSize(new Dimension(300, 220));
        } else if (layout == ImageModel.LayoutType.LIST_LAYOUT) {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setPreferredSize(new Dimension(380, 180));
            setMaximumSize(new Dimension(800, 180));
        }
    }
    
    ImageView(ImageModel model_) {

        model = model_;
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));        

        file = new File(model.getPath());
        try {
            thumbnail = ImageIO.read(file).getScaledInstance(150, 150, BufferedImage.SCALE_SMOOTH);
            thumbnailImg = new JLabel();
            thumbnailImg.setIcon(new ImageIcon(thumbnail));
            thumbnailImg.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                  JFrame imageFrame =  new ImageFrame(model.getPath());
                }
            });
        }
        catch (IOException error) {
            error.printStackTrace();
        }
        
        
        name = new JLabel(model.getName());
        date = new JLabel(model.getCreationDate());
        thumbnailImg.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(thumbnailImg);
        metadata = new JPanel();
        metadata.setLayout(new BoxLayout(metadata, BoxLayout.Y_AXIS));
        metadata.setAlignmentX(Component.CENTER_ALIGNMENT);
        metadata.add(name);
        metadata.add(date);
        
        add(metadata);
        ratingPanel = new RatingPanel(model);
        model.addObserver(ratingPanel);
        add(ratingPanel);
        
        setCurrentLayout(model.getLayout());
    }

    @Override 
    public void update(Observable o, Object obj) {
        setCurrentLayout(model.getLayout());
    }
    
}