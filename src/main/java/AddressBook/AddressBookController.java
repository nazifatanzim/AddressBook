package AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The controller
 */
@Controller
public class AddressBookController {
    @GetMapping("/addressbook")
    public String addressBookForm(Model model){
        model.addAttribute("addressbook", new AddressBook());
        return "addressbook";
    }

    @PostMapping("/addressbook")
    public String addressBookSubmit(@ModelAttribute BuddyInfo buddy, Model model){
        model.addAttribute(buddy);
        return "buddy";
    }
}
