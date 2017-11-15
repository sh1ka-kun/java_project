package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ContactPhonesTests extends BaseMethods {


    @BeforeTest
    public void ensurePreconditions(){
        if(app.contact().all().size() == 0) {
            app.contact().create(new ContactData().
                    withFirstName("firstName").withLastName("lastName").withEmail("email@com").withAddress("address").
                    withHomePhone("123").withMobilePhone("456").withWorkPhone("789"));
        }
    }

    @Test
    public void contactPhoneTest(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).
                stream().filter((s -> !s.equals(""))).
                map(ContactPhonesTests::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
