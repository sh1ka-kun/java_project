package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactDeleteTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        if(app.contact().list().size() == 0) {
            app.contact().create(new ContactData().
                    withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").withMobilePhone("156"));
        }
    }

    @Test
    public void DeleteContactTests() throws InterruptedException {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
    }


}
