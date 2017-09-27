package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.ContactData;

public class ContactPhonesTests extends BaseMethods {

    @Test
    public void contactPhoneTest(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }

}
