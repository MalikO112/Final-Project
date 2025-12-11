import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.List;

public class NetworkGraphTest {
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    

    

    @Test
    void testAddUserAndGetUser() {
        NetworkGraph g = new NetworkGraph();
        g.addUser("Alice");
        assertNotNull(g.getUser("Alice"));
    }


    @Test
    void testAddFriendshipOneWay() {
        NetworkGraph g = new NetworkGraph();
        g.addUser("Alice");
        g.addUser("Bob");
        g.addFriendship("Alice", "Bob");
        assertTrue(g.getUser("Alice").getFriends().contains("Bob"));
        // current implementation only adds one direction
        assertFalse(g.getUser("Bob").getFriends().contains("Alice"));
    }

    @Test
    void testPeopleYouMayKnowAndSorted() {
        NetworkGraph g = new NetworkGraph();
        g.addUser("A");
        g.addUser("B");
        g.addUser("C");
        g.addUser("D");

        // A->B, B->C, C->D
        g.addFriendship("A", "B");
        g.addFriendship("B", "C");
        g.addFriendship("C", "D");

        Map<String, Integer> suggestions = g.peopleYouMayKnow("A");
        assertNotNull(suggestions);
        // A should be suggested to know C via B
        assertEquals(1, suggestions.size());
        assertEquals(1, suggestions.get("C").intValue());

        List<String> sorted = g.SortedPeopleYouMayKnow(suggestions);
        assertEquals("C", sorted.get(0));
    }
}
