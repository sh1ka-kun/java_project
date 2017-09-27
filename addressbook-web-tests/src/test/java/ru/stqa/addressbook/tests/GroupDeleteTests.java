package ru.stqa.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.addressbook.data.GroupData;
import ru.stqa.addressbook.data.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTests extends BaseMethods {

    @BeforeTest
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("name").withFooter("footer").withHeader("header"));
        }
    }

    @Test
    public void DeleteGroupTests() throws InterruptedException {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size() - 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(deletedGroup)));
    }


}
