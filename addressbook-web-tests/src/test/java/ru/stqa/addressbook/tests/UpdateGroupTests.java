package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

public class UpdateGroupTests extends BaseMethods {

    @Test
    public void UpdateGroupTests() throws InterruptedException {
        Thread.sleep(100);
        app.getNavigationHelper().gotoGroupPage();
        Thread.sleep(100);
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickGroupUpdate();
        app.getGroupHelper().fillGroupForm(new GroupData("ModTest1", "Modtest1", "Modtest1"));
        app.getGroupHelper().SubmitGroupUpdate();
        app.getGroupHelper().returnToGroupPage();
    }
}
