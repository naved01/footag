import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observer;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class RatingPanel extends JPanel implements Observer {
    
    JLabel heart1;
    JLabel heart2;
    JLabel heart3;
    JLabel heart4;
    JLabel heart5;
    JLabel refresh;
    Model model;

    public RatingPanel(Model model_) {
        
        model = model_;
        
        initUI();
      
        updateIcons();
       
        add(heart1);
        add(heart2);
        add(heart3);
        add(heart4);
        add(heart5);   
        add(refresh);                   
    }
    
    private void initUI() {
        heart1 = new JLabel();
        heart1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setRating(1);
            }
        });      
        
        heart2 = new JLabel();
        heart2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setRating(2);
            }
        });
                
        heart3 = new JLabel();
        heart3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setRating(3);
            }
        });
                
        heart4 = new JLabel();
        heart4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setRating(4);
            }
        });
                
        heart5 = new JLabel();
        heart5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setRating(5);
            }
        });
        
        refresh = new JLabel(new ImageIcon("refresh.png"));
        refresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setRating(0);
            }
        });        
                
    }
    
    private void updateIcons() {
        if (model.getRating() >= 1) {
            heart1.setIcon(new ImageIcon("filledHeart.png"));
        } else {
            heart1.setIcon(new ImageIcon("emptyHeart.png"));
        }

        if (model.getRating() >= 2) {
            heart2.setIcon(new ImageIcon("filledHeart.png"));
        } else {
            heart2.setIcon(new ImageIcon("emptyHeart.png"));
        }
        
        if (model.getRating() >= 3) {
            heart3.setIcon(new ImageIcon("filledHeart.png"));
        } else {
            heart3.setIcon(new ImageIcon("emptyHeart.png"));
        }
        
        if (model.getRating() >= 4) {
            heart4.setIcon(new ImageIcon("filledHeart.png"));
        } else {
            heart4.setIcon(new ImageIcon("emptyHeart.png"));
        }
        
        if (model.getRating() == 5) {
            heart5.setIcon(new ImageIcon("filledHeart.png"));
        } else {
            heart5.setIcon(new ImageIcon("emptyHeart.png"));
        }
    }
    
    public void update(Observable o, Object obj) {
        updateIcons();
    }
        
}