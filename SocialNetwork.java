public class SocialNetwork {
    public static void main(String[] args){
        NetworkGraph theSlap = new NetworkGraph();

        // Add users 
        theSlap.addUser("Alice");
        theSlap.addUser("Bob");
        theSlap.addUser("Sam");











        // Add friendships
        theSlap.addFriendship("Alice", "Bob");
        theSlap.addFriendship("Bob", "Sam");







        //prirnt the network
        theSlap.displayNetwork();
    }





}