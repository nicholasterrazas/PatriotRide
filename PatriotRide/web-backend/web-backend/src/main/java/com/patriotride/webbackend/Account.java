//do we need dis? idk. maybe later on. im talking to myself. no one is gonna find this.
import java.util.*;
                 
public class Account {
  
  private Student owner;
  private int accountID;
  
  //Should be similar to that within the student thingy. Yk what im sayin?
  private List<Post> history;
  private List<Student> favorites;
  private List<Student> blocked;
  
  public Account() {}
  
  public Account(Student owner, int accountID) {
    this.owner = owner;
    this.accountID = owner;
    history = new ArrayList<>();
    favorites = new ArrayList<>();
    blocked = new ArrayList<>();
  }
  
  
}

