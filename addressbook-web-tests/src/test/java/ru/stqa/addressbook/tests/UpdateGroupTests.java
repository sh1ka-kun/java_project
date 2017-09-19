package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UpdateGroupTests extends BaseMethods {

    @Test
    public void UpdateGroupTests() throws InterruptedException {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Test1", "test1", "test1"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().clickGroupUpdate();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(), "ModTest1", "Modtest1", "Modtest1");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().SubmitGroupUpdate();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
