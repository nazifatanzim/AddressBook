package AddressBook;

import java.io.Serializable;
import java.util.ArrayList;

public class AddressBook implements Serializable{

    private ArrayList<BuddyInfo> buddyInfoList;

    public AddressBook() {
        this.buddyInfoList = new ArrayList<BuddyInfo>();
    }

    // one to many - mapped by name
    public ArrayList<BuddyInfo> getBuddyInfoList(){
        return this.buddyInfoList;
    }

    public void setBuddyInfoList(ArrayList<BuddyInfo> b){
        this.buddyInfoList = b;
    }

    /**
     *
     * @param b
     */
    public void addBuddy(BuddyInfo b) {
        buddyInfoList.add(b);
    }

    /**
     *
     * @param b
     */
    public void removeBuddy(BuddyInfo b) {
        for(BuddyInfo buddy : this.buddyInfoList) {
            if(buddy.equals(b)) {
                this.buddyInfoList.remove(buddy);
            }
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public BuddyInfo getBuddyWithName(String name) {
        for(BuddyInfo buddy : this.buddyInfoList) {
            if(buddy.getName().equals(name)) {
                return buddy;
            }
        }
        System.out.println("BUDDY NOT IN BOOK");
        // TODO change so it doesn't return null if buddy doesn't exist
        return null;
    }

    /**
     *
     * @return
     */
    public int getBookSize() {
        return buddyInfoList.size();
    }

    /**
     * Puts buddy infos in the proper format for a JTable
     * @return
     */
    public String[][] getArrayRepresentation(){
        int size = this.getBookSize();
        int i = size;
        String[][] buddies = new String[size][2];
        for(BuddyInfo b : this.getBuddyInfoList()){
            int index = size - i;
            buddies[index][0] = b.getName();
            buddies[index][1] = b.getPhoneNumber();
        }
        return buddies;
    }

    @Override
    public String toString() {
        String s = new String();
        for(BuddyInfo buddy : this.buddyInfoList) {
            s += buddy.getName() + ", " +
                    buddy.getPhoneNumber() + "\n";
        }
        return s;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("bob", "1");
        BuddyInfo buddy2 = new BuddyInfo("joe", "2");
        BuddyInfo buddy3 = new BuddyInfo("nazifa", "3");

        AddressBook book = new AddressBook();
        book.addBuddy(buddy);
        book.addBuddy(buddy2);
        book.addBuddy(buddy3);

        System.out.println("Address Book: ");
        System.out.println(book.toString());
    }
}
