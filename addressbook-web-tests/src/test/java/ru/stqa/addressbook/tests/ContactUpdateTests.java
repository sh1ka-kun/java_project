package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactUpdateTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        if(app.contact().list().size() == 0) {
            app.contact().create(new ContactData().
                    withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").withMobilePhone("156"));
        }
    }

    @Test
    public void UpdateContactTests() throws InterruptedException {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData().
                withId(before.get(index).getId()).withFirstName("updfirstName").withLastName("updlastName").
                withEmail("updemail@com").withAddress("updaddress").withMobilePhone("156156");
        app.contact().update(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }


}
