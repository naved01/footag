import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements Observer {
    
    ImageCollectionModel model;
    JLabel titleLabel, filterByLabel, jLabel1;
    JPanel setLayoutPanel, starsPanel, titlePanel;
    JButton setGridLayoutButton, setListLayoutButton, ratingStar, load;
    
    Toolbar(ImageCollectionModel model_ ) {

        model = model_;

        setPreferredSize(new Dimension(700, 40));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));

        load = new JButton("load");
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JFileChooser jf = new JFileChooser();
                jf.setDialogTitle("choose your file");
                jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnVal = jf.showOpenDialog(Toolbar.this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = jf.getSelectedFile();
                    ImageModel imageModel = new ImageModel(file);
                    model.addImage(imageModel);
                }
            }
        });
        
        ratingStar = new JButton("star");        
        setGridLayoutButton = new JButton("Grid");

        setGridLayoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setLayout(ImageCollectionModel.LayoutType.GRID_LAYOUT);
            }
        });
        
        setListLayoutButton = new JButton("List");
        setListLayoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {   
                model.setLayout(ImageCollectionModel.LayoutType.LIST_LAYOUT);
            }
        });     
        
        titleLabel = new JLabel("Fotag!");
        filterByLabel = new JLabel("Filter by: ");

        setLayoutPanel = new JPanel();
        setLayoutPanel.add(setGridLayoutButton);
        setLayoutPanel.add(setListLayoutButton);
        setLayoutPanel.add(load);
        this.add(setLayoutPanel, BorderLayout.LINE_START);
        
        starsPanel = new JPanel();
        starsPanel.add(filterByLabel);
        starsPanel.add(ratingStar);
        this.add(starsPanel, BorderLayout.LINE_END);
        
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.add(titlePanel, BorderLayout.CENTER);      
    }
    
    @Override
    public void update(Observable o, Object obj) {
        /* changes to the UI when model is changed */
    }
    
}