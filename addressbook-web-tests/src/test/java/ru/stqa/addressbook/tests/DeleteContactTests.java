package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContactTests extends BaseMethods {

    @Test
    public void DeleteContactTests() throws InterruptedException {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeletion();
    }
}
