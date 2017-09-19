package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.GroupData;

import java.util.Comparator;
import java.util.List;

public class CreateContactTests extends BaseMethods {

    @Test
    public void CreateContactTests() throws InterruptedException {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().clickAddContact();
        ContactData contact = new ContactData("Nail", "Tuishev", "Nagornaya, 15", "89093223232", "mail@gmail.com");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }

}
