import java.util.*;
public class StudentRep extends Student {
  
  //driver tings. vroom.
  private double rating;
  private ArrayList<Integer> ratings;
  private boolean favorited;
  private boolean blocked;
  private Student student;
  
  public StudentRep() {
    student = new Student();
  }
  
  public StudentRep(double rating, boolean favorited, boolean blocked, Student student) {
        this.rating = rating;
        this.favorited = favorited;
        this.blocked = blocked;
        this.student = student;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
  
		public double rate(int rating) {
    	// get user rating 1-5
      // add rating to rating list and calculate avg rating
      if (rating < 0 || rating > 5) {
      	throw IllegalArgumentException("Invalid user rating.");
      }
      ratings.add(rating);
      
    }  
  
  	private double avgRatings() {
      if (ratings.size==0) {
        throw IllegalStateException("No ratings :/");
      }
      double ray = 0;
      for(int i = 0; i < ratings.size(); i++) {
        ray+=ratings.get(i);
      }
      
      rating = ray / ratings.size();
      return rating;
    }
  
  
  
  
}
