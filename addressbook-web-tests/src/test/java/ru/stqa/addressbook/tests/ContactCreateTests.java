package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreateTests extends BaseMethods {

    @Test
    public void CreateContactTests() throws InterruptedException {
        ContactData contact = new ContactData().
                withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").withMobilePhone("156");
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
