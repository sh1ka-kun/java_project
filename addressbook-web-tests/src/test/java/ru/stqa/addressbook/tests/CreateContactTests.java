package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.addressbook.data.ContactData;

public class CreateContactTests extends BaseMethods {

    @Test
    public void CreateContactTests() {
        app.getContactHelper().clickAddContact();
        app.getContactHelper().fillContactForm(new ContactData("Nail", "Tuishev", "Nagornaya, 15", "89093223232", "mail@gmail.com"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

}
