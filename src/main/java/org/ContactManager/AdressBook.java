package org.ContactManager;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdressBook {

    final static Logger logger = Logger.getLogger(AdressBook.class);
    protected static List<Contact> contactList = new ArrayList<>();
    public List<Contact> getContactList() {
        return contactList;
    }

   public static void setContactList(List<Contact> contactList) {
        AdressBook.contactList = contactList;
    }

    public void addContact(Contact contact) {

        if (logger.isDebugEnabled()) {
            logger.debug("List View" + contactList.toString());
            logger.debug("Saving contact to list" + contact.toString());
        }
        contactList.add(contact);
        if (logger.isDebugEnabled()) {
            logger.debug("Widok Listy " + contactList.toString());
        }
    }

    public boolean removeContact(Integer contactId) {
        List<Integer> idCheckList = contactList
                .stream()
                .map(Contact::getContactId)
                .collect(Collectors.toList());
        if (idCheckList.contains(contactId)) {
            contactList = contactList
                    .stream()
                    .filter(l -> l.getContactId() != contactId)
                    .collect(Collectors.toList());
            return true;
        }
        return false;
    }
}
