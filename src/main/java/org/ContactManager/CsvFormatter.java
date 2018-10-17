package org.ContactManager;

import org.apache.log4j.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFormatter {

    final static Logger logger = Logger.getLogger(CsvFormatter.class);
    private String separator = ";"; //default separator

    public CsvFormatter(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String convContactToCsvEntity(Contact contact) {

        return Stream.of(String.valueOf(contact.getContactId()),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getStreetAdress(),
                contact.getZipCode(),
                contact.getAptNumber(),
                contact.getTelephone(),
                contact.getEmail(), "\n").collect(Collectors.joining(separator));

    }

    public List<String> getTokens(String line) {
        String[] tokenizeLine = line.split(separator, -1);
        return Arrays.asList(tokenizeLine);
    }

}
