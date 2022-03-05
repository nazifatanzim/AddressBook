import AddressBook.AddressBook;
import AddressBook.BuddyInfo;
import junit.framework.TestCase;

public class AddressBookTest extends TestCase {
    private AddressBook book;
    private String expected1, expected2, expected3, expected4;
    private BuddyInfo buddy1, buddy2, buddy3;

    @Override
    public void setUp() throws Exception {
        buddy1 = new BuddyInfo("bob", "1");
        buddy2 = new BuddyInfo("joe", "2");
        buddy3 = new BuddyInfo("nazifa", "3");

        book = new AddressBook();
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        book.addBuddy(buddy3);

        expected1 = "bob, 1\n" +
                "joe, 2\n" +
                "nazifa, 3\n";
        expected2 = "bob, 1\n" +
                "joe, 2\n" +
                "nazifa, 3\n" +
                "tom, 4\n";
        expected3 = "bob, 1\n" +
                "nazifa, 3\n";
        expected4 = "bob, 1\n" +
                "joe, 2\n" +
                "nazifa, 3\n";
    }

    public void testAddBuddy() {
        assertEquals(3, this.book.getBookSize());
        assertEquals(this.expected1, this.book.toString());

        BuddyInfo buddy4 = new BuddyInfo("tom", "4");
        this.book.addBuddy(buddy4);

        assertEquals(this.expected2, this.book.toString());
        assertEquals(4, this.book.getBookSize());
    }

    public void testRemoveBuddy() {
        assertEquals(3, this.book.getBookSize());
        assertEquals(this.expected1, this.book.toString());

        this.book.removeBuddy(this.buddy2);

        assertEquals(this.expected3, this.book.toString());
        assertEquals(2, this.book.getBookSize());
    }

    public void testGetBuddyWithName() {
        assert(this.book.getBuddyWithName("nazifa").equals(this.buddy3));
    }

    public void testGetBookSize() {
        assertEquals(3, this.book.getBookSize());
    }
}