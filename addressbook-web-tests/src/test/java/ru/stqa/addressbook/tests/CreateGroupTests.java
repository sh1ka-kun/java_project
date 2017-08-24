package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

public class CreateGroupTests extends BaseMethods {

    @Test
    public void createGroup() throws InterruptedException {
        Thread.sleep(100);
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().clickCreateGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1", "test1", "test1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }
}
