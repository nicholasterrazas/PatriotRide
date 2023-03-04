import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * The type Student.
 */
public class Student {

    // contact
    private String email;
    private String firstName;
    private String lastName;
    private int zipCode;

    // roles
    private boolean isDriver;
    private boolean isRider;

    // reputation
    private double rating;
    private boolean isFavorite;
    private boolean isBlocked;

    // lists
    private final ArrayList<Student> favoriteUsers;
    private final ArrayList<Student> blockedUsers;
    private final ArrayList<Post> posts;


    /**
     * Instantiates a new Student.
     */
    public Student() {
        this("", "", "", 0, false, false, 0.00, false, false, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    /**
     * Instantiates a new Student.
     *
     * @param email         the email
     * @param firstName     the first name
     * @param lastName      the last name
     * @param zipCode       the zip code
     * @param isDriver      the is driver
     * @param isRider       the is rider
     * @param rating        the rating
     * @param isFavorite    the is favorite
     * @param isBlocked     the is blocked
     * @param favoriteUsers the favorite users
     * @param blockedUsers  the blocked users
     * @param posts         the posts
     */
    public Student(String email, String firstName, String lastName, int zipCode, boolean isDriver, boolean isRider, double rating, boolean isFavorite, boolean isBlocked, ArrayList<Student> favoriteUsers, ArrayList<Student> blockedUsers, ArrayList<Post> posts) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.isDriver = isDriver;
        this.isRider = isRider;
        this.rating = rating;
        this.isFavorite = isFavorite;
        this.isBlocked = isBlocked;
        this.favoriteUsers = favoriteUsers;
        this.blockedUsers = blockedUsers;
        this.posts = posts;
    }

    public Boolean isDriver() {
        return isDriver;
    }

    public void setDriver(Boolean choice) {
        this.isDriver = choice;
    }

    public Boolean isRider() {
        return isRider;
    }

    public void setRider(Boolean choice) {
        this.isRider = choice;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set student email.
     * Email format must be valid and belong to "gmu.edu" domain.
     *
     * @param email to be assigned to student
     */
    public void setEmail(String email) {
        String getDomain = getEmailDomain(email);
        // email format must be valid and domain must be "gmu.edu"
        if (!isValidEmail(email) || !getDomain.equals("gmu.edu")) {
            throw new IllegalArgumentException("Invalid email address.");
        } else {
            this.email = email;
        }
    }

    /**
     * Validates email format.
     *
     * @param email the email to be validated
     * @return true for valid email, false otherwise
     */
    private static boolean isValidEmail(String email) {
        // create the EmailValidator instance
        EmailValidator validator = EmailValidator.getInstance();
        // check for valid email addresses using isValid method
        return validator.isValid(email);
    }

    /**
     * Extracts the email domain.
     *
     * @param email the email to extract domain from
     * @return the domain of the given email
     */
    private String getEmailDomain(String email) {
        return email.substring((email.indexOf("@") + 1));
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Set student zipcode.
     * Zipcode format must be valid. We trim it to 5 digits for simplicity.
     *
     * @param zipCode to be assigned to student.
     */
    public void setZipCode(String zipCode) {
        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zipCode);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid zipcode.");
        } else {
            String zip = zipCode.substring(0, 5);
            this.zipCode = Integer.parseInt(zip);
        }
    }

    /**
     * Create post.
     */
    public void createPost() {
        //call Post constructor 	
        //add to list
    }

    /**
     * Delete post boolean.
     *
     * @return the boolean
     */
    public boolean deletePost() {
        return false;
        //posts.remove(p);
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Invalid rating");
        } else {
            this.rating = rating;
        }
    }

    /**
     * Is favorite boolean.
     *
     * @return the boolean
     */
    public boolean isFavorite() {
        return isFavorite;
    }

    /**
     * Set Favorite student.
     *
     * @param student the student
     * @throws IllegalArgumentException if already in favorites
     */
    public void setFavorite(Student student) {
        // add favorite to student's list to be displayed in MyAccount
        if (!student.isFavorite && !favoriteUsers.contains(student)) {
            favoriteUsers.add(student);
            student.isFavorite = true;
        } else {
            throw new IllegalArgumentException("User already in Favorites list.");
        }
    }

    /**
     * Unset Favorite student.
     *
     * @param student the student
     * @throws IllegalArgumentException if not in favorites
     */
    public void unsetFavorite(Student student) {
        // remove favorite from student's list to be removed from MyAccount
        if (student.isFavorite && favoriteUsers.contains(student)) {
            favoriteUsers.remove(student);
            student.isFavorite = false;
        } else {
            throw new IllegalArgumentException("User not in Favorites list.");
        }
    }

    /**
     * Is blocked boolean.
     *
     * @return the boolean
     */
    public boolean isBlocked() {
        return isBlocked;
    }

    /**
     * Report student.
     *
     * @param user the user
     */
    public void reportStudent(Student user) {
        // how should we handle a reported student?
    }

    /**
     * Set Block student.
     *
     * @param student the student
     * @throws IllegalArgumentException if already blocked
     */
    public void setBlocked(Student student) {
        // add blocked to student's list to be displayed in MyAccount
        if (!student.isBlocked && !blockedUsers.contains(student)) {
            blockedUsers.add(student);
            student.isBlocked = true;
        } else {
                throw new IllegalArgumentException("User already in Blocked list.");
        }
    }

    /**
     * Unset Block student.
     *
     * @param student the student
     * @throws IllegalArgumentException if not blocked
     */
    public void unsetBlocked(Student student) {
        // add blocked to student's list to be displayed in MyAccount
        if (student.isBlocked && blockedUsers.contains(student)) {
            blockedUsers.remove(student);
            student.isBlocked = false;
        } else {
            throw new IllegalArgumentException("User not in Blocked list.");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student\n");
        sb.append("Name: ").append(getFullName()).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Zipcode: ").append(zipCode).append("\n");
        sb.append("Driver: ").append(isDriver).append("\n");
        sb.append("Rider: ").append(isRider).append("\n");
        sb.append("Rating: ").append(rating).append("\n");
        sb.append("Favorite: ").append(isFavorite).append("\n");
        sb.append("Blocked: ").append(isBlocked).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getZipCode() == student.getZipCode() && getEmail().equals(student.getEmail()) && getFirstName().equals(student.getFirstName()) && getLastName().equals(student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getFirstName(), getLastName(), getZipCode());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Oscar");
        student.setLastName("Garcia");
        student.setEmail("ogarcia6@gmu.edu");
        student.setZipCode("22031");
        student.setDriver(true);
        student.setRider(false);
        student.setRating(3.5);
        student.setFavorite(student);
        student.setBlocked(student);
        System.out.println(student);
    }
}