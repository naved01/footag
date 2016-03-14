
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

public class ImageModel extends Model {
    
    private String name;
    private String path;
    private Date creationDate;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private static int duplicateIndex = 0;
     
    public ImageModel(File image) {  
        super();     
        this.name = image.getName();
        if (name.length() > 12) {
            String extension = "";
            int i = name.lastIndexOf('.');
            if (i > 0) {
                extension = name.substring(i+1);
            }
            name = name.substring(0, 6) + "..." + extension; 
        }
        this.path = image.getAbsolutePath();
        this.creationDate = new Date(image.lastModified());
        this.rating = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPath() {
        return path;
    }
    
    public String getCreationDate() {
        return dateFormat.format(creationDate).toString();
        
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