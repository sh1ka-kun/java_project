package ru.stqa.addressbook.data;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String email;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
