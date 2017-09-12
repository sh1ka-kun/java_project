package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

public class CreateGroupTests extends BaseMethods {

    @Test
    public void createGroup() throws InterruptedException {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("Test1", "test1", "test1"));
    }
}
