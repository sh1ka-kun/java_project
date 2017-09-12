package ru.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

public class UpdateGroupTests extends BaseMethods {

    @Test
    public void UpdateGroupTests() throws InterruptedException {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Test1", "test1", "test1"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickGroupUpdate();
        app.getGroupHelper().fillGroupForm(new GroupData("ModTest1", "Modtest1", "Modtest1"));
        app.getGroupHelper().SubmitGroupUpdate();
        app.getGroupHelper().returnToGroupPage();
    }
}
