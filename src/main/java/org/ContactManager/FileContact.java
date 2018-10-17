package org.ContactManager;

import org.apache.log4j.Logger;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileContact extends AdressBook implements ContactSource {

    final static Logger logger = Logger.getLogger(FileContact.class);
    private static final String filename = "org.ContactManager.AdressBook.csv";
    private File file = new File(filename);
    private CsvFormatter csvFormatter = new CsvFormatter(";");
    private Scanner scanner;
    private BufferedWriter bufferedWriter;
    private String line;
    private List<String> tokens;

    @Override
    public void read() {
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                tokens = csvFormatter.getTokens(scanner.nextLine());
                contactList.add(convertTokensToContact(tokens));
                //Static method (Contact.setId) call to set contact id-indexer after reading AdressBook file
                Contact.setId(contactList
                        .stream()
                        .map(l -> l.getContactId())
                        .mapToInt(Integer::intValue)
                        .max().getAsInt());

            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read from file.. exiting");
            System.exit(1);
        }
    }

    private Contact convertTokensToContact(List<String> arrayList) {

        Contact contact = new Contact(
                Integer.valueOf(arrayList.get(0)),
                arrayList.get(1),
                arrayList.get(2),
                arrayList.get(3),
                arrayList.get(4),
                arrayList.get(5),
                arrayList.get(6),
                arrayList.get(7));
        return contact;
    }

    @Override
    public void write() {

        if (logger.isDebugEnabled()) {
            logger.debug("Contact List " + contactList.toString());
        }
        // Change to java 7 try with resources (how)
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Contact contact : contactList) {
                line = csvFormatter.convContactToCsvEntity(contact);
                bufferedWriter.write(line);
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Cannot write to file.. exiting");
            System.exit(1);
        }
    }
}
