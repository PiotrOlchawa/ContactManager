package org.ContactManager;

import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.function.Predicate;

public class MainMenu {

    private final static Logger logger = Logger.getLogger(MainMenu.class);
    private Scanner scanner = new Scanner(System.in);
    private Contact contact;
    private ContactSource contactSource = new FileContact();

    //Populate org.ContactManager.AdressBook with fake data
   /* static {
        org.ContactManager.AdressBook.contactList.add(new org.ContactManager.Contact("Adam", "Walewski","ul Szopena 2","33100","12","504563193","adam.walewski@onet.pl"));
        org.ContactManager.AdressBook.contactList.add(new org.ContactManager.Contact("Waldemar", "Dzikus","ul Warska 5","00342","","606543944","waldek.dziki@wp.pl"));
        org.ContactManager.AdressBook.contactList.add(new org.ContactManager.Contact("Ryszard", "Bugaj","ul Drewsko 3","22344","5","574635234","ryszard.b@gmail.com"));
        org.ContactManager.AdressBook.contactList.add(new org.ContactManager.Contact("Aneta", "Płaczek","ul Kniazia 22","33234","","502921388","aneta.p@nazwa.pl"));
    }*/

    private void msg(String message) {
        System.out.println(message);
    }

    private void readContacts() {
        contactSource.read();
    }

    private void selectMainMenuOption() {
        msg("");
        msg("Add new contact (a)");
        msg("Delete contact (d)");
        msg("Find contact (f)");
        msg("Show contact (s)");
        msg("Save and exit (x)");
        msg("\nSelect option and press Enter");
        processSelectedAction(scanner.nextLine().charAt(0));
    }

    private void processSelectedAction(char action) {
        switch (action) {

            case 'a':
                this.add();
                selectMainMenuOption();
                break;
            case 'd':
                show();
                msg("Enter Id");
                this.remove();
                //selectMainMenuOption();
                break;
            case 'f':
                this.find();
                selectMainMenuOption();
                break;
            case 's':
                this.show();
                selectMainMenuOption();
                break;
            case 'x':
                this.save();
                break;
            default:
                msg("Incorrect choice... Try Again.");
                processSelectedAction(scanner.nextLine().charAt(0));
        }
    }

    private void add() {
        contact = new Contact();
        msg("Please enter your first name");
        contact.setFirstName(scanner.nextLine());
        msg("Please enter your last name");
        contact.setLastName(scanner.nextLine());
        msg("Please enter your street adress");
        contact.setStreetAdress(scanner.nextLine());
        msg("Please enter your zip code");
        contact.setZipCode(scanner.nextLine());
        msg("Please enter your apartament number");
        contact.setAptNumber(scanner.nextLine());
        msg("Please enter your telephone");
        contact.setTelephone(scanner.nextLine());
        msg("Please enter your email");
        contact.setEmail(scanner.nextLine());
        msg("Adding new entry to adress book...");
        ((AdressBook) contactSource).addContact(contact);
        msg("New entry inserted");
        msg("Returning to main menu.\n");
        selectMainMenuOption();
    }

    private void findActionSubmenu(char selector) {

        switch (selector) {
            case 's':
                msg("Enter last name");
                findLastName();
                selectMainMenuOption();
                break;
/*            case 'f':
                break;*/
            default:
                msg("Incorrect choice... Try again.");
                findActionSubmenu(scanner.nextLine().charAt(0));
        }
    }

    private void remove() {
        try {
            if (((AdressBook) contactSource).removeContact(Integer.valueOf(scanner.nextLine()))) {
                selectMainMenuOption();
                msg("Contact removed");
            } else {
                msg("Specified Contact Id does not exist");
                selectMainMenuOption();
            }
        } catch (NumberFormatException e) {
            msg("Incorrect Id Value. Please try again");
            remove();
        }


    }

    private void save() {
        contactSource.write();
    }

    private void find() {
        msg("Search using:");
        //msg("First name press (f)");
        msg("Last name press (s)");
        findActionSubmenu(scanner.nextLine().charAt(0));
    }

    private void show() {
        Contact.attachContactHeader();
        Predicate<Contact> searchPredicate = l -> true;
        new ContactFinder(searchPredicate, ((AdressBook) contactSource).getContactList())
                .showResult();
    }

    private void findLastName() {
        Predicate<Contact> searchPredicate = l -> (l.getLastName().equals(scanner.nextLine()));
        Contact.attachContactHeader();
        new ContactFinder(searchPredicate, ((AdressBook) contactSource).getContactList())
                .showResult();
    }

    public static void main(String args[]) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.readContacts();
        mainMenu.selectMainMenuOption();
    }
}
