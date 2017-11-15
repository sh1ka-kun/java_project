package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactEmailTests extends BaseMethods{
    @BeforeTest
    public void ensurePreconditions(){
        if(app.contact().all().size() == 0) {
            app.contact().create(new ContactData().
                    withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").
                    withHomePhone("123").withMobilePhone("456").withWorkPhone("789"));
        }
    }

    @Test
    public void contactEmailTest(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
    }
}
