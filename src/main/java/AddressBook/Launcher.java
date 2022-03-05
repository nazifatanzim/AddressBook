package AddressBook;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Launcher {
    public void launch() {
        String[] contextPaths = new String[] {"AddressBook/app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}
