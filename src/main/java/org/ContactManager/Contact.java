package org.ContactManager;

public class Contact {

    private static int id;
    private int contactId;
    private String firstName;
    private String lastName;
    private String streetAdress;
    private String zipCode;
    private String aptNumber;
    private String telephone;
    private String email;

    public static void setId(Integer id){
        Contact.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public Contact(){
        id++;
        this.contactId=id;
    }

    public Contact(String firstName, String lastName, String streetAdress, String zipCode, String aptNumber, String telephone, String email) {
        id++;
        this.contactId=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAdress = streetAdress;
        this.zipCode = zipCode;
        this.aptNumber = aptNumber;
        this.telephone = telephone;
        this.email = email;
    }

    public Contact(int contactId, String firstName, String lastName, String streetAdress, String zipCode, String aptNumber, String telephone, String email) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAdress = streetAdress;
        this.zipCode = zipCode;
        this.aptNumber = aptNumber;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "contactId=" + contactId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAdress='" + streetAdress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void formatedContact() {
        System.out.printf(" %5s %18s %18s %18s %18s %18s %18s %25ss\n",contactId,firstName,lastName,streetAdress,zipCode,aptNumber,telephone,email);
    }

    static void attachContactHeader(){
        System.out.printf(" %5s %18s %18s %18s %18s %18s %18s %25s\n","Id","First name","Last name","Street Adress","Zip Code","Apt. number","Tel","Email");
    }



}
