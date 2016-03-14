import java.util.Observable;
import java.io.Serializable;

public class Model extends Observable implements Serializable {
   
    int rating;
    
    Model() {
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
}