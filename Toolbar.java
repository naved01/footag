import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements Observer {
    
    //ImageCollectionModel model;
    JLabel titleLabel, filterByLabel;
    JPanel setLayoutPanel, starsPanel, titlePanel;
    JButton setGridLayoutButton, setListLayoutButton, ratingStar;
    
    Toolbar(/*ImageCollectionModel model_ */) { 

        setPreferredSize(new Dimension(700, 100));
        setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //model = model_;

        ratingStar = new JButton("star");        
        setGridLayoutButton = new JButton("Grid");
        setListLayoutButton = new JButton("List");
        
        titleLabel = new JLabel("Fotag!");
        filterByLabel = new JLabel("Filter by: ");

        setLayoutPanel = new JPanel();
        setLayoutPanel.add(setGridLayoutButton);
        setLayoutPanel.add(setListLayoutButton);
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