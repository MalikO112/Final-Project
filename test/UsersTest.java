import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UsersTest {
 
    


    @Test
    void testAddFriend() {
        Users user = new Users("Alice");
        user.addFriend("Bob");
        Assertions.assertTrue(user.getFriends().contains("Bob"));

        // adding same friend again should not duplicate
        user.addFriend("Bob");
        Assertions.assertEquals(1, user.getFriends().size());
    }

    @Test
    void testEqualsAndHashCode() {
        Users a = new Users("Alice");
        Users b = new Users("Alice");
        Assertions.assertEquals(a, b);
        Assertions.assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void testToStringContainsUsernameAndFriends() {
        Users user = new Users("Alice");
        user.addFriend("Bob");
        String s = user.toString();
        Assertions.assertTrue(s.contains("Alice"));
        Assertions.assertTrue(s.contains("Bob"));
    }
}
