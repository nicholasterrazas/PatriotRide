
import java.time.LocalTime;
import java.time.LocalDate;

public class Post {
    
    private String description;
    private LocalDate date;
    private LocalTime time;
    // gives zipcode of origin/destination
    private int originZip;
    private int destZip;
    private int rating;
    
    public Post() {
    
    }
    
    public Post(String description, LocalDate date, LocalTime time, int originZip, int destZip) {
    	this.description = description;
      this.date = date;
      this.time = time;
      this.originZip = originZip;
      this.destZip = destZip;
    }
    
    public String getDescription() {
    	return this.description;
    }
    
    public void setDescription(String description){
    	this.description = description;
    } 
    
    public void setDate(LocalDate date){
    	this.date = date;
    }
    
    public LocalDate getDate(){
    	return this.date
    }
    
    public void setTime(LocalTime time){
    	this.time = time;
    }
    
    public LocalTime getTime(){
    	return this.time;
    }
    
    
    
}


