package org.ContactManager;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.function.Predicate;

public class ContactFinder {

    private final static Logger logger = Logger.getLogger(ContactFinder.class);
    private List<Contact> contactList;
    private Predicate<Contact> searchPredicate;

    public ContactFinder(Predicate<Contact> searchPredicate, List<Contact> contactList) {
        this.contactList = contactList;
        this.searchPredicate = searchPredicate;

        if (logger.isDebugEnabled()) {
            logger.debug("Search list " + contactList);
        }
    }

    public void showResult() {
        contactList.stream()
                .filter(searchPredicate)
                .forEach(f -> f.formatedContact());
    }
}


