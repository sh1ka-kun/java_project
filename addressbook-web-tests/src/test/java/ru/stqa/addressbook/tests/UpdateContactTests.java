package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;

public class UpdateContactTests extends BaseMethods {

    @Test
    public void UpdateContactTests() throws InterruptedException {
        app.getContactHelper().selectContact();
        app.getContactHelper().clickContactUpdate();
        app.getContactHelper().fillContactForm(new ContactData("1", "2", "3", "4", "5"));
        app.getContactHelper().SubmitContactUpdate();
        app.getContactHelper().returnToHomePage();
    }
}
