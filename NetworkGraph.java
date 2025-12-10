import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String, Integer> peopleYouMayKnow(String username){
        Users user = userMap.get(username);
        if (user == null) {
            System.out.println("User not found");
            return null;
        }

        Map<String, Integer> suggestions = new HashMap<>();//
        for (String friendName: user.getFriends()) {
            Users friend = userMap.get(friendName);
            if(friend != null) {
                for (String fof : friend.getFriends()) {
                    if (!fof.equals(username) && !user.getFriends().contains(fof)) {
                        suggestions.put(fof, suggestions.getOrDefault(fof, 0) + 1);
                    }
                }
            }
        }
        System.out.println(username);
        return suggestions;
    }
    public List<String> SortedPeopleYouMayKnow(Map<String, Integer> suggestions) {
        List<String> sortedSuggestions = new ArrayList<>(suggestions.keySet());// Get the keys from the map
        
        // Sort based on the number of mutual friends in alphabetical order
        sortedSuggestions.sort((a, b) -> {
            int countCompare = suggestions.get(b).compareTo(suggestions.get(a));
            if (countCompare != 0) {
                return countCompare; // Sort by count descending
            } else {
                return a.compareTo(b); // Sort alphabetically if counts are equal
            }
        });
        System.out.println("People you may know: "+ sortedSuggestions);
        return sortedSuggestions;
       


       
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