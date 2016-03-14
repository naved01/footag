
import java.util.ArrayList;

public class ImageCollectionModel extends Model {
    
    private static final long serialVersionUID = 1L;
    
    public static enum LayoutType {
        GRID_LAYOUT, 
        LIST_LAYOUT
    };

    private LayoutType layout;    
    private boolean filterEnabled;
    private ArrayList<ImageModel> images;

    public ImageCollectionModel() {
        filterEnabled = false;
        layout = LayoutType.GRID_LAYOUT;  
        images = new ArrayList<ImageModel>();        
    }

    public void loadModel(ImageCollectionModel model) {
        this.images = model.images;
        this.layout = model.layout;
        this.filterEnabled = model.filterEnabled;
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
        setChanged();
        notifyObservers();        
    }
    
    public LayoutType getLayout() {
        return this.layout;
    }
    
    public int numImages() {
        return images.size();
    }
    
    public boolean isFilterEnabled() {
        return filterEnabled;
    }
    
    public void setFilterEnabled(boolean filterEnabled) {
        this.filterEnabled = filterEnabled;
        setChanged();
        notifyObservers(); 
    } 
    
}