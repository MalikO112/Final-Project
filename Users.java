import java.util.ArrayList;
import java.util.List;

public class Users {
 public static void main(String[] args) {
  /*
   System.out.println("Hello, Users!");
    Users user = new Users("Bob");
    user.addFriend("Alice");
    System.out.println(user.toString());
  */ 
}

    private String username;
    private List<String> friends;

    public Users(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }
    public List<String> getFriends() {
        return friends;
    }
    public void addFriend(String friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Users users = (Users) obj;
        return username.equals(users.username);
    }
    @Override
    public int hashCode() {
        return username.hashCode();
    }
    @Override
    public String toString() {
        return "Users{" +
                "Username='" + username + '\'' +
                ", Friends=" + friends +
                '}';
    }
    

}
