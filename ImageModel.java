import java.util.Observable;
import java.util.Date;
import java.io.File;

public class ImageModel extends Observable {
    
    private int rating;
    private String name;
    private String path;
    private Date creationDate;
    
    private static int duplicateIndex = 0;
    
    public ImageModel(String path) {
        //TODO: check if path is valid
        name = "awesome_photo(" + duplicateIndex + ").jpg";  //TODO: change to extracting name from path identifier
        this.path = path;
        creationDate = new Date();
        rating = 0;
    }
    
    public ImageModel(String path, Date creationDate) {
        name = "awesome_photo(" + duplicateIndex + ").jpg";  //TODO: encapsulare        
        this.path = path;
        this.creationDate = creationDate;  //TODO: check if the creationDate is correct
        this.rating = 0;      
    }
    
    public ImageModel(String name, String path, Date creationDate) {
        this.name = name; // check extension (by calling function)
        this.path = path;
        this.creationDate = creationDate;
        this.rating = 0;      
    }
    
    public ImageModel(String name, String path, Date creationDate, int rating) {
        this.name = name; //check if the name contains extension. else pull from the path
        this.path = path;
        this.creationDate = creationDate;
        this.rating = rating;
    }
    
    public ImageModel(File image) {
        this.name = "unknown";
        this.path = image.getAbsolutePath();
        this.creationDate = new Date();
        this.rating = 0;
    }
    
    public int getRating() {
        return rating;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPath() {
        return path;
    }
    
    public String getCreationDate() {
        return creationDate.toString();
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
}