package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreateTests extends BaseMethods {

    @Test
    public void createGroup() throws InterruptedException {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("name").withFooter("footer").withHeader("header");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Assert.assertEquals(after, before);
    }
}
