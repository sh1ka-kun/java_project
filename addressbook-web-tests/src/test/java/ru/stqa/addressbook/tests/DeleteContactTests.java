package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.GroupData;

import java.util.HashSet;
import java.util.List;

public class DeleteContactTests extends BaseMethods {

    @Test
    public void DeleteContactTests() throws InterruptedException {
        List<ContactData> before = app.getContactHelper().getContactList();
        if(! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Nail", "Tuishev", "Nagornaya, 15", "89093223232", "mail@gmail.com"));
        }
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeletion();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
    }
}
