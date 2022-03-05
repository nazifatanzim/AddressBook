import AddressBook.BuddyInfo;
import junit.framework.TestCase;

public class BuddyInfoTest extends TestCase {
    private BuddyInfo buddy;

    @Override
    public void setUp() throws Exception {
        buddy = new BuddyInfo("bob", "1");
    }

    public void testGetPhoneNumber() {
        assertEquals("1", this.buddy.getPhoneNumber());
    }

    public void testSetPhoneNumber() {
        this.buddy.setPhoneNumber("123-456-7890");
        assertEquals("123-456-7890", this.buddy.getPhoneNumber());
    }

    public void testTestGetName() {
        assertEquals("bob", this.buddy.getName());
    }

    public void testTestSetName() {
        this.buddy.setName("nazifa");
        assertEquals("nazifa", this.buddy.getName());
    }
}