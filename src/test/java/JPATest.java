import AddressBook.AddressBook;
import AddressBook.BuddyInfo;

import javax.persistence.*;
import java.util.List;

public class JPATest {
    public static void main(String[] args) {
        // Creating some BuddyInfo objects and an AddressBook
        BuddyInfo buddy1 = new BuddyInfo("bob", "1");
        BuddyInfo buddy2 = new BuddyInfo("joe", "2");
        BuddyInfo buddy3 = new BuddyInfo("nazifa", "3");
        AddressBook book = new AddressBook();

        // Connect to database via EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(buddy1);
        em.persist(buddy2);
        em.persist(buddy3);

        // Query the db BuddyInfo table
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        List<BuddyInfo> buddies = q.getResultList();

        // Iterate through BuddyInfo objects
        int num = 1;
        for(BuddyInfo b : buddies){
            System.out.println("\nBuddy #" + num);
            System.out.println(b.toString());
            num++;
        }

        // Persisting address book
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        book.addBuddy(buddy3);

        em.persist(book);

        et.commit();

        // Query the db AddressBook table
        Query q2 = em.createQuery("SELECT a FROM AddressBook a");
        List<AddressBook> ab = q2.getResultList();

        num = 1;
        for(AddressBook a : ab){
            System.out.println("\nAddress Book " + num);
            for(BuddyInfo b : buddies){
                System.out.println(b.toString());
            }
            num++;
        }

        // Closing connection
        em.close();
        emf.close();
    }
}
