import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.swing.JCheckBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements Observer {
    
    ImageCollectionModel model;
    JLabel titleLabel;
    JPanel setLayoutPanel, titlePanel;
    JCheckBox filterEnabled;
    JButton setGridLayoutButton, setListLayoutButton, load;
    private	ImageIcon gridIcon, listIcon, loadIcon;
    RatingPanel filterPanel;
    
    Toolbar(ImageCollectionModel model_ ) {

        model = model_;

        setPreferredSize(new Dimension(700, 50));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.black));

        loadIcon = new ImageIcon("load.png");
        load = new JButton(loadIcon);
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
        
        gridIcon = new ImageIcon("grid.png");
        setGridLayoutButton = new JButton(gridIcon);
                
        setGridLayoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setLayout(ImageCollectionModel.LayoutType.GRID_LAYOUT);
            }
        });
        
        listIcon = new ImageIcon("list.png");
        setListLayoutButton = new JButton(listIcon);
        setListLayoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {   
                model.setLayout(ImageCollectionModel.LayoutType.LIST_LAYOUT);
            }
        });     
        
        titleLabel = new JLabel("Fotag!");
        filterEnabled = new JCheckBox("filter");
        filterEnabled.setSelected(true);
        filterEnabled.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.err.println(e.getStateChange());
                if (e.getStateChange() == 1) {
                    model.setFilterEnabled(true);
                } else {
                    model.setFilterEnabled(false);
                }           
            }
        });

        setLayoutPanel = new JPanel();
        setLayoutPanel.add(setGridLayoutButton);
        setLayoutPanel.add(setListLayoutButton);
        setLayoutPanel.add(load);
        this.add(setLayoutPanel, BorderLayout.LINE_START);
        
        filterPanel = new RatingPanel(model);
        model.addObserver(filterPanel);
        JPanel p = new JPanel();
        p.add(filterPanel);
        p.add(filterEnabled);
        this.add(p, BorderLayout.LINE_END);
        
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.add(titlePanel, BorderLayout.CENTER);      
    }
    
    @Override
    public void update(Observable o, Object obj) {
        
        if (model.isFilterEnabled() && filterPanel.isVisible() == false ) {
            filterPanel.setVisible(true);
        } else if (!model.isFilterEnabled() && filterPanel.isVisible() == true) {
            filterPanel.setVisible(false);
            model.setRating(0);
        }
        revalidate();
        repaint();
    }
    
}