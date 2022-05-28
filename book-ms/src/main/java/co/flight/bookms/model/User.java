package co.flight.bookms.model;

import org.springframework.data.mongodb.core.mapping.Document;

//@Document("test_user")
public class User {

    String firstName;
    String lastName;
    String gender;
    String contact;
    String date_of_journey;
    public User(String firstName, String lastName, String gender, String contact, String date_of_journey) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.contact = contact;
        this.date_of_journey = date_of_journey;
    }
    // //String address;
    public User() {
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    @Override
    public String toString() {
        return "User [contact=" + contact + ", firstName=" + firstName + ", gender=" + gender + ", lastName=" + lastName
                + "]";
    }
    
    
}
