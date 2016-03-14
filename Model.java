import java.util.Observable;

public class Model extends Observable {
   
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