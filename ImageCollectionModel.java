
import java.util.Observable;
import java.util.ArrayList;

public class ImageCollectionModel extends Observable {
    
    private ArrayList<ImageModel> images;
    
    public ImageCollectionModel() {       
        images = new ArrayList<ImageModel>();        
    }

    public ArrayList<ImageModel> getImages() {
        return images;
    }
    
    public void addImage(ImageModel image) {
        images.add(image);
    }
    
    public void deleteAllImages() {
        images.clear();
    }
    
}