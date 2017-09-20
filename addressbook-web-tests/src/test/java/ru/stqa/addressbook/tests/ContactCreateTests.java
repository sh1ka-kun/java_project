package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.addressbook.data.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreateTests extends BaseMethods {

    @Test
    public void CreateContactTests() throws InterruptedException {
        ContactData contact = new ContactData().
                withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").withMobilePhone("156");
        List<ContactData> before = app.contact().list();
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }



}
