package ru.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupDeleteTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("name").withFooter("footer").withHeader("header"));
        }
    }

    @Test
    public void DeleteGroupTests() throws InterruptedException {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));
    }


}
