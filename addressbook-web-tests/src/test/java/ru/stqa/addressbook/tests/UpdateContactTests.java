package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.GroupData;

import java.util.Comparator;
import java.util.List;

public class UpdateContactTests extends BaseMethods {

    @Test
    public void UpdateContactTests() throws InterruptedException {

        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Nail", "Tuishev", "Nagornaya, 15", "89093223232", "mail@gmail.com"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().clickContactUpdate(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"1", "2", "3", "4", "5");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactUpdate();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
