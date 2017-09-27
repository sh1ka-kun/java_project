package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;
import ru.stqa.addressbook.data.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactUpdateTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        if(app.contact().all().size() == 0) {
            app.contact().create(new ContactData().
                    withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").withMobilePhone("156"));
        }
    }

    @Test
    public void UpdateContactTests() {

        Contacts before = app.contact().all();
        ContactData updatedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(updatedContact.getId()).withFirstName("updfirstName").withLastName("updlastName").
                withEmail("updemail@com").withAddress("updaddress").withMobilePhone("156156");
        app.contact().update(contact);
        assertThat(app.group().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(updatedContact).withAdded(contact)));
    }


}
