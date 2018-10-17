package org.ContactManager;

public interface ContactSource {

    // Read from source data and write to AdressBook contactList
    void read();
    // Read from AdressBook contactList and write to destination
    void write();
}




