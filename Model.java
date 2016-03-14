import java.util.Observable;
import java.io.Serializable;

public class Model extends Observable implements Serializable {
   
    public static enum LayoutType {
        GRID_LAYOUT, 
        LIST_LAYOUT
    };
    protected LayoutType layout;        
    int rating;
    
    Model() {
        layout = LayoutType.GRID_LAYOUT;        
        rating = 0;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
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
     
}