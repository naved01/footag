import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class ImageCollectionView extends JPanel implements Observer {
    
    ImageCollectionModel model;
    ImageCollectionModel.LayoutType layout;
    ArrayList<ImageView> imageViews;
    
    public ImageCollectionView(ImageCollectionModel model_) {
        model = model_;
        imageViews = new ArrayList<ImageView>();
        setCurrentLayout(model.getLayout());
       for (int i = 0; i < model.numImages(); i++) {
           ImageModel imageModel = model.getImage(i);
           ImageView imageView = new ImageView(imageModel);
           imageModel.addObserver(imageView);
           imageViews.add(imageView);
           this.add(imageView);
       }
    }
    
    public void setCurrentLayout(ImageCollectionModel.LayoutType layout) {
        this.layout = layout;
        if (layout == ImageCollectionModel.LayoutType.LIST_LAYOUT) {
            setLayout(new BoxLayout(ImageCollectionView.this, BoxLayout.Y_AXIS));
        } else if (layout == ImageCollectionModel.LayoutType.GRID_LAYOUT) {
            setLayout(new FlowLayout(FlowLayout.LEFT));
        }
    }
    
    @Override 
    public void update(Observable o, Object obj) {

        removeAll();

        if (model.numImages() > imageViews.size()) {
           ImageModel imageModel = model.getImage(model.numImages() - 1);
           ImageView imageView = new ImageView(imageModel);
           imageViews.add(imageView); 
           imageModel.addObserver(imageView);
           //imageModel.addObserver(this);
        }
        
        setCurrentLayout(model.getLayout());  
        
        for (int i = 0; i < imageViews.size(); i++) {
            if (imageViews.get(i).getRating() >= model.getRating()) {
                this.add(imageViews.get(i));
            }   
        }        
        
        revalidate();
        repaint();       
    }
    
}