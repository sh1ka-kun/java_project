package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        if(app.contact().all().size() == 0) {
            app.contact().create(new ContactData().
                    withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").withMobilePhone("156"));
        }
    }

    @Test
    public void DeleteContactTests() throws InterruptedException {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }


}
