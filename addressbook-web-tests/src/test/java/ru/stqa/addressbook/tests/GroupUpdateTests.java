package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupUpdateTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("name").withFooter("footer").withHeader("header"));
        }
    }

    @Test
    public void UpdateGroupTests() throws InterruptedException {

        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("updname").withFooter("updfooter").withHeader("updheader");
        app.group().update(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }


}
