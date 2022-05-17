package co.flight.checkinms.model;

public class User {

    String firstName;
    String lastName;
    String gender;
    String contact;
    String date_of_journey;
    //String address;
    
    public User(String firstName, String lastName, String gender, String contact, String date_of_journey) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.contact = contact;
        this.date_of_journey = date_of_journey;
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

    public String getDate_of_journey() {
        return date_of_journey;
    }

    public void setDate_of_journey(String date_of_journey) {
        this.date_of_journey = date_of_journey;
    }

    @Override
    public String toString() {
        return "User [contact=" + contact + ", date_of_journey=" + date_of_journey + ", firstName=" + firstName
                + ", gender=" + gender + ", lastName=" + lastName + "]";
    }

    
    
}

