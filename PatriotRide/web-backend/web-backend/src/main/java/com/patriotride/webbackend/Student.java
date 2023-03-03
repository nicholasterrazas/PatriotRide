import java.util.Objects;
import java.util.*;


public class Student {
   
    private String netid;
    private String firstName;
    private String lastName;
    private int zipCode;
    private String role;
  
  //reps
    private double rating;
  	private ArrayList<Student> favoriteUsers;
  	private ArrayList<Student> blockedUsers;
  
    private ArrayList<Post> posts;
		  

    public Student() {

    }


    public Student(String netid, String firstName, String lastName, int zipCode) {
        this.netid = netid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
      
      	this.favoritesUsers = new ArrayList<>();
        this.blockedUsers = new ArrayList<>();
      	this.posts = new ArrayList<>();
    }


    public String getNetid() {
        return netid;
    }

  
  	// WORKING ON THIS RN - OG
  	// ok - ej
    public void setNetid(String netid) {
        // enter netid, format: netid@gmu.edu 
        // autofill “@gmu.edu” part
        // validate input; check for accidental user input like uid@gmu.edu@gmu.edu
        // in other words if netid.contains(“@gmu.edu”) remove that part of the
        // string
        if (!netid.contains(“@gmu.edu”)) {
            this.netid = netid.concat(“@gmu.edu”);
        }

        else if (netid.contains("@") {
            // what if user entered @gmail.com ?
            // need to remove after @ but forgot how to rn
            this.netid = netid;
        }
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        // validate first name (no numbers, symbols or spaces in name)
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        // validate last name (no numbers, symbols or spaces in name)   
        this.lastName = lastName;
    }


    public int getZipCode() {
        return zipCode;
    }


    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    public void createPost() {
      	
        //call Post constructor 	
        //add to list
        //boom. we done
      	
    }


    public boolean deletePost(Post p) {
        posts.remove(p);
    }
                 
    public double getRating(StudentRep student) {
      this.rating = student.getRating();
    }
                 
                 
    public void favoriteStudent(Student student, StudentRep rep) {
    	// add favorite to student's list to be displayed in MyAccount
      if (!rep.isFavorited()) {
        favoriteUsers.add(student);
      } else {
        // this is probably not the correct exception but i'll use it as a placeholder for now
        throw new Exception("User is already in your Favorites.");
      }
      
    }
    
    public void reportStudent(Student user) {
    	
  	}
		
    public void blockStudent(Student user) {
      blockedUsers.add(user);
    }

    @Override
    public String toString() {
    return "Student{" +
            "netid='" + netid + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", zipcode='" + zipCode + '\'' +
            '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(netid, student.netid) && Objects.equals(firstName, student.firstName) &&
        Objects.equals(lastName, student.lastName) && Objects.equals (zipCode, student.zipCode);
    }


    @Override
    public int hashCode() {
        return Objects.hash(netid, firstName, lastName, zipCode);
    }
}
