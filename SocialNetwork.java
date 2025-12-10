public class SocialNetwork {
    public static void main(String[] args){
        NetworkGraph theSlap = new NetworkGraph();

        // Add users 
        theSlap.addUser("Alice");
        theSlap.addUser("Bob");
        theSlap.addUser("Sam");
        theSlap.addUser("Eve");
        theSlap.addUser("Charlie");
        theSlap.addUser("David");
        theSlap.addUser("Faythe");
        theSlap.addUser("Andrew");
        theSlap.addUser("Grace");
        theSlap.addUser("Samantha");

        // Add friendships
        // Alice friends
        theSlap.addFriendship("Alice", "Bob");
        theSlap.addFriendship("Alice", "Eve");
        theSlap.addFriendship("Alice", "Charlie");
        
        // Bob friends
        theSlap.addFriendship("Bob", "Alice");
        theSlap.addFriendship("Bob", "Andrew");
        theSlap.addFriendship("Bob", "Eve");
        theSlap.addFriendship("Bob", "Samantha");
        // Sam friends
        theSlap.addFriendship("Sam", "Eve");
        theSlap.addFriendship("Sam", "David");
        theSlap.addFriendship("Sam", "Faythe");
        // Eve friends
        theSlap.addFriendship("Eve", "Alice");
        theSlap.addFriendship("Eve", "Bob");
        theSlap.addFriendship("Eve", "Sam");
        // Charlie friends
        theSlap.addFriendship("Charlie", "Alice");
        theSlap.addFriendship("Charlie", "David");
        theSlap.addFriendship("Charlie", "Grace");
        // David friends
        theSlap.addFriendship("David", "Sam");
        theSlap.addFriendship("David", "Charlie");
        theSlap.addFriendship("David", "Andrew");
        // Andrew friends
        theSlap.addFriendship("Andrew", "Bob");
        theSlap.addFriendship("Andrew", "David");
        theSlap.addFriendship("Andrew", "Samantha");
        // faythe friends
        theSlap.addFriendship("Faythe", "Sam");
        theSlap.addFriendship("Faythe", "Charlie");
        theSlap.addFriendship("Faythe", "Grace");
        // Grace friends
        theSlap.addFriendship("Grace", "Charlie");
        theSlap.addFriendship("Grace", "Faythe");
        theSlap.addFriendship("Grace", "Samantha");
        // Samantha friends
        theSlap.addFriendship("Samantha", "Grace");
        theSlap.addFriendship("Samantha","Andrew");
        theSlap.addFriendship("Samantha", "Bob");

        //prirnt the network
        theSlap.displayNetwork();

        // Test people you may know
        theSlap.peopleYouMayKnow("Alice");
    }

}