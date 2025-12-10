import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class NetworkGraph {
    // Mappps usernames to Users objects
    private Map<String, Users> userMap = new HashMap<>();

    public void addUser(String username) {
        if (!userMap.containsKey(username)) {
            userMap.put(username, new Users(username));
        }
    }
    public void addFriendship(String username1, String username2) {
        Users user1 = userMap.get(username1);
        Users user2 = userMap.get(username2);
        if (user1 != null && user2 != null) {
            user1.addFriend(username2);

            
        }else{
            System.out.println("One or both users not found in the network.");
        }

    }

    // people you may know method
    public void peopleYouMayKnow(String username){
        Users user = userMap.get(username);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        Set<String> suggestions = new HashSet<>();
        for (String friendName: user.getFriends()) {
            Users friend = userMap.get(friendName);
            if(friend != null) {
                for (String fof : friend.getFriends()) {
                    if (!fof.equals(username) && !user.getFriends().contains(fof)) {
                        suggestions.add(fof);
                    }
                }
            }
        }
        System.out.println("People you may know for " + username + ": " + suggestions);
    }

    public Users getUser(String username) {
        return userMap.get(username);
    }

    // Display network structure
    public void displayNetwork() {
        for (Users user : userMap.values()) {
            System.out.println(user);
        }
    }
}