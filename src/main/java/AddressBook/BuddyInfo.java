package AddressBook;

import java.io.Serializable;

public class BuddyInfo implements Serializable {

    private String name;

    private String phoneNumber;

    public BuddyInfo() {

    }

    public BuddyInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // many to one
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof BuddyInfo)) return false;
        BuddyInfo b = (BuddyInfo) obj;
        return ((b.getName().equals(this.name)) && (b.getPhoneNumber().equals(this.phoneNumber)));
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nPhone Number: " + this.phoneNumber;
    }
}