package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTests extends BaseMethods {

    @Test
    public void DeleteGroupTests() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
