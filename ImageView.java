import java.util.Observer;
import java.util.Observable;
import java.io.File;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class ImageView extends JPanel implements Observer {
    
    ImageModel model;
    File file;
    Image thumbnail;
    JLabel thumbnailImg;
    JLabel name;
    JLabel date;
    JPanel metadata;
    JLabel rate;
    RatingPanel ratingPanel;
    
    public int getRating() {
        return model.getRating();
    }
    
    ImageView(ImageModel model_) {
        
        setPreferredSize(new Dimension(350, 120));
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));        
        model = model_;

        file = new File(model.getPath());
        try {
            thumbnail = ImageIO.read(file).getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
            thumbnailImg = new JLabel();
            thumbnailImg.setIcon(new ImageIcon(thumbnail));
        }
        catch (IOException error) {
            error.printStackTrace();
        }
        
        name = new JLabel(model.getName());
        date = new JLabel(model.getCreationDate());
        
        add(thumbnailImg);
        metadata = new JPanel();
        metadata.setLayout(new BoxLayout(metadata, BoxLayout.Y_AXIS));
        metadata.add(name);
        metadata.add(date);
        
        add(metadata);
        ratingPanel = new RatingPanel(model);
        model.addObserver(ratingPanel);
        add(ratingPanel);
    }

    @Override 
    public void update(Observable o, Object obj) {
    }
    
}