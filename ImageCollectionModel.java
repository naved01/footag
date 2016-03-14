
import java.util.ArrayList;

public class ImageCollectionModel extends Model {
    
    private static final long serialVersionUID = 1L;

    private ArrayList<ImageModel> images;

    public ImageCollectionModel() {  
        super();
        images = new ArrayList<ImageModel>();        
    }

    public void loadModel(ImageCollectionModel model) {
        this.images = model.images;
        setLayout(LayoutType.GRID_LAYOUT);
        setChanged();
        notifyObservers();
    }

    public ImageModel getImage(int a) {
        if (a < 0 || a >= images.size()) {
            System.out.println("index out of bound");
            return null;
        }
        
        return images.get(a);
    }
    
    public void addImage(ImageModel image) {
        images.add(image);
        setChanged();
        notifyObservers();        
    }
    
    public void deleteAllImages() {
        images.clear();
        setChanged();
        notifyObservers();
    }
    
    public void setLayout(LayoutType layout) {
        this.layout = layout;
        for (int i = 0; i < images.size(); i++) {
            images.get(i).setLayout(layout);
        }
        setChanged();
        notifyObservers();        
    } 
    
    public int numImages() {
        return images.size();
    }
    
}