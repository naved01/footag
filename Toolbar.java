import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font; 

public class Toolbar extends JPanel implements Observer {
    
    ImageCollectionModel model;
    JLabel titleLabel;
    JPanel setLayoutPanel, titlePanel;
    JToggleButton setGridLayoutButton, setListLayoutButton;

    JButton load;
    private	ImageIcon gridIcon, listIcon, loadIcon;
    RatingPanel filterPanel;
    
    Toolbar(ImageCollectionModel model_ ) {

        model = model_;

        setPreferredSize(new Dimension(700, 50));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        loadIcon = new ImageIcon("load.png");
        load = new JButton(loadIcon);
        load.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JFileChooser jf = new JFileChooser();
                jf.setDialogTitle("choose your file");
                jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jf.setMultiSelectionEnabled(true);
                int returnVal = jf.showOpenDialog(Toolbar.this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File[] files = jf.getSelectedFiles();
                    for (int i = 0; i < files.length; i++) {
                        ImageModel imageModel = new ImageModel(files[i]);
                        model.addImage(imageModel);
                    }
                }
            }
        });
        
        gridIcon = new ImageIcon("grid.png");
        setGridLayoutButton = new JToggleButton(gridIcon);
        setGridLayoutButton.setSelected(true);        
        setGridLayoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setLayout(ImageCollectionModel.LayoutType.GRID_LAYOUT);
            }
        });
        
        listIcon = new ImageIcon("list.png");
        setListLayoutButton = new JToggleButton (listIcon);
        setListLayoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {   
                model.setLayout(ImageCollectionModel.LayoutType.LIST_LAYOUT);
            }
        });     
        ButtonGroup layoutGroup = new ButtonGroup();
        layoutGroup.add(setGridLayoutButton);
        layoutGroup.add(setListLayoutButton);
        titleLabel = new JLabel("Fotag!");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        
        setLayoutPanel = new JPanel();
        setLayoutPanel.add(setGridLayoutButton);
        setLayoutPanel.add(setListLayoutButton);
        setLayoutPanel.add(load);
        this.add(setLayoutPanel, BorderLayout.LINE_START);
        
        filterPanel = new RatingPanel(model);
        model.addObserver(filterPanel);
        this.add(filterPanel, BorderLayout.LINE_END);
        
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        this.add(titlePanel, BorderLayout.CENTER);      
    }
    
    @Override
    public void update(Observable o, Object obj) {
        
    }
    
}