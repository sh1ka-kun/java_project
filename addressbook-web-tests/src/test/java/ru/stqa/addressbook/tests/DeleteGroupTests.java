package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTests extends BaseMethods {

    @Test
    public void DeleteGroupTests() throws InterruptedException {
        Thread.sleep(100);
        app.getNavigationHelper().gotoGroupPage();
        Thread.sleep(100);
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}
